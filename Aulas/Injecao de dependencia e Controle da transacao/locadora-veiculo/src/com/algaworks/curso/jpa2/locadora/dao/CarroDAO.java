package com.algaworks.curso.jpa2.locadora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class CarroDAO {

	@Inject EntityManager em;
	
	public void salvar(Carro carro) {
		this.em.persist(carro);
	}
	
	public Carro buscarPeloCodigo(Long codigo) {
		Carro carro = this.em.find(Carro.class, codigo);
		return carro;
	}
	
}
