package com.algaworks.lock.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorTabelas {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploLocksPU");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void main(String[] args) {
		// Executando esse código antes dos testes, irá fazer o hibernate gerar as tabelas a partir do arquivo persistence.xml
		EntityManager manager = GeradorTabelas.createEntityManager();
		manager.close();
		System.out.println(">>>>> Tabelas geradas com sucesso! <<<<<<<");
		System.exit(0);
		
	}
	
}
