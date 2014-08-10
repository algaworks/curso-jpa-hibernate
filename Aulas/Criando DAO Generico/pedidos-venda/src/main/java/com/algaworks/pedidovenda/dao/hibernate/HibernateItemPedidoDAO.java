package com.algaworks.pedidovenda.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.dao.ItemPedidoDAO;
import com.algaworks.pedidovenda.model.Entrega;
import com.algaworks.pedidovenda.model.ItemPedido;

public class HibernateItemPedidoDAO extends HibernateGenericDAO<ItemPedido, Long> implements ItemPedidoDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<ItemPedido> buscarItensPendentes() {
		Criteria criteria = getSession().createCriteria(ItemPedido.class);
	    
	    criteria.createAlias("pedido", "p")
	      .add(Restrictions.eq("p.entrega", Entrega.PENDENTE));
	    
	    return criteria.list();
	}
	
}
