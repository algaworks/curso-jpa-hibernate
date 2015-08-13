package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FuncionarioDAO;
import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	private Funcionario funcionarioSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public void inicializar() {
		funcionarios = funcionarioDAO.buscarTodos();
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void excluir() {
		try {
			funcionarioDAO.excluir(funcionarioSelecionado);
			this.funcionarios.remove(funcionarioSelecionado);
			facesMessages.info("Funcionário " + funcionarioSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	
}