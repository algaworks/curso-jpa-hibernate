package com.algaworks.notafiscal.repository.hibernate;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.notafiscal.model.NFe;
import com.algaworks.notafiscal.repository.NotasFiscais;
import com.algaworks.notafiscal.util.jpa.Transactional;

public class HibernateNotasFiscais implements NotasFiscais {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Override
	@Transactional
	public NFe guardar(NFe nfe) {
		return this.manager.merge(nfe);
	}

}
