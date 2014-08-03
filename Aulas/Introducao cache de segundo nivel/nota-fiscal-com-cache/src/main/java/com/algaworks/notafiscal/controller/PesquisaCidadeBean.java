package com.algaworks.notafiscal.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.notafiscal.model.Cidade;
import com.algaworks.notafiscal.repository.Cidades;

@Named
@ViewScoped
public class PesquisaCidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Cidade> listaCidades;
	
	@Inject
	private Cidades cidades;
	
	@PostConstruct
	public void init() {
		this.listaCidades = this.cidades.todas();
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}
	
}
