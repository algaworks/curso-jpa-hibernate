package com.algaworks.curso.jpa2.locadora.main.cadastro;

import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.main.logica.LogicaFabricante;
import com.algaworks.curso.jpa2.locadora.main.logica.LogicaFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;

public class CadastroFabricante {

	private Scanner entrada;
	
	public CadastroFabricante(Scanner entrada) {
		this.entrada = entrada;
		System.out.println();
		System.out.println("*** Cadastro de Fabricante ***");
		
		preencherFormulario();
	}
	
	private void preencherFormulario() {
		System.out.print("Nome do fabricante: ");
		String nomeFabricante = this.entrada.next();
		
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao(nomeFabricante);
		
		LogicaFabricante logicaFabricante = LogicaFactory.getLogicaFabricante();
		logicaFabricante.salvar(fabricante);
	}

}
