package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.logica.LogicaFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class MenuCarrosPorAcessorio {

	private Scanner entrada;
	
	public MenuCarrosPorAcessorio(Scanner entrada) {
		this.entrada = entrada;
		
		System.out.println();
		System.out.println("*** Carros com acessório ***");
		
		preencherFormulario();
	}

	private void preencherFormulario() {
		System.out.print("Código do acessório: ");
		Long codigo = this.entrada.nextLong();
		
		Acessorio acessorio = LogicaFactory.getConsultaAcessorioLogica().buscarPeloCodigo(codigo);
		if (acessorio != null && acessorio.getCarros() != null 
				&& !acessorio.getCarros().isEmpty()) {
			
			System.out.println();
			System.out.println("--- Relatório carros com acessório: " + acessorio.getDescricao() + " ---");
			
			for (Carro carro : acessorio.getCarros()) {
				System.out.println("\t*** Carro ***");
				System.out.println("\tCódigo: " + carro.getCodigo());
				System.out.println("\tPlaca: " + carro.getPlaca());
				System.out.println("\tCor: " + carro.getCor());
				System.out.println("\tValor diária: " + carro.getValorDiaria());
				System.out.println();
			}
		}
		
	}
	
}
