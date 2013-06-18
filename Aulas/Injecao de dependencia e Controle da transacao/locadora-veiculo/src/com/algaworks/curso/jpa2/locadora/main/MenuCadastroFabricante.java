package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.logica.CadastroFabricanteLogica;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class MenuCadastroFabricante {

	private Scanner entrada;
	private CadastroFabricanteLogica cadastroFabricanteLogica;
	
	@Inject
	public MenuCadastroFabricante(Scanner entrada, CadastroFabricanteLogica cadastroFabricanteLogica) {
		this.entrada = entrada;
		this.cadastroFabricanteLogica = cadastroFabricanteLogica;
	}

	private void imprimirCabecalho() {
		System.out.println();
		System.out.println("*** Cadastro de Fabricante ***");
	}

	public void preencherFormulario() {
		imprimirCabecalho();
		
		System.out.print("Nome do fabricante: ");
		String nomeFabricante = this.entrada.next();
		
		Fabricante fabricante = new Fabricante();
		fabricante.setNome(nomeFabricante);
		
		cadastroFabricanteLogica.salvar(fabricante);
	}
}
