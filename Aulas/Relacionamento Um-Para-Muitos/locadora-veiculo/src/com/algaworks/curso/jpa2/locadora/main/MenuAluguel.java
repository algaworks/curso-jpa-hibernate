package com.algaworks.curso.jpa2.locadora.main;

import java.math.BigDecimal;
import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.logica.LogicaFactory;
import com.algaworks.curso.jpa2.locadora.modelo.Aluguel;
import com.algaworks.curso.jpa2.locadora.modelo.ApoliceSeguro;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;

public class MenuAluguel {

	private Scanner entrada;
	
	public MenuAluguel(Scanner entrada) {
		this.entrada = entrada;
		
		System.out.println();
		System.out.println("*** Aluguel Veículo ***");
		
		preencherFormulario();
	}

	private void preencherFormulario() {
		System.out.print("Código carro: ");
		Long codigoCarro = this.entrada.nextLong();
		
		Carro carro = LogicaFactory.getConsultaCarroLogica().buscarPeloCodigo(codigoCarro);
		
		System.out.print("Valor total: R$ ");
		BigDecimal valorTotal = this.entrada.nextBigDecimal();
		
		ApoliceSeguro apoliceSeguro = entrarApoliceSeguro();
		
		Aluguel aluguel = new Aluguel();
		aluguel.setValorTotal(valorTotal);
		aluguel.setApoliceSeguro(apoliceSeguro);
		aluguel.setCarro(carro);
		
		LogicaFactory.getCadastroAluguelLogica().salvar(aluguel);
	}

	private ApoliceSeguro entrarApoliceSeguro() {
		System.out.println("> Apólice Seguro <");
		System.out.print("Valor franquia: R$ ");
		BigDecimal valorFranquia = this.entrada.nextBigDecimal();
		
		System.out.print("Proteção terceiro (s/n): ");
		Boolean protecaoTerceiro = this.entrada.next().equals("s") ? Boolean.TRUE : Boolean.FALSE;
		
		System.out.print("Proteção causas naturais (s/n): ");
		Boolean protecaoCausasNaturais = this.entrada.next().equals("s") ? Boolean.TRUE : Boolean.FALSE;
		
		System.out.print("Proteção roubo (s/n): ");
		Boolean protecaoRoubo = this.entrada.next().equals("s") ? Boolean.TRUE : Boolean.FALSE;
		
		ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
		apoliceSeguro.setValorFranquia(valorFranquia);
		apoliceSeguro.setProtecaoTerceiro(protecaoTerceiro);
		apoliceSeguro.setProtecaoCausasNaturais(protecaoCausasNaturais);
		apoliceSeguro.setProtecaoRoubo(protecaoRoubo);
		return apoliceSeguro;
	}

}
