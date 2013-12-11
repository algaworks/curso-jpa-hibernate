package com.algaworks.curso.jpa2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Proprietario;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploTiposBasicos {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João");
		proprietario.getTelefones().add("(34) 1234-5678");
		proprietario.getTelefones().add("(11) 9876-5432"); 
		
		em.persist(proprietario);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
