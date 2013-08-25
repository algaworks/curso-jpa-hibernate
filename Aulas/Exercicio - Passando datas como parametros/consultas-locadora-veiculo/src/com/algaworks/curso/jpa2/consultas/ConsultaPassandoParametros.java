package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaPassandoParametros {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String modelo = "Chevrolet";

		String jpql = "select mc.descricao from ModeloCarro mc "
				        + "where mc.fabricante.nome = :modelo";
		List<String> modelos = em.createQuery(jpql, String.class)
				.setParameter("modelo", modelo)
				.getResultList();
		
		for (String m : modelos) {
			System.out.println(m);
		}
		
		em.close();
	}
	
}
