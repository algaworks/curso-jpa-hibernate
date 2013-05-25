package com.algaworks.curso.jpa2.locadora.main;

import java.util.Date;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Pessoa;
import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("12312312312");
		pessoa.setDataNascimento(new Date());
		pessoa.setNome("Joao da Silva");
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		
	}
	
}
