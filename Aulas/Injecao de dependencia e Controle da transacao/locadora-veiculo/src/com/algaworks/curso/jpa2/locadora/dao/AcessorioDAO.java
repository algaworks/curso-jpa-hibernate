package com.algaworks.curso.jpa2.locadora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;

public class AcessorioDAO {

	@Inject 
	EntityManager em;

	public void salvar(Acessorio acessorio) {
		this.em.persist(acessorio);
	}
	
	public Acessorio buscarPeloCodigo(Long codigo) {
		return this.em.find(Acessorio.class, codigo);
	}
	
}
