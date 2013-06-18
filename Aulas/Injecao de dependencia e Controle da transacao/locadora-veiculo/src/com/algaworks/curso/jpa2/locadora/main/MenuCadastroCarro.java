package com.algaworks.curso.jpa2.locadora.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.locadora.logica.CadastroCarroLogica;
import com.algaworks.curso.jpa2.locadora.logica.ConsultaAcessorioLogica;
import com.algaworks.curso.jpa2.locadora.logica.ConsultaModeloCarroLogica;
import com.algaworks.curso.jpa2.locadora.modelo.Acessorio;
import com.algaworks.curso.jpa2.locadora.modelo.Carro;
import com.algaworks.curso.jpa2.locadora.modelo.ModeloCarro;

public class MenuCadastroCarro {

	private Scanner entrada;
	private ConsultaModeloCarroLogica consultaModeloCarroLogica;
	private CadastroCarroLogica cadastroCarroLogica;
	private ConsultaAcessorioLogica consultaAcessorioLogica;
	
	@Inject
	public MenuCadastroCarro(Scanner entrada, ConsultaModeloCarroLogica consultaModeloCarroLogica
			, CadastroCarroLogica cadastroCarroLogica, ConsultaAcessorioLogica consultaAcessorioLogica) {
		this.entrada = entrada;
		this.consultaModeloCarroLogica = consultaModeloCarroLogica;
		this.cadastroCarroLogica = cadastroCarroLogica;
		this.consultaAcessorioLogica = consultaAcessorioLogica;
	}
	
	private void imprimirCabecalho() { 
		System.out.println();
		System.out.println("*** Cadastro de Carro ***");
	}
	
	public void preencherFormulario() {
		imprimirCabecalho();
		
		System.out.print("Placa: ");
		String placa = this.entrada.next();
		
		System.out.print("Cor: ");
		String cor = this.entrada.next();
		
		System.out.print("Valor da diária: R$ ");
		BigDecimal valorDiaria = this.entrada.nextBigDecimal();
		
		System.out.print("Código do modelo: ");
		Long codigoModelo = this.entrada.nextLong();
		ModeloCarro modeloCarro = this.consultaModeloCarroLogica.buscarPeloCodigo(codigoModelo);
		
		Carro carro = new Carro();
		carro.setPlaca(placa);
		carro.setCor(cor);
		carro.setValorDiaria(valorDiaria);
		carro.setModelo(modeloCarro);
		
		receberAcessorio(carro);
		
		this.cadastroCarroLogica.salvar(carro);
	}

	private void receberAcessorio(Carro carro) {
		while (true) {
			System.out.print("Adicionar acessório? (s/n): ");
			if (this.entrada.next().equals("n")) {
				break;
			}
			
			System.out.print("Código acessório: ");
			Long codigoAcessorio = this.entrada.nextLong();
			Acessorio acessorio = this.consultaAcessorioLogica.buscarPeloCodigo(codigoAcessorio);
			
			if (carro.getAcessorios() == null) {
				carro.setAcessorios(new ArrayList<Acessorio>());
			}
			carro.getAcessorios().add(acessorio);
		}
	}
		
}
