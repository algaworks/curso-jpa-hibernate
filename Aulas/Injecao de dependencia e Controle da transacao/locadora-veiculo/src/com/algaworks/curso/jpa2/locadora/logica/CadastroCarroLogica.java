package com.algaworks.curso.jpa2.locadora.logica;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.dao.CarroDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;
import com.google.inject.persist.Transactional;

public class CadastroCarroLogica {

	private CarroDAO carroDAO;
	
	@Inject
	public CadastroCarroLogica(CarroDAO carroDAO) {
		this.carroDAO = carroDAO;
	}

	@Transactional
	public void salvar(Carro carro) {
		this.carroDAO.salvar(carro);
	}
	
}
