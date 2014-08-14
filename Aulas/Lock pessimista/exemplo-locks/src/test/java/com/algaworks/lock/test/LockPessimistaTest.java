package com.algaworks.lock.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algaworks.lock.model.Cliente;
import com.algaworks.lock.model.Conta;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class LockPessimistaTest {

	private JIntegrity helper;
	
	private EntityManager manager;
	
	@Before
	public void init() {
		helper = new JIntegrity();
		helper.useMySQL();
		
		helper.cleanAndInsert();
		
		manager = JPAHelper.currentEntityManager();
	}
	
	@After
	public void end() {
		manager.getTransaction().commit();
	}
	
	@Test
	public void deveAdicionarUmClienteAConta() {
		Cliente cliente = new Cliente();
		cliente.setNome("Maria");
		
		cliente = manager.merge(cliente);
		manager.flush();
		
		Conta conta = manager.find(Conta.class, 2L, LockModeType.PESSIMISTIC_READ);
		conta.setClientes(new ArrayList<Cliente>());
		conta.getClientes().add(cliente);
		
		try {
			System.out.println("Esperando...");
			Thread.sleep(12000);
		} catch (InterruptedException e) { }
		
		manager.merge(conta);
	}
	
	
	
	@Test
	public void deveTransferirValor() {
		Conta conta1 = manager.find(Conta.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		Conta conta2 = manager.find(Conta.class, 2L, LockModeType.PESSIMISTIC_WRITE);
		
		BigDecimal valor = new BigDecimal("30");
		conta1.setSaldo(conta1.getSaldo().subtract(valor));
		
		manager.flush();
		
		try {
			System.out.println("Esperando...");
			Thread.sleep(12000);
		} catch (InterruptedException e) {}
		
		conta2.setSaldo(conta2.getSaldo().add(valor));
	}
	
}
