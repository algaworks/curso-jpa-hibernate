package com.algaworks.curso.jpa2.locadora.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;

public class AcessorioDAO {

	private EntityManager em;

	public AcessorioDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Acessorio acessorio) {
		this.em.getTransaction().begin();
		this.em.persist(acessorio);
		this.em.getTransaction().commit();
	}
	
	public Acessorio buscarPeloCodigo(Long codigo) {
		return this.em.find(Acessorio.class, codigo);
	}
	
}
