package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Categoria;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroModeloCarroService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ModeloCarro modeloCarro;

	private List<Fabricante> fabricantes;

	private List<Categoria> categorias;

	@Inject
	private CadastroModeloCarroService cadastroModeloCarroService;

	@Inject
	private FabricanteDAO fabricanteDAO;

	@Inject
	private FacesMessages facesMessages;
	
	public void salvar() {
		try {
			this.cadastroModeloCarroService.salvar(modeloCarro);
			facesMessages.info("Modelo carro salvo com sucesso!");
			this.limpar();
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public void inicializar() {
		if (this.modeloCarro == null) {
			this.limpar();
		}
		
		this.fabricantes = fabricanteDAO.buscarTodos();
		this.categorias = Arrays.asList(Categoria.values());
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public boolean isEditando() {
		return this.modeloCarro.getCodigo() != null;
	}
	
	private void limpar() {
		this.modeloCarro = new ModeloCarro();
	}

}
