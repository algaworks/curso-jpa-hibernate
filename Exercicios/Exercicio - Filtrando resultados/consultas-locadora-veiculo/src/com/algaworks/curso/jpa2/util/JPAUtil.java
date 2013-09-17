package com.algaworks.curso.jpa2.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
}
