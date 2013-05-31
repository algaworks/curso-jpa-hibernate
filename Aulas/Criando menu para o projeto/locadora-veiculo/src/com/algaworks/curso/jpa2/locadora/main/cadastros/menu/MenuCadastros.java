package com.algaworks.curso.jpa2.locadora.main.cadastros.menu;

import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.main.MainMenu;
import com.algaworks.curso.jpa2.locadora.main.cadastros.CadastroFuncionario;

public class MenuCadastros extends MainMenu {

	private Scanner entrada;
	
	public MenuCadastros(Scanner entrada) {
		this.entrada = entrada; 
		
		processarMenu();
	}

	private void imprimirOpcoesMenu() {
		System.out.println();
		System.out.println("*** Cadastros ***");
		System.out.println("0. Voltar");
		System.out.println("1. Funcionário");
		System.out.print("Opção: ");
	}
	
	public void processarMenu() {
		int opcao;
		do {
			imprimirOpcoesMenu();
			opcao = entrada.nextInt();
			
			switch (opcao) {
			case 1:
				new CadastroFuncionario(entrada);
				
				continue;
			case 0:
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
			
		} while (opcao != 0);
	}
	
}
