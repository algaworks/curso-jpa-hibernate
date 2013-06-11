package com.algaworks.curso.jpa2.locadora.dao;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.locadora.util.JPAUtil;

public class DAOFactory {

	private EntityManager em;
	
	public DAOFactory() {
		em = JPAUtil.getEntityManager();
	}
	
	public static DAOFactory getDAOFactory() {
		return new DAOFactory();
	}

	public FabricanteDAO getFabricanteDAO() {
		return new FabricanteDAO(em);
	}
	
	public AcessorioDAO getAcessorioDAO() {
		return new AcessorioDAO(em);
	}
	
	public ModeloCarroDAO getModeloCarroDAO() {
		return new ModeloCarroDAO(em);
	}
	
	public CarroDAO getCarroDAO() {
		return new CarroDAO(em);
	}
	
	public AluguelDAO getAluguelDAO() {
		return new AluguelDAO(em);
	}
	
}
