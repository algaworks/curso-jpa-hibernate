package com.algaworks.curso.jpa2.locadora.main.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class DAOFactory {

	private static EntityManager entityManager;
	
	static {
		entityManager = JPAUtil.getEntityManager();
	}
	
	public static FabricanteDAO getFabricanteDAO() {
		return new FabricanteDAO(entityManager);
	}
}
