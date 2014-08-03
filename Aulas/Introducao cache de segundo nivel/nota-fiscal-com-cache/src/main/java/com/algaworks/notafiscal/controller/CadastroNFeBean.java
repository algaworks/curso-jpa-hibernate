package com.algaworks.notafiscal.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.notafiscal.model.Cidade;
import com.algaworks.notafiscal.model.Estado;
import com.algaworks.notafiscal.model.NFe;
import com.algaworks.notafiscal.repository.Cidades;
import com.algaworks.notafiscal.repository.Estados;
import com.algaworks.notafiscal.repository.NotasFiscais;
import com.algaworks.notafiscal.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroNFeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Estado> listaEstados;
	
	private List<Cidade> listaCidadesDoEstado;
	
	private NFe nfe;

	@Inject
	private Cidades cidades;
	
	@Inject
	private Estados estados;
	
	@Inject 
	private NotasFiscais notasFiscais;

	@PostConstruct
	public void init() {
		this.nfe = new NFe();
		this.nfe.setCidade(new Cidade());
		
		this.listaEstados = this.estados.todos();
		this.listaCidadesDoEstado = null;
	}

	public void salvar() {
		this.nfe = this.notasFiscais.guardar(this.nfe);
		FacesUtil.addSuccessMessage(String.format("Nota Fiscal código %d salva com sucesso.", this.nfe.getCodigo()));
		this.init();
	}
	
	public void buscarCidadesDoEstado() {
		this.listaCidadesDoEstado = this.cidades.buscarCidadesPorEstado(this.nfe.getCidade().getEstado());
	}
	
	public NFe getNfe() {
		return nfe;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public List<Cidade> getListaCidadesDoEstado() {
		return listaCidadesDoEstado;
	}
	
}
