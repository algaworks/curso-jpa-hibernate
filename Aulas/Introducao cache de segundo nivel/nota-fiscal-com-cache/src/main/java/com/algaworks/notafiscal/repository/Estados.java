package com.algaworks.notafiscal.repository;

import java.io.Serializable;
import java.util.List;

import com.algaworks.notafiscal.model.Estado;

public interface Estados extends Serializable {

	public Estado guardar(Estado estado);
	public List<Estado> todos();
	public Estado peloCodigo(Long codigo);
	
}
