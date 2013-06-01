package com.algaworks.curso.jpa2.locadora.main;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.modelo.Pessoa;
import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class ConsultandoComNamedQuery {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		List<Pessoa> pessoas = em.createNamedQuery("Pessoa.buscarTodos", Pessoa.class)
									.getResultList();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println("-------------------------");
			System.out.println("Código: " + pessoa.getCodigo());
			System.out.println("Nome: " + pessoa.getNome());
		}
	}
	
}
