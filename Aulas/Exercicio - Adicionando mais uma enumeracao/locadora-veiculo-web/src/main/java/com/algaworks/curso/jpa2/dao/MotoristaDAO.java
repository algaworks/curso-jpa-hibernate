package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class MotoristaDAO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Motorista buscarPeloCodigo(Long codigo) {
		return manager.find(Motorista.class, codigo);
	}
	
	public void salvar(Motorista motorista) {
		manager.merge(motorista);
	}

	@SuppressWarnings("unchecked")
	public List<Motorista> buscarTodos() {
		return manager.createQuery("from Motorista").getResultList();
	}
	
	@Transactional
	public void excluir(Motorista motorista) throws NegocioException {
		motorista = buscarPeloCodigo(motorista.getCodigo());
		try {
			manager.remove(motorista);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Motorista não pode ser excluído.");
		}
	}
}
