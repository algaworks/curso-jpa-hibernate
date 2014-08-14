package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.dao.Pedidos;
import com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia;

@ViewScoped
@Named
public class ValorVendasPorDiaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ValorTotalVendaDoDia> vendas;
	
	@Inject
	private Pedidos pedidos;
	
	public void buscarValorTotalVendaDoDia() {
		this.vendas = pedidos.valoresTotaisDasVendasPorDia();
	}

	public List<ValorTotalVendaDoDia> getVendas() {
		return vendas;
	}
	
}
