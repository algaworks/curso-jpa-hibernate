package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.CarroDAO;
import com.algaworks.curso.jpa2.locadora.dao.DAOFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class CadastroCarroLogica {

	private CarroDAO carroDAO = DAOFactory.getCarroDAO();

	public void salvar(Carro carro) {
		this.carroDAO.salvar(carro);
	}
	
}
