package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Acessorio buscarPeloCodigo(Long codigo) {
		return manager.find(Acessorio.class, codigo);
	}
	
	public void salvar(Acessorio fabricante) {
		manager.merge(fabricante);
	}

	public List<Acessorio> buscarTodos() {
		return manager.createQuery("from Acessorio", Acessorio.class).getResultList();
	}
	
	@Transactional
	public void excluir(Acessorio fabricante) throws NegocioException {
		fabricante = buscarPeloCodigo(fabricante.getCodigo());
		try {
			manager.remove(fabricante);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Acessorio não pode ser excluído.");
		}
	}
	
}
