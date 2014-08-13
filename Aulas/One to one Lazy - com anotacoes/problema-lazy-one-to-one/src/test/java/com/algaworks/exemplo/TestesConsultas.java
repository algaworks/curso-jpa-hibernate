package com.algaworks.exemplo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import net.sf.beanlib.hibernate3.Hibernate3DtoCopier;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.exemplo.modelo.Usuario;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class TestesConsultas {

	private JIntegrity helper;
	
	private EntityManager manager;
	
	@Before
	public void init() {
		helper = new JIntegrity();
		helper.useMySQL();
		
		helper.cleanAndInsert();
		
		this.manager = JPAHelper.currentEntityManager();
	}
	
	@Test
	public void deveRetornarUsuario() {
		Usuario u = this.manager.find(Usuario.class, 1L);
		assertEquals("João", u.getNome());
		
		Hibernate3DtoCopier copiador = new Hibernate3DtoCopier();
		Usuario copia = copiador.hibernate2dto(u);
		
		assertNull(copia.getEndereco());
	}
	
}
