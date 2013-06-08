package com.algaworks.curso.jpa2.locadora.logica;

import com.algaworks.curso.jpa2.locadora.dao.AluguelDAO;
import com.algaworks.curso.jpa2.locadora.dao.DAOFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Aluguel;

public class CadastroAluguelLogica {

	private AluguelDAO aluguelDAO = DAOFactory.getAluguelDAO();
	
	public void salvar(Aluguel aluguel) {
		this.aluguelDAO.salvar(aluguel);
	}
	
}
