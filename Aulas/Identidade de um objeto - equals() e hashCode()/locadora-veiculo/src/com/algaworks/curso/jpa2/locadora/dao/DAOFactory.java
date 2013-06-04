package com.algaworks.curso.jpa2.locadora.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class DAOFactory {

	private static EntityManager em;
	
	static {
		em = JPAUtil.getEntityManager();
	}
	
	public static FabricanteDAO getFabricanteDAO() {
		return new FabricanteDAO(em);
	}
	
}
