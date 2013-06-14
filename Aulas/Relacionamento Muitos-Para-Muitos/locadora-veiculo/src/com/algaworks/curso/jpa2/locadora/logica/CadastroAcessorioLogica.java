package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;

public class CadastroAcessorioLogica {

	private AcessorioDAO acessorioDAO;
	
	public CadastroAcessorioLogica(AcessorioDAO acessorioDAO) {
		this.acessorioDAO = acessorioDAO;
	}
	
	public void salvar(Acessorio acessorio) {
		this.acessorioDAO.salvar(acessorio);
	}
	
}
