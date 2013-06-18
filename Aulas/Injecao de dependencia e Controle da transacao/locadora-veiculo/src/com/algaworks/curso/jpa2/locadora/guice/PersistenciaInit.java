package com.algaworks.curso.jpa2.locadora.guice;

import javax.inject.Inject;

import com.google.inject.persist.PersistService;

public class PersistenciaInit {

	@Inject
	public PersistenciaInit(PersistService service) {
		service.start();
	}
	
}
