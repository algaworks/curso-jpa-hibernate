package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.AluguelDAO;
import com.algaworks.curso.jpa2.locadora.modelo.Aluguel;

public class CadastroAluguelLogica {

	private AluguelDAO aluguelDAO;
	
	public CadastroAluguelLogica(AluguelDAO aluguelDAO) {
		this.aluguelDAO = aluguelDAO;
	}
	
	public void salvar(Aluguel aluguel) {
		this.aluguelDAO.salvar(aluguel);
	}
	
}
