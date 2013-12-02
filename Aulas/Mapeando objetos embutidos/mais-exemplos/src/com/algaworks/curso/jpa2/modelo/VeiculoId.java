package com.algaworks.curso.jpa2.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class VeiculoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String placa;
	private String cidade;
	
	public VeiculoId() {
	}
	
	public VeiculoId(String placa, String cidade) {
		this.placa = placa;
		this.cidade = cidade;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoId other = (VeiculoId) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	

}
