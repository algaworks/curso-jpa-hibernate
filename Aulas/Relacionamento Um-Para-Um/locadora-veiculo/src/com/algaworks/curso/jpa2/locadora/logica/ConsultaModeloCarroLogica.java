package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.DAOFactory;
import com.algaworks.curso.jpa2.locadora.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class ConsultaModeloCarroLogica {

	private ModeloCarroDAO modeloCarroDAO = DAOFactory.getModeloCarroDAO();
	
	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return modeloCarroDAO.buscarPeloCodigo(codigo);
	}
	
}
