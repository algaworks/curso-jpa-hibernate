package com.algaworks.pedidovenda.dao;

import java.util.List;

import com.algaworks.pedidovenda.model.ItemPedido;

public interface ItemPedidoDAO extends GenericDAO<ItemPedido, Long> {

	public List<ItemPedido> buscarItensPendentes();
	
}
