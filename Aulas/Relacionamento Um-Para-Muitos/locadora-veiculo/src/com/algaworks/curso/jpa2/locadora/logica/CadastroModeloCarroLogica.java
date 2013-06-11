package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class CadastroModeloCarroLogica {

	private ModeloCarroDAO modeloCarroDAO;
	
	public CadastroModeloCarroLogica(ModeloCarroDAO modeloCarroDAO) {
		this.modeloCarroDAO = modeloCarroDAO;
	}
	
	public void salvar(ModeloCarro modeloCarro) {
		this.modeloCarroDAO.salvar(modeloCarro);
	}
	
}
