package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.DAOFactory;

public class LogicaFactory {

	public static CadastroFabricanteLogica getCadastroFabricanteLogica() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		return new CadastroFabricanteLogica(daoFactory.getFabricanteDAO());
	}
	
	public static CadastroAcessorioLogica getCadastroAcessorioLogica() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		return new CadastroAcessorioLogica(daoFactory.getAcessorioDAO());
	}
	
	public static ConsultaFabricanteLogica getConsultaFabricanteLogica() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		return new ConsultaFabricanteLogica(daoFactory.getFabricanteDAO());
	}
	
	public static CadastroModeloCarroLogica getCadastroModeloCarroLogica() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		return new CadastroModeloCarroLogica(daoFactory.getModeloCarroDAO());
	}
	
	public static CadastroCarroLogica getCadastroCarroLogica() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		return new CadastroCarroLogica(daoFactory.getCarroDAO());
	}
	
	public static ConsultaModeloCarroLogica getConsultaModeloCarroLogica() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		return new ConsultaModeloCarroLogica(daoFactory.getModeloCarroDAO());
	}
	
	public static CadastroAluguelLogica getCadastroAluguelLogica() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		return new CadastroAluguelLogica(daoFactory.getAluguelDAO());
	}
	
	public static ConsultaCarroLogica getConsultaCarroLogica() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		return new ConsultaCarroLogica(daoFactory.getCarroDAO());
	}
}
