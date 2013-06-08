package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.logica.LogicaFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;
import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class MenuCadastroModeloCarro {

	private Scanner entrada;
	
	public MenuCadastroModeloCarro(Scanner entrada) {
		this.entrada = entrada;
		
		System.out.println();
		System.out.println("*** Cadastro de Modelo de Carro ***");
		
		preencherFormulario();
	}

	private void preencherFormulario() {
		System.out.print("Modelo: ");
		this.entrada.nextLine();
		String descricao = this.entrada.nextLine();
		
		System.out.print("Código Fabricante: ");
		Long codigoFabricante = this.entrada.nextLong();
		Fabricante fabricante = LogicaFactory.getConsultaFabricanteLogica().buscarPeloCodigo(codigoFabricante);
		
		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setDescricao(descricao);
		modeloCarro.setFabricante(fabricante);
		
		LogicaFactory.getCadastroModeloCarroLogica().salvar(modeloCarro);
	}
	
}
