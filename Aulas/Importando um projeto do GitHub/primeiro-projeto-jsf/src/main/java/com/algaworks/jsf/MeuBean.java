package com.algaworks.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MeuBean implements Serializable {

	private String nome;

	public void transformar() {
		this.nome = this.nome.toUpperCase();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
