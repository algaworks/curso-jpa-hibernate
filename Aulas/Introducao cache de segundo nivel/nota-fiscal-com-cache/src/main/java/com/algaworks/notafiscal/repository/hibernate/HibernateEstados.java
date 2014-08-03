package com.algaworks.notafiscal.repository.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.notafiscal.model.Estado;
import com.algaworks.notafiscal.repository.Estados;
import com.algaworks.notafiscal.util.jpa.Transactional;

public class HibernateEstados implements Estados {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Override
	@Transactional
	public Estado guardar(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	public List<Estado> todos() {
		return this.manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado peloCodigo(Long codigo) {
		return this.manager.find(Estado.class, codigo);
	}

}
