package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class ConsultaFabricanteLogica {

	private FabricanteDAO fabricanteDAO;
	
	public ConsultaFabricanteLogica(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}
	
	public Fabricante buscarPeloCodigo(Long codigo) {
		return fabricanteDAO.buscarPeloCodigo(codigo);
	}
	
}
