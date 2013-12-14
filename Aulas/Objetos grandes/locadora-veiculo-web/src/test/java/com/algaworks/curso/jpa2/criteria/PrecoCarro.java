package com.algaworks.curso.jpa2.criteria;

import java.math.BigDecimal;

public class PrecoCarro {

	private String placa;
	private BigDecimal valor;
	
	public PrecoCarro(String placa, BigDecimal valor) {
		this.placa = placa;
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
