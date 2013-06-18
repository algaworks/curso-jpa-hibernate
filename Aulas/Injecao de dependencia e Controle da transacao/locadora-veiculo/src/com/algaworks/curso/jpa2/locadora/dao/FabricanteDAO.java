package com.algaworks.curso.jpa2.locadora.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class FabricanteDAO {

	@Inject EntityManager em;
		
	public void salvar(Fabricante fabricante) {
		this.em.persist(fabricante);
	}
	
	public Fabricante buscarPeloCodigo(Long codigo) {
		return this.em.find(Fabricante.class, codigo);
	}
	
}
