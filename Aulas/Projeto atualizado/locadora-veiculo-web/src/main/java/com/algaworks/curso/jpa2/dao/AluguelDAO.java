package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class AluguelDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(Aluguel aluguel) {
		manager.merge(aluguel);
	}

	public List<Aluguel> buscarPorDataDeEntregaEModeloCarro(Date dataEntrega,
			ModeloCarro modelo) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Aluguel> criteriaQuery = builder.createQuery(Aluguel.class);
		Root<Aluguel> a = criteriaQuery.from(Aluguel.class);
		criteriaQuery.select(a);
		
		List<Predicate> predicates = new ArrayList<>();
		if (dataEntrega != null) {
			ParameterExpression<Date> dataEntregaInicial = builder.parameter(Date.class, "dataEntregaInicial");
			ParameterExpression<Date> dataEntregaFinal = builder.parameter(Date.class, "dataEntregaFinal");
			predicates.add(builder.between(a.<Date>get("dataEntrega"), dataEntregaInicial, dataEntregaFinal));
		}
		
		if (modelo != null) {
			ParameterExpression<ModeloCarro> modeloExpression = builder.parameter(ModeloCarro.class, "modelo");
			predicates.add(builder.equal(a.get("carro").get("modelo"), modeloExpression));
		}
		
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Aluguel> query = manager.createQuery(criteriaQuery);
		
		if (dataEntrega != null) {
			Calendar dataEntregaInicial = Calendar.getInstance();
			dataEntregaInicial.setTime(dataEntrega);
			dataEntregaInicial.set(Calendar.HOUR_OF_DAY, 0);
			dataEntregaInicial.set(Calendar.MINUTE, 0);
			dataEntregaInicial.set(Calendar.SECOND, 0);
			
			Calendar dataEntregaFinal = Calendar.getInstance();
			dataEntregaFinal.setTime(dataEntrega);
			dataEntregaFinal.set(Calendar.HOUR_OF_DAY, 23);
			dataEntregaFinal.set(Calendar.MINUTE, 59);
			dataEntregaFinal.set(Calendar.SECOND, 59);
			
			query.setParameter("dataEntregaInicial", dataEntregaInicial.getTime());
			query.setParameter("dataEntregaFinal", dataEntregaFinal.getTime());
		}
		
		if (modelo != null) {
			query.setParameter("modelo", modelo);
		}
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluguel> buscarPorDataDeEntregaEModeloCarroCriteria(Date dataEntrega,
			ModeloCarro modelo) {
		
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Aluguel.class);
		
		if (dataEntrega != null) {
			criteria.add(Restrictions.between("dataEntrega"
					, geraDataInicial(dataEntrega), geraDataFinal(dataEntrega)));
		}
		
		if (modelo != null) {
			criteria.createAlias("carro", "c");
			criteria.add(Restrictions.eq("c.modelo", modelo));
		}
		
		return criteria.list();
	}
	
	private Date geraDataInicial(Date dataEntrega) {
		Calendar dataEntregaInicial = Calendar.getInstance();
		dataEntregaInicial.setTime(dataEntrega);
		dataEntregaInicial.set(Calendar.HOUR_OF_DAY, 0);
		dataEntregaInicial.set(Calendar.MINUTE, 0);
		dataEntregaInicial.set(Calendar.SECOND, 0);
		
		return dataEntregaInicial.getTime();
	}
	
	private Date geraDataFinal(Date dataEntrega) {
		Calendar dataEntregaFinal = Calendar.getInstance();
		dataEntregaFinal.setTime(dataEntrega);
		dataEntregaFinal.set(Calendar.HOUR_OF_DAY, 23);
		dataEntregaFinal.set(Calendar.MINUTE, 59);
		dataEntregaFinal.set(Calendar.SECOND, 59);
		
		return dataEntregaFinal.getTime();
	}

	public BigDecimal calcularTotalDoMesDe(int mes) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Aluguel.class);
		
		criteria.setProjection(Projections.sum("valorTotal"));
		criteria.add(Restrictions.sqlRestriction("month(dataPedido) = ?", mes, StandardBasicTypes.INTEGER));
		
		return (BigDecimal) criteria.uniqueResult();
	}

}



