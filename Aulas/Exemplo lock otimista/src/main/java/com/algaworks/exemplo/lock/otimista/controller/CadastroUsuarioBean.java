package com.algaworks.exemplo.lock.otimista.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.exemplo.lock.otimista.dao.UsuarioDAO;
import com.algaworks.exemplo.lock.otimista.model.Usuario;
import com.algaworks.exemplo.lock.otimista.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;
	
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
	}
	
	public void buscar() {
		try {
			this.usuario = this.usuarioDAO.buscarPeloCodigo(this.usuario.getCodigo());
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		try {
			this.usuario = this.usuarioDAO.salvar(this.usuario);
			FacesUtil.addSuccessMessage("Usuário salvo com sucesso.");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
