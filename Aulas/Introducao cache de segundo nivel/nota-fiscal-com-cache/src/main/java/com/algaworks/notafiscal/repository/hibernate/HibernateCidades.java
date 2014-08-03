package com.algaworks.notafiscal.repository.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.notafiscal.model.Cidade;
import com.algaworks.notafiscal.model.Estado;
import com.algaworks.notafiscal.repository.Cidades;
import com.algaworks.notafiscal.util.jpa.Transactional;

public class HibernateCidades implements Cidades {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Override
	@Transactional
	public Cidade guardar(Cidade cidade) {
		return this.manager.merge(cidade);
	}

	@Override
	public List<Cidade> todas() {
		return this.manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade peloCodigo(Long codigo) {
		return this.manager.find(Cidade.class, codigo);
	}

	@Override
	public List<Cidade> buscarCidadesPorEstado(Estado estado) {
		return this.manager.createQuery("from Cidade c where c.estado = :estado", Cidade.class)
						.setParameter("estado", estado).getResultList();
	}

}
