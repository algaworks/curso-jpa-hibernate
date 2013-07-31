package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;

public class FabricanteDAO implements Serializable {

	@Inject
	private EntityManager em;
	
	public void salvar(Fabricante fabricante) {
		em.persist(fabricante);
	}
	
}
