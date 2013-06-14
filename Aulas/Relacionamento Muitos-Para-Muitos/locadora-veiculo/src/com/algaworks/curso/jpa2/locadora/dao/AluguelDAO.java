package com.algaworks.curso.jpa2.locadora.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Aluguel;

public class AluguelDAO {

	private EntityManager em;
	
	public AluguelDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Aluguel aluguel) {
		this.em.getTransaction().begin();
		this.em.persist(aluguel);
		this.em.getTransaction().commit();
	}
}
