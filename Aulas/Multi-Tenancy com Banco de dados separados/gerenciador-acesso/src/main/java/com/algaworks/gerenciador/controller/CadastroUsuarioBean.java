package com.algaworks.gerenciador.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import org.hibernate.Session;

import com.algaworks.gerenciador.model.Status;
import com.algaworks.gerenciador.model.Usuario;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Session session;
	
	private Usuario usuario = new Usuario();
	
	public void salvar() {
		try {
			session.getTransaction().begin();
			session.merge(usuario);
			session.getTransaction().commit();
			usuario = new Usuario();
		} catch (Exception e) {
			throw new RuntimeException("Erro salvando usuario", e);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Status> getStatusList() {
		return Arrays.asList(Status.values());
	}
	
}
