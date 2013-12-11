package com.algaworks.curso.jpa2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Proprietario;
import com.algaworks.curso.jpa2.modelo.Telefone;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploObjetosEmbutidos {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Maria");
		proprietario.getTelefones().add(new Telefone("34", "1234-5678", "104"));
		proprietario.getTelefones().add(new Telefone("11", "9876-5432", null));
		
		em.persist(proprietario);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
