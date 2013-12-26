package com.algaworks.glassfish.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.glassfish.modelo.Cliente;

@Stateless
public class CadastroClienteEJB {

	@PersistenceContext(unitName="projetoGlassfishPU")
	private EntityManager em;
	
	public void salvar(Cliente cliente) {
		em.persist(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		return em.createQuery("from Cliente c").getResultList();
	}
	
}
