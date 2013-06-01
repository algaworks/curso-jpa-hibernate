package com.algaworks.curso.jpa2.locadora.main.logica;

import com.algaworks.curso.jpa2.locadora.main.dao.DAOFactory;
import com.algaworks.curso.jpa2.locadora.main.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class LogicaFabricante {

	private FabricanteDAO fabricanteDAO = DAOFactory.getFabricanteDAO();
	
	public void salvar(Fabricante fabricante) {
		fabricanteDAO.salvar(fabricante);
	}
	
}
