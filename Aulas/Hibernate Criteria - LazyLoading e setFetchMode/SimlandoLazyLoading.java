package com.algaworks.curso.jpa2.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;

public class SimlandoLazyLoading {

private static EntityManagerFactory factory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}
	
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		//this.manager.close();
	}
	
	@Test
	public void simulaLazyLoading() {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		criteria.setFetchMode("acessorios", FetchMode.JOIN);
		
		criteria.add(Restrictions.eq("codigo", 4L));
		Carro c = (Carro) criteria.uniqueResult();
		
		System.out.printf("Código: %d. Placa: %s\n", c.getCodigo(), c.getPlaca());
		
		session.close(); // Simulando o fechamento da sessão em um sistema Web
		
		System.out.printf("Primeiro acessório do carro: %s", 
				c.getAcessorios().get(0).getDescricao());
	}
	
}
















