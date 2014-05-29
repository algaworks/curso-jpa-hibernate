package com.algaworks.curso.jpa2.modelo.util;

import java.io.Serializable;

public class TotalDeAlugueisPorCarro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String placa;
	private Long totalDeAlugueis;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getTotalDeAlugueis() {
		return totalDeAlugueis;
	}

	public void setTotalDeAlugueis(Long totalDeAlugueis) {
		this.totalDeAlugueis = totalDeAlugueis;
	}

}
