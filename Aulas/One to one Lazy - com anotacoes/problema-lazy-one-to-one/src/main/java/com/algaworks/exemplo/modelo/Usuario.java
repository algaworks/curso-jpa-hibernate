package com.algaworks.exemplo.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.bytecode.internal.javassist.FieldHandled;
import org.hibernate.bytecode.internal.javassist.FieldHandler;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, FieldHandled {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;
	
	private FieldHandler handler;
	
	@OneToOne(mappedBy = "usuario", fetch=FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private Endereco endereco;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		if (this.handler != null) {
			return (Endereco) this.handler.readObject(this, "endereco", endereco);
		}
		
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (this.handler != null) {
			this.endereco = (Endereco) this.handler.writeObject(this, "endereco"
					, this.endereco, endereco);
		}
		
		this.endereco = endereco;
	}
	
	@Override
	public void setFieldHandler(FieldHandler handler) {
		this.handler = handler;
	}

	@Override
	public FieldHandler getFieldHandler() {
		return this.handler;
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
