package com.algaworks.curso.jpa2.locadora.main;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.logica.ConsultaCarroLogica;
import com.algaworks.curso.jpa2.locadora.modelo.Aluguel;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class MenuAlugueisPorCarro {

	private Scanner entrada;
	private ConsultaCarroLogica consultaCarroLogica;
	
	@Inject
	public MenuAlugueisPorCarro(Scanner entrada, ConsultaCarroLogica consultaCarroLogica) {
		this.entrada = entrada;
		this.consultaCarroLogica = consultaCarroLogica;
	}
	
	private void imprimirCabecalho() {
		System.out.println();
		System.out.println("*** Alugueis por carro ***");
	}

	public void preencherFormulario() {
		imprimirCabecalho();
		
		System.out.print("Código do carro: ");
		Long codigo = this.entrada.nextLong();
		
		Carro carro = this.consultaCarroLogica.buscarPeloCodigo(codigo);
		
		System.out.println();
		System.out.println("--- Relatório Alugueis por carro ---");
		System.out.println("\t*** Carro ***");
		System.out.println("\tCódigo: " + carro.getCodigo());
		System.out.println("\tPlaca: " + carro.getPlaca());
		System.out.println("\tCor: " + carro.getCor());
		System.out.println("\tValor diária: " + carro.getValorDiaria());
		
		imprimirDetalhesAlgueis(carro);
	}

	private void imprimirDetalhesAlgueis(Carro carro) {
		System.out.println();
		System.out.println("\t*** Alugueis do caro ***");
		
		int numeroAlugueis = 0;
		BigDecimal valorTodosAlugueis = BigDecimal.ZERO;
		if (carro.getAlugueis() != null) {
			numeroAlugueis = carro.getAlugueis().size();
			
			for (Aluguel aluguel : carro.getAlugueis()) {
				valorTodosAlugueis = valorTodosAlugueis.add(aluguel.getValorTotal());
			}
		}
		
		System.out.println("\tNúmero de algueis: " + numeroAlugueis);
		System.out.println("\tTotal valor ganho: " + valorTodosAlugueis);
	}

}
