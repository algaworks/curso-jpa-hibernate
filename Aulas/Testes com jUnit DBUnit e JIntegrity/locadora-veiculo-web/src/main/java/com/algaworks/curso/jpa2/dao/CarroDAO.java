package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Carro buscarPeloCodigo(Long codigo) {
		return manager.find(Carro.class, codigo);
	}
	
	public void salvar(Carro carro) {
		manager.merge(carro);
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos() {
		return manager.createNamedQuery("Carro.buscarTodos").getResultList();
	}
	
	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		carro = buscarPeloCodigo(carro.getCodigo());
		
		try {
			manager.remove(carro);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Carro não pode ser excluído.");
		}
	}

	public Carro buscarCarroComAcessorios(Long codigo) {
		return manager.createNamedQuery("Carro.buscarCarroComAcessorios", Carro.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Carro.buscarTodos")
							.setFirstResult(first)
							.setMaxResults(pageSize)
							.getResultList();
	}

	public Long encontrarQuantidadeDeCarros() {
		return manager.createQuery("select count(c) from Carro c", Long.class).getSingleResult();
	}
	
	public void setEntityManager(EntityManager manager) {
		this.manager = manager;
	}
	
}
