package com.algaworks.curso.jpa2.locadora.main;

import java.util.Scanner;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.logica.ConsultaAcessorioLogica;
import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class MenuCarrosPorAcessorio {

	private Scanner entrada;
	private ConsultaAcessorioLogica consultaAcessorioLogica;
	
	@Inject
	public MenuCarrosPorAcessorio(Scanner entrada, ConsultaAcessorioLogica consultaAcessorioLogica) {
		this.entrada = entrada;
		this.consultaAcessorioLogica = consultaAcessorioLogica;
	}

	private void imprimirCabecalho() {
		System.out.println();
		System.out.println("*** Carros com acessório ***");
	}
	
	public void preencherFormulario() {
		imprimirCabecalho();
		
		System.out.print("Código do acessório: ");
		Long codigo = this.entrada.nextLong();
		
		Acessorio acessorio = this.consultaAcessorioLogica.buscarPeloCodigo(codigo);
		if (acessorio != null && acessorio.getCarros() != null 
				&& !acessorio.getCarros().isEmpty()) {
			
			System.out.println();
			System.out.println("--- Relatório carros com acessório: " + acessorio.getDescricao() + " ---");
			
			for (Carro carro : acessorio.getCarros()) {
				System.out.println("\t*** Carro ***");
				System.out.println("\tCódigo: " + carro.getCodigo());
				System.out.println("\tPlaca: " + carro.getPlaca());
				System.out.println("\tCor: " + carro.getCor());
				System.out.println("\tValor diária: " + carro.getValorDiaria());
				System.out.println();
			}
		}
		
	}
	
}
