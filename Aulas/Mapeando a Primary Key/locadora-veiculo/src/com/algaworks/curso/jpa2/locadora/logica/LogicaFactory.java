package com.algaworks.curso.jpa2.locadora.logica;

public class LogicaFactory {

	public static CadastroFabricanteLogica getCadastroFabricanteLogica() {
		return new CadastroFabricanteLogica();
	}
	
	public static CadastroAcessorioLogica getCadastroAcessorioLogica() {
		return new CadastroAcessorioLogica();
	}
	
}
