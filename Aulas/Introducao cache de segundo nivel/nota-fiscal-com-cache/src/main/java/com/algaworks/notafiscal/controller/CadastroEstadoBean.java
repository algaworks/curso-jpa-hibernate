package com.algaworks.notafiscal.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.notafiscal.model.Estado;
import com.algaworks.notafiscal.repository.Estados;
import com.algaworks.notafiscal.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroEstadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estado estado;

	@Inject
	private Estados estados;
	
	@PostConstruct
	public void init() {
		this.estado = new Estado();
	}

	public void salvar() {
		this.estado = this.estados.guardar(this.estado);
		FacesUtil.addSuccessMessage(String.format("Estado código %d salvo com sucesso.", this.estado.getCodigo()));
		this.estado = new Estado();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
