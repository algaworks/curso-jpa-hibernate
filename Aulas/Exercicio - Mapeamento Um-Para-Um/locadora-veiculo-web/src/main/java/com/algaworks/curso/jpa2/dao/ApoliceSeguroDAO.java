package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.ApoliceSeguro;

public class ApoliceSeguroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(ApoliceSeguro apoliceSeguro) {
		manager.persist(apoliceSeguro);
	}

}
