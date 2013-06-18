package com.algaworks.curso.jpa2.locadora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class ModeloCarroDAO {

	@Inject EntityManager em;
	
	public void salvar(ModeloCarro modeloCarro) {
		this.em.persist(modeloCarro);
	}
	
	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return this.em.find(ModeloCarro.class, codigo);
	}
	
}
