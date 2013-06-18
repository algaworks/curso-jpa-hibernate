package com.algaworks.curso.jpa2.locadora.logica;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.dao.AluguelDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Aluguel;
import com.google.inject.persist.Transactional;

public class CadastroAluguelLogica {

	private AluguelDAO aluguelDAO;
	
	@Inject
	public CadastroAluguelLogica(AluguelDAO aluguelDAO) {
		this.aluguelDAO = aluguelDAO;
	}
	
	@Transactional
	public void salvar(Aluguel aluguel) {
		this.aluguelDAO.salvar(aluguel);
	}
	
}
