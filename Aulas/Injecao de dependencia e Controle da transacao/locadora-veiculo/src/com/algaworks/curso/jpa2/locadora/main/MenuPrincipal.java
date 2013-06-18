package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import javax.inject.Inject;

public class MenuPrincipal {
 
	private Scanner entrada;
	private MenuCadastros menuCadastros;
	private MenuAluguel menuAluguel;
	private MenuRelatorios menuRelatorios;
	
	@Inject
	public MenuPrincipal(Scanner entrada, MenuCadastros menuCadastros, MenuAluguel menuAluguel,
			MenuRelatorios menuRelatorios) {
		this.entrada = entrada;
		this.menuCadastros = menuCadastros;
		this.menuAluguel = menuAluguel;
		this.menuRelatorios = menuRelatorios;
	}

	public void inciarMenuPrincipal() {
		int opcao;
		
		do {
			imprimirOpcoesMenu();
			opcao = entrada.nextInt();
			
			switch (opcao) {
			case 1:
				this.menuCadastros.processarMenu();
				continue;
			case 2:
				this.menuAluguel.preencherFormulario();
				continue;
			case 3:
				this.menuRelatorios.processarMenu();
				continue;
			case 0:
				System.out.println("Obrigado.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
			
		} while (opcao != 0);
	}
	
	private void imprimirOpcoesMenu() {
		System.out.println();
		System.out.println("***********************************");
		System.out.println("*** Locadora Veículos Algaworks ***");
		System.out.println("***********************************");
		System.out.println("0. Sair");
		System.out.println("1. Cadastros");
		System.out.println("2. Aluguel");
		System.out.println("3. Relatórios");
		System.out.print("Opção: ");
	}
	
}
