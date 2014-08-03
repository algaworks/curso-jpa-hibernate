package com.algaworks.notafiscal.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.notafiscal.model.Cidade;
import com.algaworks.notafiscal.model.Estado;
import com.algaworks.notafiscal.repository.Cidades;
import com.algaworks.notafiscal.repository.Estados;
import com.algaworks.notafiscal.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cidade cidade;
	
	private List<Estado> listaEstados;

	@Inject
	private Cidades cidades;
	
	@Inject
	private Estados estados;

	@PostConstruct
	public void init() {
		this.cidade = new Cidade();
		this.listaEstados = this.estados.todos();
	}

	public void salvar() {
		this.cidade = this.cidades.guardar(this.cidade);
		FacesUtil.addSuccessMessage(String.format("Cidade código %d salva com sucesso.", this.cidade.getCodigo()));
		this.cidade = new Cidade();
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

}
