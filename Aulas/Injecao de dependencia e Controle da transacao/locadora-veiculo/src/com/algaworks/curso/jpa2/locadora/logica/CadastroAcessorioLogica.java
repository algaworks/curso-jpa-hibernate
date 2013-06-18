package com.algaworks.curso.jpa2.locadora.logica;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;
import com.google.inject.persist.Transactional;

public class CadastroAcessorioLogica {

	private AcessorioDAO acessorioDAO;
	
	@Inject
	public CadastroAcessorioLogica(AcessorioDAO acessorioDAO) {
		this.acessorioDAO = acessorioDAO;
	}
	
	@Transactional
	public void salvar(Acessorio acessorio) {
		this.acessorioDAO.salvar(acessorio);
	}
	
}
