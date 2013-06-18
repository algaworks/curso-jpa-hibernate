package com.algaworks.curso.jpa2.locadora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Aluguel;

public class AluguelDAO {

	@Inject EntityManager em;
	
	public void salvar(Aluguel aluguel) {
		this.em.persist(aluguel);
	}
}
