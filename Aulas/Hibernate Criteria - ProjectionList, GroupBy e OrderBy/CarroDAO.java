package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.util.TotalDeAlugueisPorCarro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Carro buscarPeloCodigo(Long codigo) {
		return (Carro) manager.createQuery("select c from Carro c inner join fetch c.modelo where c.codigo = :codigo")
				.setParameter("codigo", codigo)
				.getSingleResult();
		//return manager.find(Carro.class, codigo);
	}
	
	public void salvar(Carro carro) {
		manager.merge(carro);
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos() {
		return manager.createNamedQuery("Carro.buscarTodos").getResultList();
	}
	
	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		carro = buscarPeloCodigo(carro.getCodigo());
		
		try {
			manager.remove(carro);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Carro não pode ser excluído.");
		}
	}

	public Carro buscarCarroComAcessorios(Long codigo) {
		return manager.createNamedQuery("Carro.buscarCarroComAcessorios", Carro.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Carro.buscarTodos")
							.setFirstResult(first)
							.setMaxResults(pageSize)
							.getResultList();
	}

	public Long encontrarQuantidadeDeCarros() {
		return manager.createQuery("select count(c) from Carro c", Long.class).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarCarrosNuncaAlugados() {
		Session session = this.manager.unwrap(Session.class);
	    Criteria criteria = session.createCriteria(Carro.class); 
		/*
		 * select * 
  			from carro
  			where codigo not in (
  				select codigo_carro from aluguel 
  					where codigo_carro is not null)
		 */
	    
	    DetachedCriteria criteriaAluguel = DetachedCriteria.forClass(Aluguel.class)
	    	.setProjection(Projections.property("carro"))
	    	.add(Restrictions.isNotNull("carro"));
	    
	    criteria.add(Property.forName("codigo").notIn(criteriaAluguel));
	    
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<TotalDeAlugueisPorCarro> buscarTotalAlugueisPorCarro() {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		
		criteria.createAlias("alugueis", "a");
		
		ProjectionList pl = Projections.projectionList()
								.add(Projections.groupProperty("placa").as("placa"))
								.add(Projections.count("a.codigo").as("totalDeAlugueis"));
		criteria.setProjection(pl)
			.addOrder(Order.desc("totalDeAlugueis"))
			.setResultTransformer(Transformers.aliasToBean(TotalDeAlugueisPorCarro.class));
		
		return criteria.list();
	}

	
	
}



















