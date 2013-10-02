package com.algaworks.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.algaworks.curso.modelo.Cliente;
import com.algaworks.curso.util.jpa.JPAUtil;

public class ConsultaComCriteria {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntityManager();
		
		// select, from, where, like... -> from(), where()..
		// JPQL: from Cliente
		// JPQL: select c from Cliente where c.nome like = 'Fernando%'
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
		Root<Cliente> c = criteriaQuery.from(Cliente.class);
		criteriaQuery.select(c);
		criteriaQuery.where(builder.like(c.<String>get("nome"), "Fernando%"));
		
		List<Cliente> clientes = em.createQuery(criteriaQuery).getResultList();
		
		for (Cliente cliente : clientes) {
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getNome());
		}
		
		em.close();
	}
	
}
