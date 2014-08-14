package com.algaworks.procedure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

public class AnalisadorPedido {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemploProceduresPU");
		EntityManager manager = factory.createEntityManager();
		
		StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("analisarPedido");
		storedProcedure.registerStoredProcedureParameter("codigoPedido", Long.class, ParameterMode.IN);
		storedProcedure.setParameter("codigoPedido", 1L);
		storedProcedure.registerStoredProcedureParameter("analise", String.class, ParameterMode.OUT);
		
		storedProcedure.execute();
		
		String analise = (String) storedProcedure.getOutputParameterValue("analise");
		System.out.println("A análise foi: " + analise);
	}
	
}
