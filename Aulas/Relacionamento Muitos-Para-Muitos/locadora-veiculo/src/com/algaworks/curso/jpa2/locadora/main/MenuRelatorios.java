package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

public class MenuRelatorios {

	private Scanner entrada;
	
	public MenuRelatorios(Scanner entrada) {
		this.entrada = entrada;
		
		processarMenu();
	}

	public void processarMenu() {
		int opcao;
		
		do {
			imprimirOpcoesMenu();
			opcao = entrada.nextInt();
			switch (opcao) {
			case 1:
				new MenuAlugueisPorCarro(entrada);
				continue;
			case 2:
				new MenuCarrosPorAcessorio(entrada);
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
