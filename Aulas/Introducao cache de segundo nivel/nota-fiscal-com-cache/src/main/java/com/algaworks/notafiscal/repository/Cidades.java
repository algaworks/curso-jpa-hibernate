package com.algaworks.notafiscal.repository;

import java.io.Serializable;
import java.util.List;

import com.algaworks.notafiscal.model.Cidade;
import com.algaworks.notafiscal.model.Estado;

public interface Cidades extends Serializable {

	public Cidade guardar(Cidade cidade);

	public List<Cidade> todas();

	public Cidade peloCodigo(Long codigo);

	public List<Cidade> buscarCidadesPorEstado(Estado estado);
	
}
