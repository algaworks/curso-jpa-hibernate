package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;

public class ConsultaAcessorioLogica {

	private AcessorioDAO acessorioDAO;
	
	public ConsultaAcessorioLogica(AcessorioDAO acessorioDAO) {
		this.acessorioDAO = acessorioDAO;
	}
	
	public Acessorio buscarPeloCodigo(Long codigo) {
		return this.acessorioDAO.buscarPeloCodigo(codigo);
	}
	
}
