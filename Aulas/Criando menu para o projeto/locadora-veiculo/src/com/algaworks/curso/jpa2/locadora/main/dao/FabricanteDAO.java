package com.algaworks.curso.jpa2.locadora.main.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class FabricanteDAO {

	private EntityManager em;
	
	public FabricanteDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Fabricante fabricante) {
		em.getTransaction().begin();
		em.persist(fabricante);
		em.getTransaction().commit();
	}
	
}
