package com.algaworks.curso.jpa2.locadora.main;

import java.math.BigDecimal;
import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.logica.LogicaFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Aluguel;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class MenuAlugueisPorCarro {

	private Scanner entrada;
	
	public MenuAlugueisPorCarro(Scanner entrada) {
		this.entrada = entrada;
		
		System.out.println();
		System.out.println("*** Alugueis por carro ***");
		
		preencherFormulario();
	}

	private void preencherFormulario() {
		System.out.print("Código do carro: ");
		Long codigo = this.entrada.nextLong();
		
		Carro carro = LogicaFactory.getConsultaCarroLogica().buscarPeloCodigo(codigo);
		
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
