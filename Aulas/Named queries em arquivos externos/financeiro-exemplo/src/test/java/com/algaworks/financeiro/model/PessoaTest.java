package com.algaworks.financeiro.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class PessoaTest {

	private JIntegrity helper;

	private EntityManager manager;

	@Before
	public void init() {
		this.helper = new JIntegrity();
		this.helper.useMySQL();

		this.manager = JPAHelper.currentEntityManager();
	}
	
	@Test
	public void deveRetornarTodasPessoas() {
		TypedQuery<Pessoa> query = this.manager.createNamedQuery("Pessoa.todas", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();
		
		assertEquals(2, pessoas.size());
	}
	
}
