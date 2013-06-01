package com.algaworks.curso.jpa2.locadora.main;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Pessoa;
import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class ConsultandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Pessoa pessoa = em.find(Pessoa.class, 2L);
		
		if (pessoa != null) {
			System.out.println("Código: " + pessoa.getCodigo());
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("Data nascimento: " + pessoa.getDataNascimento());
		} 
	}
	
}
