package com.algaworks.notafiscal.util.estatistica;

import java.io.Serializable;
import java.util.List;

public class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private List<Estatistica> estatisticas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estatistica> getEstatisticas() {
		return estatisticas;
	}

	public void setEstatisticas(List<Estatistica> estatisticas) {
		this.estatisticas = estatisticas;
	}

}
