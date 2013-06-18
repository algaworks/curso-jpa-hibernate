package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import javax.inject.Inject;

public class MenuRelatorios {

	private Scanner entrada;
	private MenuAlugueisPorCarro menuAlugueisPorCarro;
	private MenuCarrosPorAcessorio menuCarrosPorAcessorio;
	
	@Inject
	public MenuRelatorios(Scanner entrada, MenuAlugueisPorCarro menuAlugueisPorCarro,
			MenuCarrosPorAcessorio menuCarrosPorAcessorio) {
		this.entrada = entrada;
		this.menuAlugueisPorCarro = menuAlugueisPorCarro;
		this.menuCarrosPorAcessorio = menuCarrosPorAcessorio;
	}

	public void processarMenu() {
		int opcao;
		
		do {
			imprimirOpcoesMenu();
			opcao = entrada.nextInt();
			switch (opcao) {
			case 1:
				this.menuAlugueisPorCarro.preencherFormulario();
				continue;
			case 2:
				this.menuCarrosPorAcessorio.preencherFormulario();
				continue;
			case 0:
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
	
		} while (opcao != 0); 
	}
	
	private void imprimirOpcoesMenu() {
		System.out.println();
		System.out.println("*** Relatórios ***");
		System.out.println("0. Voltar");
		System.out.println("1. Alugueis por carro");
		System.out.println("2. Carros por acessório");
		System.out.print("Opção: ");
	}
}
