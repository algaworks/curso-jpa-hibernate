package com.algaworks.curso.jpa2.locadora.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class FabricanteDAO {

	private EntityManager em;
	
	public FabricanteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Fabricante fabricante) {
		this.em.getTransaction().begin();
		this.em.persist(fabricante);
		this.em.getTransaction().commit();
	}
	
	public Fabricante buscarPeloCodigo(Long codigo) {
		return this.em.find(Fabricante.class, codigo);
	}
	
}
