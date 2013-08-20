package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantesPeloModeloCarro {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		List<String> nomeDosFabricantes = em.createQuery("select mc.fabricante.nome from ModeloCarro mc", String.class)
												.getResultList();
		
		for (String nomeFabricante : nomeDosFabricantes) {
			System.out.println("Nome: " + nomeFabricante);
		}
		
		em.close();
	}
	
}
