package com.algaworks.pedidovenda.dao.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ValorTotalVendaDoDia {

	private Date dia;
	private BigDecimal valorTotal;

	public ValorTotalVendaDoDia(Date dia, BigDecimal valorTotal) {
		this.dia = dia;
		this.valorTotal = valorTotal;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
