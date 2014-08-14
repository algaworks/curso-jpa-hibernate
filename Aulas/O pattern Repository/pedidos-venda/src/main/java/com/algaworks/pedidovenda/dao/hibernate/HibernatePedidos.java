package com.algaworks.pedidovenda.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.dao.PedidoFiltro;
import com.algaworks.pedidovenda.dao.Pedidos;
import com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia;
import com.algaworks.pedidovenda.model.Entrega;
import com.algaworks.pedidovenda.model.ItemPedido;
import com.algaworks.pedidovenda.model.Pedido;

public class HibernatePedidos implements Pedidos, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<ValorTotalVendaDoDia> valoresTotaisDasVendasPorDia() {
		return manager.createQuery("select "
		          + "NEW com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia(p.dataVenda, sum(p.valorTotal)) "
		          + "from Pedido p "
		          + "group by p.dataVenda", ValorTotalVendaDoDia.class)
		        .getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPedido> itensPendentes() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ItemPedido.class);
	    
	    criteria.createAlias("pedido", "p")
	      .add(Restrictions.eq("p.entrega", Entrega.PENDENTE));
	    
	    return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> filtrar(PedidoFiltro filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pedido.class);
		if (filtro.getCodigo() != null) {
			criteria.add(Restrictions.eq("codigo", filtro.getCodigo()));
		}
		
		if (filtro.getReferencia() != null && !filtro.getReferencia().trim().equals("")) {
			criteria.add(Restrictions.ilike("referencia", filtro.getReferencia(), MatchMode.ANYWHERE));
		}
		
		if (filtro.getEntrega() != null) {
			criteria.add(Restrictions.eq("entrega", filtro.getEntrega()));
		}
		
		return criteria.list();
	}

	@Override
	public Pedido peloCodigo(Long codigo) {
		return manager.find(Pedido.class, codigo);
	}

	@Override
	public void adicionar(Pedido pedido) {
		manager.merge(pedido);
	}
	
}
