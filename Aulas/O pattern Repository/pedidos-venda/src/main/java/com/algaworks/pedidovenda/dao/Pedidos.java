package com.algaworks.pedidovenda.dao;

import java.util.List;

import com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia;
import com.algaworks.pedidovenda.model.ItemPedido;
import com.algaworks.pedidovenda.model.Pedido;

public interface Pedidos {

	public List<ValorTotalVendaDoDia> valoresTotaisDasVendasPorDia();
	public List<ItemPedido> itensPendentes();
	public List<Pedido> filtrar(PedidoFiltro filtro);
	public Pedido peloCodigo(Long codigo);
	public void adicionar(Pedido pedido);
	
}
