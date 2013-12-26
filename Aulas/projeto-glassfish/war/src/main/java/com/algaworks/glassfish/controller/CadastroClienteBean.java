package com.algaworks.glassfish.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.algaworks.glassfish.ejb.CadastroClienteEJB;
import com.algaworks.glassfish.modelo.Cliente;

@Named
@SessionScoped
public class CadastroClienteBean implements Serializable {

	private Cliente cliente;
	private List<Cliente> clientes;
	
	@EJB
	private CadastroClienteEJB cadastroClienteEJB;

	@PostConstruct
	public void inicializar() {
		this.cliente = new Cliente();
		this.clientes = this.cadastroClienteEJB.buscarTodos();
	}
	
	public void salvar() {
		this.cadastroClienteEJB.salvar(cliente);		
		this.inicializar();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
