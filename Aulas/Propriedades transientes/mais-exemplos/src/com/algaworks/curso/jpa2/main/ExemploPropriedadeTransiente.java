package com.algaworks.curso.jpa2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Veiculo;
import com.algaworks.curso.jpa2.modelo.VeiculoId;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploPropriedadeTransiente {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
	
		Veiculo veiculo = em.find(Veiculo.class, new VeiculoId("AAA-1111", "Rio de Janeiro"));
		
		System.out.println(veiculo.getDescricao());
		
		em.close();
	}
	
}
