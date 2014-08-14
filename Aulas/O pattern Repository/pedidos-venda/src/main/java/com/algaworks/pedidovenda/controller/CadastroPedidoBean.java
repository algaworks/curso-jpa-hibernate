package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Entrega;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.service.PedidoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@ViewScoped
@Named
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedido pedido;

	private List<Entrega> entregas;
	
	@Inject
	private PedidoService pedidoService;
	
	public CadastroPedidoBean() {
		limpar();
	}
	
	public void salvar() {
		this.pedidoService.salvar(pedido);
		FacesUtil.addSuccessMessage("Pedido salvo com sucesso!");
		limpar();
	}

	public void limpar() {
		this.pedido = new Pedido();
		this.entregas = Arrays.asList(Entrega.values());
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

}
