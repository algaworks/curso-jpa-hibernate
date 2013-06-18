package com.algaworks.curso.jpa2.locadora.logica;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;
import com.google.inject.persist.Transactional;

public class CadastroFabricanteLogica {

	private FabricanteDAO fabricanteDAO;
	
	@Inject
	public CadastroFabricanteLogica(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}
	
	@Transactional
	public void salvar(Fabricante fabricante) {
		fabricanteDAO.salvar(fabricante);
	}
	
}
