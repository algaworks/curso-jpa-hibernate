package com.algaworks.curso.main;

import javax.persistence.EntityManager;

import com.algaworks.curso.modelo.Cliente;
import com.algaworks.curso.util.jpa.JPAUtil;

public class ConsultandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 3L);
		
		if (cliente != null) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Idade: " + cliente.getIdade());
			System.out.println("Profissao: " + cliente.getProfissao());
			System.out.println("Sexo: " + cliente.getSexo());
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}

}
