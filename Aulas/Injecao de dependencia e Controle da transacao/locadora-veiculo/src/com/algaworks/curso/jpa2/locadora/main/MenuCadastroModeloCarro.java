package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.logica.CadastroModeloCarroLogica;
import com.algaworks.curso.jpa2.locadora.logica.ConsultaFabricanteLogica;
import com.algaworks.curso.jpa2.locadora.modelo.Fabricante;
import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class MenuCadastroModeloCarro {

	private Scanner entrada;
	private ConsultaFabricanteLogica consultaFabricanteLogica;
	private CadastroModeloCarroLogica cadastroModeloCarroLogica;
	
	@Inject
	public MenuCadastroModeloCarro(Scanner entrada, ConsultaFabricanteLogica consultaFabricanteLogica
			, CadastroModeloCarroLogica cadastroModeloCarroLogica) {
		this.entrada = entrada;
		this.consultaFabricanteLogica = consultaFabricanteLogica;
		this.cadastroModeloCarroLogica = cadastroModeloCarroLogica;
	}
	
	private void imprimirCabecalho() {
		System.out.println();
		System.out.println("*** Cadastro de Modelo de Carro ***");
	}

	public void preencherFormulario() {
		imprimirCabecalho();
		
		System.out.print("Modelo: ");
		this.entrada.nextLine();
		String descricao = this.entrada.nextLine();
		
		System.out.print("Código Fabricante: ");
		Long codigoFabricante = this.entrada.nextLong();
		Fabricante fabricante = this.consultaFabricanteLogica.buscarPeloCodigo(codigoFabricante);
		
		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setDescricao(descricao);
		modeloCarro.setFabricante(fabricante);
		
		this.cadastroModeloCarroLogica.salvar(modeloCarro);
	}
	
}
