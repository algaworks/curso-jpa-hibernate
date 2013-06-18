package com.algaworks.curso.jpa2.locadora;

import com.algaworks.curso.jpa2.locadora.guice.LocadoraConfig;
import com.algaworks.curso.jpa2.locadora.guice.PersistenciaInit;
import com.algaworks.curso.jpa2.locadora.main.MenuPrincipal;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class LocadoraVeiculo {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new LocadoraConfig(), new JpaPersistModule("locadoraVeiculoPU"));
		
		// Inicializa a persistência chamando o construtor de PersistenciaInit
		injector.getInstance(PersistenciaInit.class);
		
		MenuPrincipal menuPrincipal = injector.getInstance(MenuPrincipal.class);
		menuPrincipal.inciarMenuPrincipal();
	}
	
}
