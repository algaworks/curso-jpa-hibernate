package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.DAOFactory;
import com.algaworks.curso.jpa2.locadora.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class ConsultaFabricanteLogica {

	private FabricanteDAO fabricanteDAO = DAOFactory.getFabricanteDAO();
	
	public Fabricante buscarPeloCodigo(Long codigo) {
		return fabricanteDAO.buscarPeloCodigo(codigo);
	}
	
}
