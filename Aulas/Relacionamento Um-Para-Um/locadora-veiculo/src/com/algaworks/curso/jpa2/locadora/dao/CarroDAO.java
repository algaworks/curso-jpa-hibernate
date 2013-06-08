package com.algaworks.curso.jpa2.locadora.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class CarroDAO {

	private EntityManager em;
	
	public CarroDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Carro carro) {
		this.em.getTransaction().begin();
		this.em.persist(carro);
		this.em.getTransaction().commit();
	}
	
}
