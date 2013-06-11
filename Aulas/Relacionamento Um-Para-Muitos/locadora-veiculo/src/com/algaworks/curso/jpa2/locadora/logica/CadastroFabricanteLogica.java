package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class CadastroFabricanteLogica {

	private FabricanteDAO fabricanteDAO;
	
	public CadastroFabricanteLogica(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}
	
	public void salvar(Fabricante fabricante) {
		fabricanteDAO.salvar(fabricante);
	}
	
}
