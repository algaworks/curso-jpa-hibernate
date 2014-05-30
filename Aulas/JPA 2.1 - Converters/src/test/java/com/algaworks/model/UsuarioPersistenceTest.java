package com.algaworks.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class UsuarioPersistenceTest {

	private JIntegrity helper;
	
	private EntityManager manager;
	
	@Before
	public void init() {
		this.helper = new JIntegrity();
		this.helper.useMySQL();
		
		this.helper.cleanAndInsert();
		
		this.manager = JPAHelper.currentEntityManager();
	}
	
	@Test
	public void deveRetornarDataDeNascimentoDoUsuario() {
		Usuario usuario = this.manager.find(Usuario.class, 1L);
		
		assertEquals(LocalDate.of(1990, 10, 2), usuario.getDataNascimento());
	}
	
}









