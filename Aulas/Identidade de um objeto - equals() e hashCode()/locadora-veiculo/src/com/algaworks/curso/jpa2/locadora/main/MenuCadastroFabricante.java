package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.logica.CadastroFabricanteLogica;
import com.algaworks.curso.jpa2.locadora.logica.LogicaFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class MenuCadastroFabricante {

	private Scanner entrada;
	
	public MenuCadastroFabricante(Scanner entrada) {
		this.entrada = entrada;
		System.out.println();
		System.out.println("*** Cadastro de Fabricante ***");
		
		preencherFormulario();
	}

	private void preencherFormulario() {
		System.out.print("Nome do fabricante: ");
		String nomeFabricante = this.entrada.next();
		
		Fabricante fabricante = new Fabricante();
		fabricante.setNome(nomeFabricante);
		
		CadastroFabricanteLogica cadastroFabricante = LogicaFactory.getCadastroFabricanteLogica();
		cadastroFabricante.salvar(fabricante);
	}
}
