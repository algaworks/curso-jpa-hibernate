package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class ConsultaModeloCarroLogica {

	private ModeloCarroDAO modeloCarroDAO;
	
	public ConsultaModeloCarroLogica(ModeloCarroDAO modeloCarroDAO) {
		this.modeloCarroDAO = modeloCarroDAO;
	}
	
	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return modeloCarroDAO.buscarPeloCodigo(codigo);
	}
	
}
