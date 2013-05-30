package com.algaworks.curso.jpa2.locadora.main;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Pessoa;
import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class EntendendoTransacao {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa();
		p1.setNome("Joao");
		p1.setCpf("111");
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Maria");
		p2.setCpf("222");

		Pessoa p3 = new Pessoa();
		p3.setNome("Pedro");
		p3.setCpf("333");
		
		Pessoa p4 = new Pessoa();
		p4.setNome("Lucas");
		p4.setCpf("444");

		Pessoa p5 = new Pessoa();
		p5.setNome("Jose");
		p5.setCpf("555");

		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit(); // Ira salvar Joao e Maria no BD
		
		em.getTransaction().begin();
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.getTransaction().rollback(); // Nao ira salvar ninguem no BD
	}
	
}
