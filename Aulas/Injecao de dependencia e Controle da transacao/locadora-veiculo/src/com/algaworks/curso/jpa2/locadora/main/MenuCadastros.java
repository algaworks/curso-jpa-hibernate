package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import javax.inject.Inject;

public class MenuCadastros {

	private Scanner entrada;
	private MenuCadastroAcessorio menuCadastroAcessorio;
	private MenuCadastroFabricante menuCadastroFabricante;
	private MenuCadastroModeloCarro menuCadastroModeloCarro;
	private MenuCadastroCarro menuCadastroCarro;
	
	@Inject
	public MenuCadastros(Scanner entrada, MenuCadastroAcessorio menuCadastroAcessorio,
			MenuCadastroFabricante menuCadastroFabricante, MenuCadastroModeloCarro menuCadastroModeloCarro,
			MenuCadastroCarro menuCadastroCarro) {
		this.entrada = entrada;
		this.menuCadastroAcessorio = menuCadastroAcessorio;
		this.menuCadastroFabricante = menuCadastroFabricante;
		this.menuCadastroModeloCarro = menuCadastroModeloCarro;
		this.menuCadastroCarro = menuCadastroCarro;
	}

	public void processarMenu() {
		int opcao;
		
		do {
			imprimirOpcoesMenu();
			opcao = entrada.nextInt();
			
			switch (opcao) {
			case 1:
				this.menuCadastroFabricante.preencherFormulario();
				continue;
			case 2:
				this.menuCadastroAcessorio.preencherFormulario();
				continue;
			case 3:
				this.menuCadastroModeloCarro.preencherFormulario();
				continue;
			case 4:
				this.menuCadastroCarro.preencherFormulario();
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
