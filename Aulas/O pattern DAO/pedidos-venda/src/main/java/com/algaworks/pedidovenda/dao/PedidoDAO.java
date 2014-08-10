package com.algaworks.pedidovenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia;
import com.algaworks.pedidovenda.model.Pedido;

public class PedidoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(Pedido pedido) {
		manager.merge(pedido);
	}

	public List<ValorTotalVendaDoDia> buscarValorTotalVendaDoDia() {
		return manager.createQuery("select "
		          + "NEW com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia(p.dataVenda, sum(p.valorTotal)) "
		          + "from Pedido p "
		          + "group by p.dataVenda", ValorTotalVendaDoDia.class)
		        .getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> filtrar(Pedido pedido) {
	    Session session = manager.unwrap(Session.class);
	    Criteria criteria = session.createCriteria(Pedido.class);
	    
	    if (pedido.getCodigo() != null) {
	    	criteria.add(Restrictions.eq("codigo", pedido.getCodigo()));
	    }
	    
	    if (pedido.getReferencia() != null && !pedido.getReferencia().trim().equals("")) {
	    	criteria.add(Restrictions.ilike("referencia", pedido.getReferencia(), MatchMode.ANYWHERE));
	    }
	    
	    if (pedido.getEntrega() != null) {
	    	criteria.add(Restrictions.eq("entrega", pedido.getEntrega()));
	    }
	    	
	    return criteria.list();
	  }
	
	public Pedido buscarPeloCodigo(Long codigo) {
		return manager.find(Pedido.class, codigo);
	}
	
}
