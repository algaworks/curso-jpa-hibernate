package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.DAOFactory;
import com.algaworks.curso.jpa2.locadora.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class CadastroFabricanteLogica {

	private FabricanteDAO fabricanteDAO = DAOFactory.getFabricanteDAO();
	
	public void salvar(Fabricante fabricante) {
		fabricanteDAO.salvar(fabricante);
	}
	
}
