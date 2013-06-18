package com.algaworks.curso.jpa2.locadora.guice;

import java.util.Scanner;

import com.algaworks.curso.jpa2.locadora.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.locadora.dao.AluguelDAO;
import com.algaworks.curso.jpa2.locadora.dao.CarroDAO;
import com.algaworks.curso.jpa2.locadora.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.locadora.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.locadora.logica.CadastroAcessorioLogica;
import com.algaworks.curso.jpa2.locadora.logica.CadastroAluguelLogica;
import com.algaworks.curso.jpa2.locadora.logica.CadastroCarroLogica;
import com.algaworks.curso.jpa2.locadora.logica.CadastroFabricanteLogica;
import com.algaworks.curso.jpa2.locadora.logica.CadastroModeloCarroLogica;
import com.algaworks.curso.jpa2.locadora.logica.ConsultaAcessorioLogica;
import com.algaworks.curso.jpa2.locadora.logica.ConsultaCarroLogica;
import com.algaworks.curso.jpa2.locadora.logica.ConsultaFabricanteLogica;
import com.algaworks.curso.jpa2.locadora.logica.ConsultaModeloCarroLogica;
import com.algaworks.curso.jpa2.locadora.main.MenuAlugueisPorCarro;
import com.algaworks.curso.jpa2.locadora.main.MenuAluguel;
import com.algaworks.curso.jpa2.locadora.main.MenuCadastroAcessorio;
import com.algaworks.curso.jpa2.locadora.main.MenuCadastroCarro;
import com.algaworks.curso.jpa2.locadora.main.MenuCadastroFabricante;
import com.algaworks.curso.jpa2.locadora.main.MenuCadastroModeloCarro;
import com.algaworks.curso.jpa2.locadora.main.MenuCadastros;
import com.algaworks.curso.jpa2.locadora.main.MenuCarrosPorAcessorio;
import com.algaworks.curso.jpa2.locadora.main.MenuPrincipal;
import com.algaworks.curso.jpa2.locadora.main.MenuRelatorios;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class LocadoraConfig extends AbstractModule {

	@Override
	protected void configure() {
		bind(PersistenciaInit.class);
		
		bindDAOs();
		bindLogicas();
		bindMenus();
	}

	private void bindMenus() {
		bind(MenuAlugueisPorCarro.class);
		bind(MenuAluguel.class);
		bind(MenuCadastroAcessorio.class);
		bind(MenuCadastroCarro.class);
		bind(MenuCadastroFabricante.class);
		bind(MenuCadastroModeloCarro.class);
		bind(MenuCadastros.class);
		bind(MenuCarrosPorAcessorio.class);
		bind(MenuPrincipal.class);
		bind(MenuRelatorios.class);
	}

	private void bindLogicas() {
		bind(CadastroAcessorioLogica.class);
		bind(CadastroAluguelLogica.class);
		bind(CadastroCarroLogica.class);
		bind(CadastroFabricanteLogica.class);
		bind(CadastroModeloCarroLogica.class);
		bind(ConsultaAcessorioLogica.class);
		bind(ConsultaCarroLogica.class);
		bind(ConsultaFabricanteLogica.class);
		bind(ConsultaModeloCarroLogica.class);
	}
	
	void bindDAOs() {
		bind(AcessorioDAO.class);
		bind(AluguelDAO.class);
		bind(CarroDAO.class);
		bind(FabricanteDAO.class);
		bind(ModeloCarroDAO.class);
	}
	
	@Provides
	@Singleton
	Scanner createScanner() {
		return new Scanner(System.in);
	}
	
}
