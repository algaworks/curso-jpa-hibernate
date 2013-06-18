package com.algaworks.curso.jpa2.locadora.logica;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;
import com.google.inject.persist.Transactional;

public class CadastroModeloCarroLogica {

	private ModeloCarroDAO modeloCarroDAO;
	
	@Inject
	public CadastroModeloCarroLogica(ModeloCarroDAO modeloCarroDAO) {
		this.modeloCarroDAO = modeloCarroDAO;
	}
	
	@Transactional
	public void salvar(ModeloCarro modeloCarro) {
		this.modeloCarroDAO.salvar(modeloCarro);
	}
	
}
