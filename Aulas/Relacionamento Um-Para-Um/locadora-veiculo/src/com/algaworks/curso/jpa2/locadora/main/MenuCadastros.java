package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

public class MenuCadastros {

	private Scanner entrada;
	
	public MenuCadastros(Scanner entrada) {
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
				new MenuCadastroFabricante(entrada);
				continue;
			case 2:
				new MenuCadastroAcessorio(entrada);
				continue;
			case 3:
				new MenuCadastroModeloCarro(entrada);
				continue;
			case 4:
				new MenuCadastroCarro(entrada);
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
		System.out.println("*** Cadastros ***");
		System.out.println("0. Voltar");
		System.out.println("1. Fabricante");
		System.out.println("2. Acessório");
		System.out.println("3. Modelo de Carro");
		System.out.println("4. Carro");
		System.out.print("Opção: ");
	}
	
}
