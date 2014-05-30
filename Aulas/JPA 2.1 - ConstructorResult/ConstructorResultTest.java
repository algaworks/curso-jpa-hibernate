package com.algaworks.model;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.relatorio.AlertasPorUsuario;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class ConstructorResultTest {

	private JIntegrity helper;
	
	private EntityManager manager;
	
	@Before
	public void init() {
		this.helper = new JIntegrity();
		this.helper.useMySQL();
		
		this.helper.cleanAndInsert("Usuario", "Alert");
		
		this.manager = JPAHelper.currentEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deveRetornarAlertasPorUsuario() {
		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		lista.forEach(System.out::println);
	}

}
