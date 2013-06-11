package com.algaworks.curso.jpa2.locadora.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class ModeloCarroDAO {

	private EntityManager em;
	
	public ModeloCarroDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(ModeloCarro modeloCarro) {
		this.em.getTransaction().begin();
		this.em.persist(modeloCarro);
		this.em.getTransaction().commit();
	}
	
	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return this.em.find(ModeloCarro.class, codigo);
	}
	
}
