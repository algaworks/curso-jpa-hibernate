package com.algaworks.gerenciador.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.algaworks.gerenciador.model.Usuario;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigoUsuario;
	
	private Usuario usuario;
	
	@Inject
	private EntityManager manager;

	public void pesquisar() {
		this.usuario = this.manager.find(Usuario.class, this.codigoUsuario);
	}
	
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
}
