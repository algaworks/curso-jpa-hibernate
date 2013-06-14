package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.CarroDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class CadastroCarroLogica {

	private CarroDAO carroDAO;
	
	public CadastroCarroLogica(CarroDAO carroDAO) {
		this.carroDAO = carroDAO;
	}

	public void salvar(Carro carro) {
		this.carroDAO.salvar(carro);
	}
	
}
