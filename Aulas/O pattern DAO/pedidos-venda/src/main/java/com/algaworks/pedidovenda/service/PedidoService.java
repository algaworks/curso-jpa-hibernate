package com.algaworks.pedidovenda.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import com.algaworks.pedidovenda.dao.PedidoDAO;
import com.algaworks.pedidovenda.model.ItemPedido;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class PedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoDAO pedidoDAO;
	
	@Transactional
	public void salvar(Pedido pedido) {
		BigDecimal valorTotal = BigDecimal.ZERO;
		
		if (pedido.getItensPedido() != null) {
			for (ItemPedido item : pedido.getItensPedido()) {
				valorTotal = valorTotal.add(item.getValor()
												.multiply(new BigDecimal(item.getQuantidade())));
			}
		}
		
		pedido.setValorTotal(valorTotal);
		
		if (pedido.getCodigo() == null) {
			pedido.setDataVenda(new Date());
		}
		
		this.pedidoDAO.salvar(pedido);
	}
	
}
