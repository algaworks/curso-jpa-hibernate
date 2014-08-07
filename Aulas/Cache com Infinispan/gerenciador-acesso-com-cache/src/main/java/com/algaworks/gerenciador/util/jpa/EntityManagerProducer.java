package com.algaworks.gerenciador.util.jpa;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class EntityManagerProducer {
	
	@PersistenceContext(unitName = "gerenciadorAcessoPU")
	private EntityManager manager;

	@Produces
	@RequestScoped
	public EntityManager create() {
		return this.manager;
	}

}
