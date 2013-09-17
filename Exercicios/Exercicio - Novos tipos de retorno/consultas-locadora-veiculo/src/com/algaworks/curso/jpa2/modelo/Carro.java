package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro {

	private Long codigo;
	private String placa;
	private String cor;
	private String chassi;
	private BigDecimal valorDiaria;
	private ModeloCarro modelo;
	private List<Acessorio> acessorios;
	private List<Aluguel> alugueis;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_modelo")
	public ModeloCarro getModelo() {
		return modelo;
	}
	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="carro_acessorio"
				, joinColumns=@JoinColumn(name="codigo_carro")
				, inverseJoinColumns=@JoinColumn(name="codigo_acessorio"))
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	@OneToMany(mappedBy="carro")
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}
	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
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
		Carro other = (Carro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
