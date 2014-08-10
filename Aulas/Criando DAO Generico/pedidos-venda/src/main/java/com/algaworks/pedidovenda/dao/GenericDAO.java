package com.algaworks.pedidovenda.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	
	public T buscarPeloCodigo(ID id);
	public void salvar(T entidade);
	public List<T> filtrar(T entidade, String... propriedades);

}
