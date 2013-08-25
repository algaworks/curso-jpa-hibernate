package com.algaworks.curso.jpa2.consultas;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAluguelPorData {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select count(a) "
				      + "from Aluguel a "
				      + "where a.dataDevolucao BETWEEN :inicio AND :fim";
		
		Calendar inicioCalendar = Calendar.getInstance();
		inicioCalendar.set(2013, 7,  28, 7, 0); // 24 de Agosto de 2013 7:00 horas
		Date inicio = inicioCalendar.getTime();
		
		Calendar fimCalendar = Calendar.getInstance();
		fimCalendar.set(2013, 7, 30, 18, 0); // 25 de Agosto de 2013 18:00 horas
		Date fim = fimCalendar.getTime();
		
		Long quantidadeDevolucoes = em.createQuery(jpql, Long.class)
									.setParameter("inicio", inicio, TemporalType.TIMESTAMP)
									.setParameter("fim",  fim, TemporalType.TIMESTAMP)
									.getSingleResult();
		
		System.out.println("Quantidade de devoluções: " + quantidadeDevolucoes);
		
		em.close();
	}
	
}
