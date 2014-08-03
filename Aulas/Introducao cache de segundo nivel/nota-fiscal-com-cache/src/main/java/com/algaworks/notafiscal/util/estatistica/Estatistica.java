package com.algaworks.notafiscal.util.estatistica;

import java.io.Serializable;

public class Estatistica implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String descricao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
