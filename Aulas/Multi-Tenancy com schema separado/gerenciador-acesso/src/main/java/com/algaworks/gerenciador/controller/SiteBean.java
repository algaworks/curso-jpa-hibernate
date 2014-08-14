package com.algaworks.gerenciador.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.algaworks.gerenciador.model.Status;
import com.algaworks.gerenciador.model.Usuario;

@Named
@ViewScoped
public class SiteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Session session;
	
	public Long getTotalUsuarios() {
		return (Long) session.createQuery("select count(u) from Usuario u")
				.setCacheable(true)
				.uniqueResult();
	}
	
	public Long getUsuariosAtivos() {
		return (Long) session.createCriteria(Usuario.class)
				.setProjection(Projections.count("codigo"))
				.add(Restrictions.eq("status", Status.ATIVO))
				.setCacheable(true)
				.uniqueResult();
	}
	
}
