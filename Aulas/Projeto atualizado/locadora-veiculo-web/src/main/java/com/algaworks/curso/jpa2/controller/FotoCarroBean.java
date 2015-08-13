package com.algaworks.curso.jpa2.controller;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.algaworks.curso.jpa2.modelo.Carro;

@Named
@SessionScoped
public class FotoCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Carro carroSelecionado;
	
	public StreamedContent getFoto() {
		DefaultStreamedContent content = null;
		if (this.carroSelecionado != null && this.carroSelecionado.getFoto() != null
				&& this.carroSelecionado.getFoto().length > 0) {
			byte[] imagem = this.carroSelecionado.getFoto();
			content = new DefaultStreamedContent(new ByteArrayInputStream(imagem), "image/jpg", "carro.jpg");
		}
		
		return content;
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

}
