package com.algaworks.curso.jpa2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Proprietario;
import com.algaworks.curso.jpa2.modelo.Telefone;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaObjetosEmbutidos {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Proprietario proprietario = em.find(Proprietario.class, 1L);
		System.out.println("Nome: " + proprietario.getNome());
		
		for (Telefone telefone : proprietario.getTelefones()) {
			System.out.println("Telefone: (" + telefone.getPrefixo() + ") "
					+ telefone.getNumero()
					+ (telefone.getRamal() != null ? " x" + telefone.getRamal() : ""));
		}
		
		em.close();
	}
	
}
