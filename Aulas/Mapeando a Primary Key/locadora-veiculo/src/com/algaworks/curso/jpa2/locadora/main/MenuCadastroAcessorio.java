package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.logica.CadastroAcessorioLogica;
import com.algaworks.curso.jpa2.locadora.logica.LogicaFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;

public class MenuCadastroAcessorio {

	private Scanner entrada;
	
	public MenuCadastroAcessorio(Scanner entrada) {
		this.entrada = entrada;
		System.out.println();
		System.out.println("*** Cadastro de Acessório ***");
		
		preencherFormulario();
	}
	
	private void preencherFormulario() {
		System.out.print("Descrição: ");
		String descricao = this.entrada.next();
		
		Acessorio acessorio = new Acessorio();
		acessorio.setDescricao(descricao);
		
		CadastroAcessorioLogica cadastroAcessorioLogica = LogicaFactory.getCadastroAcessorioLogica();
		cadastroAcessorioLogica.salvar(acessorio);
	}

}
