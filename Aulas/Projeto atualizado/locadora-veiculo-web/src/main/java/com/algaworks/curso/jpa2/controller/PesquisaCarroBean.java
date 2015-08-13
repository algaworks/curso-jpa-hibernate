package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelolazy.LazyCarroDataModel;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesMessages facesMessages;
	
	@Inject
	private CarroDAO carroDAO;
	
	private LazyCarroDataModel lazyCarros;
	
	private Carro carroSelecionado;
	
	public void inicializar() {
		lazyCarros = new LazyCarroDataModel(carroDAO);
	}
	
	@SuppressWarnings("unchecked")
	public void excluir() {
		try {
			carroDAO.excluir(carroSelecionado);
			List<Carro> listaCarros = (List<Carro>) this.getLazyCarros().getWrappedData();
			listaCarros.remove(carroSelecionado);
			facesMessages.info("Carro placa " + carroSelecionado.getPlaca() + " excluído com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}
	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

	public void buscarAcessoriosParaCarro() {
		carroSelecionado = carroDAO.buscarAcessorios(carroSelecionado.getCodigo());
	}
	
	public LazyCarroDataModel getLazyCarros() {
		return lazyCarros;
	}
	
}
