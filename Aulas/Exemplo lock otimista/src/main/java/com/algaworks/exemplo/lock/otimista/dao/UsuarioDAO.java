package com.algaworks.exemplo.lock.otimista.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;

import com.algaworks.exemplo.lock.otimista.exception.NegocioException;
import com.algaworks.exemplo.lock.otimista.model.Usuario;
import com.algaworks.exemplo.lock.otimista.util.jpa.Transactional;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		try {
			usuario = this.manager.merge(usuario);
			return usuario;
		} catch (OptimisticLockException e) {
			throw new NegocioException("Erro de concorrência. Esse usuário já foi alterado anteriormente.");
		}
	}
	
	public Usuario buscarPeloCodigo(Long codigo) {
		Usuario usuario = this.manager.find(Usuario.class, codigo);
		
		if (usuario == null) {
			throw new NegocioException("Usuário não encontrado.");
		}
		return usuario;
	}

}
