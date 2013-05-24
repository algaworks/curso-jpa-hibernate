package com.algaworks.curso.jpa2.locadora.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriacaoTabelas {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		
		System.out.println("Finalizado!");
	}
	
}
