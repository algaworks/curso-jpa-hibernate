package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.logica.CadastroAcessorioLogica;
import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;

public class MenuCadastroAcessorio {

	private Scanner entrada;
	private CadastroAcessorioLogica cadastroAcessorioLogica;
	
	@Inject
	public MenuCadastroAcessorio(Scanner entrada, CadastroAcessorioLogica cadastroAcessorioLogica) {
		this.entrada = entrada;
		this.cadastroAcessorioLogica = cadastroAcessorioLogica;
	}

	private void imprimirCabecalho() {
		System.out.println();
		System.out.println("*** Cadastro de Acessório ***");
	}
	
	public void preencherFormulario() {
		imprimirCabecalho();
		
		System.out.print("Descrição: ");
		this.entrada.nextLine(); // Para pegar o "ENTER" "perdido"
		String descricao = this.entrada.nextLine();
		
		Acessorio acessorio = new Acessorio();
		acessorio.setDescricao(descricao);
		
		cadastroAcessorioLogica.salvar(acessorio);
	}

}
