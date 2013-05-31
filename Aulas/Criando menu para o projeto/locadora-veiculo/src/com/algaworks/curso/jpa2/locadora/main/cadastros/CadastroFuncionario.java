package com.algaworks.curso.jpa2.locadora.main.cadastros;

import java.util.Scanner;

public class CadastroFuncionario {

	private Scanner entrada;
	
	public CadastroFuncionario(Scanner entrada) {
		this.entrada = entrada;
		System.out.println();
		System.out.println("*** Cadastro de Funcionário ***");
		
		preencherFormulario();
	}

	private void preencherFormulario() {
		System.out.print("Nome: ");
		String nome = this.entrada.next();
		
		System.out.print("Data de nascimento (dd/mm/yyyy): ");
		String dataNascimento = this.entrada.next();
		
		System.out.print("CPF: ");
		String cpf = this.entrada.next();
		
	}
	
}
