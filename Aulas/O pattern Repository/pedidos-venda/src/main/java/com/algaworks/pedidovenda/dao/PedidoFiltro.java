package com.algaworks.pedidovenda.dao;

import java.io.Serializable;

import com.algaworks.pedidovenda.model.Entrega;

public class PedidoFiltro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String referencia;
	private Entrega entrega;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

}
