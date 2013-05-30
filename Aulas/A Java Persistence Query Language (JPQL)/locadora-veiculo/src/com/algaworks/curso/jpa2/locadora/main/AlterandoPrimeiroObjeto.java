package com.algaworks.curso.jpa2.locadora.main;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Pessoa;
import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class AlterandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Pessoa pessoa = em.find(Pessoa.class, 1L);
		
		em.getTransaction().begin();
		pessoa.setNome("Maria José");
		em.getTransaction().commit();
	}
	
}
