package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.modelo.Sexo;
import com.algaworks.curso.jpa2.service.CadastroMotoristaService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Motorista motorista;
	
	@Inject
	private CadastroMotoristaService cadastroMotoristaService;
	
	private List<Sexo> sexos;
	
	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.motorista == null) {
			this.limpar();
		}
		
		this.sexos = Arrays.asList(Sexo.values());
	}
	
	public void salvar() {
		try {
			this.cadastroMotoristaService.salvar(motorista);
			facesMessages.info("Motorista salvo com sucesso!");
			
			this.limpar();
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}
	
	public void limpar() {
		this.motorista = new Motorista();
	}

	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	public List<Sexo> getSexos() {
		return sexos;
	}
	
	public boolean isEditando() {
		return this.motorista.getCodigo() != null;
	}

}
