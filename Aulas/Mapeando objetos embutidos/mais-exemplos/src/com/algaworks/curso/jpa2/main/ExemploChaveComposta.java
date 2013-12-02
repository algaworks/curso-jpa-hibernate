package com.algaworks.curso.jpa2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Veiculo;
import com.algaworks.curso.jpa2.modelo.VeiculoId;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploChaveComposta {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(new VeiculoId("ABC-1235", "Ouro Preto"));
		veiculo.setFabricante("Volks");
		veiculo.setModelo("Gol");
		
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
		
		VeiculoId codigo =  new VeiculoId("ABC-1234", "Rio Claro");
		Veiculo v = em.find(Veiculo.class, codigo);
		
		System.out.println("Veiculo " + v.getCodigo().getPlaca() + " - " 
				+ v.getCodigo().getCidade() + " - Fabricante: " + v.getFabricante());
		
		em.close();
	}
	
}
