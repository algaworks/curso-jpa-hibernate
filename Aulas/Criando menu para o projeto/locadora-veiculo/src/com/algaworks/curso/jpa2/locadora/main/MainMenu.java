package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.main.cadastro.MenuCadastros;

public class MainMenu {

	public static void main(String[] args) {
		int opcao;
		Scanner entrada = new Scanner(System.in);
		
		do {
			imprimirOpcoesMenu();
			opcao = entrada.nextInt();
			
			switch (opcao) {
			case 1:
				new MenuCadastros(entrada);
				continue;
			case 0:
				System.out.println("Obrigado.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
			
			
			
		} while (opcao != 0);
	}

	private static void imprimirOpcoesMenu() {
		System.out.println();
		System.out.println("***********************************");
		System.out.println("*** Locadora Veículos Algaworks ***");
		System.out.println("***********************************");
		System.out.println("0. Sair");
		System.out.println("1. Cadastros");
		System.out.print("Opção: ");
	}
	
}
