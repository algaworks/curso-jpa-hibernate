package com.algaworks.curso.jpa2.locadora.main;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Pessoa;
import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class RemovendoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Pessoa pessoa = em.find(Pessoa.class, 1L);
		
		if (pessoa != null) {
			em.getTransaction().begin();
			em.remove(pessoa);
			em.getTransaction().commit();
		}
	}
	
}
