package com.algaworks.curso.jpa2.locadora.modelo;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro {

	private Long codigo;
	private String placa;
	private String cor;
	private BigDecimal valorDiaria;
	private ModeloCarro modelo;
	
	private Collection<Aluguel> alugueis;
	
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
	
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	@ManyToOne
	@JoinColumn(name="fk_codigo_modelo_carro")
	public ModeloCarro getModelo() {
		return modelo;
	}
	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	@OneToMany(mappedBy="carro")
	public Collection<Aluguel> getAlugueis() {
		return alugueis;
	}
	public void setAlugueis(Collection<Aluguel> alugueis) {
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
