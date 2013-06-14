package com.algaworks.curso.jpa2.locadora.modelo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

@Entity
public class Acessorio {

	private Long codigo;
	private String descricao;
	private Collection<Carro> carros;
	
	@Id
	@TableGenerator(name="Gerador_Acessorio"
			, initialValue=1
			, allocationSize=5
			, table="GERADOR_CODIGO")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Gerador_Acessorio")
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@ManyToMany(mappedBy="acessorios")
	public Collection<Carro> getCarros() {
		return carros;
	}
	public void setCarros(Collection<Carro> carros) {
		this.carros = carros;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Acessorio other = (Acessorio) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
