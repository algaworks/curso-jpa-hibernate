package com.algaworks.pedidovenda.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import com.algaworks.pedidovenda.dao.PedidoDAO;
import com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia;
import com.algaworks.pedidovenda.model.Pedido;

public class HibernatePedidoDAO extends HibernateGenericDAO<Pedido, Long> implements PedidoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<ValorTotalVendaDoDia> buscarValorTotalVendaDoDia() {
		return getEntityManager().createQuery("select "
		          + "NEW com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia(p.dataVenda, sum(p.valorTotal)) "
		          + "from Pedido p "
		          + "group by p.dataVenda", ValorTotalVendaDoDia.class)
		        .getResultList();
	}
	
}
