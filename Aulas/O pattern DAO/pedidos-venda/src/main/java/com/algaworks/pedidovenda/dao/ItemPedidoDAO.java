package com.algaworks.pedidovenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.model.Entrega;
import com.algaworks.pedidovenda.model.ItemPedido;

public class ItemPedidoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<ItemPedido> buscarItensPendentes() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ItemPedido.class);
	    
	    criteria.createAlias("pedido", "p")
	      .add(Restrictions.eq("p.entrega", Entrega.PENDENTE));
	    
	    return criteria.list();
	}
	
}
