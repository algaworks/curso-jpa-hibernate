package com.algaworks.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class FaturaPersistenceTest {

	private JIntegrity helper;

	private EntityManager manager;
	
	@Before
	public void init() {
		this.helper = new JIntegrity();
		this.helper.useMySQL();
		
		this.helper.cleanAndInsert();
		
		this.manager = JPAHelper.currentEntityManager();
		
		if (!this.manager.getTransaction().isActive()) {
			this.manager.getTransaction().begin();
		}
	}
	
	@After
	public void end() {
		if (this.manager.getTransaction().isActive()) {
			this.manager.getTransaction().commit();;
		}
	}
	
	@Test
	public void deveAtualizarFaturasVencidas() {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaUpdate<Fatura> criteria = builder.createCriteriaUpdate(Fatura.class);
		Root<Fatura> root = criteria.from(Fatura.class);

		criteria.set("vencida", true)
			.where(builder.lessThan(root.<Date>get("vencimento"), new Date()));
		
		Query query = this.manager.createQuery(criteria);
		query.executeUpdate();
	}
	
	@Test
	public void deveDeletarFaturasVencidas() {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaDelete<Fatura> criteria = builder.createCriteriaDelete(Fatura.class);
		Root<Fatura> root = criteria.from(Fatura.class);

		criteria.where(builder.lessThan(root.<Date>get("vencimento"), new Date()));
		
		Query query = this.manager.createQuery(criteria);
		query.executeUpdate();
	}
	
	
}












