package com.algaworks.pedidovenda.dao;

import java.util.List;

import com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia;
import com.algaworks.pedidovenda.model.Pedido;

public interface PedidoDAO extends GenericDAO<Pedido, Long> {

	public List<ValorTotalVendaDoDia> buscarValorTotalVendaDoDia();
	
}
