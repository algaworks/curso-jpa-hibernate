package com.algaworks.curso.jpa2.locadora.main;

import java.math.BigDecimal;
import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.logica.LogicaFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;
import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class MenuCadastroCarro {

	private Scanner entrada;
	
	public MenuCadastroCarro(Scanner entrada) {
		this.entrada = entrada;
		
		System.out.println();
		System.out.println("*** Cadastro de Carro ***");
		
		preencherFormulario();
	}
	
	private void preencherFormulario() {
		System.out.print("Placa: ");
		String placa = this.entrada.next();
		
		System.out.print("Cor: ");
		String cor = this.entrada.next();
		
		System.out.print("Valor da diária: R$ ");
		BigDecimal valorDiaria = this.entrada.nextBigDecimal();
		
		System.out.print("Código do modelo: ");
		Long codigoModelo = this.entrada.nextLong();
		ModeloCarro modeloCarro = LogicaFactory.getConsultaModeloCarroLogica().buscarPeloCodigo(codigoModelo);
		
		Carro carro = new Carro();
		carro.setPlaca(placa);
		carro.setCor(cor);
		carro.setValorDiaria(valorDiaria);
		carro.setModelo(modeloCarro);
		
		LogicaFactory.getCadastroCarroLogica().salvar(carro);
	}
		
}
