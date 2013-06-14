package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.CarroDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class ConsultaCarroLogica {

	private CarroDAO carroDAO;
	
	public ConsultaCarroLogica(CarroDAO carroDAO) {
		this.carroDAO = carroDAO;
	}
	
	public Carro buscarPeloCodigo(Long codigo) {
		return carroDAO.buscarPeloCodigo(codigo);
	}
	
}
