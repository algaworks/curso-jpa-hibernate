package com.algaworks.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.algaworks.model.util.LocalDateConverter;
import com.algaworks.relatorio.AlertasPorUsuario;

@NamedNativeQuery(name="alertasPorUsuario",
	query="select u.nome as nome, count(a.codigo) as totalAlertas from usuario u, alert a "
			+ "where u.codigo = a.codigo_usuario "
			+ "group by u.nome",
	resultSetMapping="alertasPorUsuarioMapping"	)
@SqlResultSetMapping(name="alertasPorUsuarioMapping",
	classes={
		@ConstructorResult(
			targetClass=AlertasPorUsuario.class,
			columns={
				@ColumnResult(name="nome"),
				@ColumnResult(name="totalAlertas")
			}
		)
	}
)
@Entity
@Table(name = "usuario", indexes={@Index(columnList="nome", unique=true)
						, @Index(columnList="nome, data_nascimento")})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private LocalDate dataNascimento;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Convert(converter=LocalDateConverter.class)
	@Column(name="data_nascimento")
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
