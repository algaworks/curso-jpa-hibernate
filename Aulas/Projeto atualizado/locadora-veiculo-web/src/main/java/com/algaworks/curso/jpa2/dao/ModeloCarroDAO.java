package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return manager.find(ModeloCarro.class, codigo);
	}
	
	public ModeloCarro buscarComFabricantePeloCodigo(Long codigo) {
		// Na edição do modelo de carro, é importante retornar o fabricante para o combo funcionar
		return manager.createQuery("select c from ModeloCarro c inner join fetch c.fabricante where c.codigo = :codigo"
				, ModeloCarro.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}
	
	public void salvar(ModeloCarro modeloCarro) {
		manager.merge(modeloCarro);
	}

	public List<ModeloCarro> buscarTodos() {
		return manager.createQuery("from ModeloCarro", ModeloCarro.class).getResultList();
	}
	
	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException {
		modeloCarro = buscarPeloCodigo(modeloCarro.getCodigo());
		try {
			manager.remove(modeloCarro);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Modelo de carro não pode ser excluído.");
		}
	}
	
}
