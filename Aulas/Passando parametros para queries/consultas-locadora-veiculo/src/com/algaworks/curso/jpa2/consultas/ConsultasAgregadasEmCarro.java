package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarro {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select c, count(a), max(a.valorTotal), avg(a.valorTotal) "
			  	          + "from Carro c JOIN c.alugueis a "
			  	          + "group by c "
			  	          + "having count(a) > 1";
		
		List<Object[]> resultados = em.createQuery(jpql).getResultList();
		for (Object[] obj : resultados) {
			System.out.println("Modelo: " + ((Carro) obj[0]).getModelo().getDescricao());
			System.out.println("Quantidade de alugueis: " + obj[1]);
			System.out.println("Valor máximo: " + obj[2]);
			System.out.println("Valor médio: " + obj[3]);
			System.out.println();
		}
		
		em.close();
	}
	
}
