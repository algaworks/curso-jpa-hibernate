package com.algaworks.relatorio;

import java.math.BigInteger;

public class AlertasPorUsuario {

	private String nome;
	private BigInteger totalAlertas;

	public AlertasPorUsuario(String nome, BigInteger totalAlertas) {
		this.nome = nome;
		this.totalAlertas = totalAlertas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigInteger getTotalAlertas() {
		return totalAlertas;
	}

	public void setTotalAlertas(BigInteger totalAlertas) {
		this.totalAlertas = totalAlertas;
	}

	@Override
	public String toString() {
		return "AlertasPorUsuario [nome=" + nome + ", totalAlertas="
				+ totalAlertas + "]";
	}

}
