package com.algaworks.curso.jpa2.modelolazy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;

public class LazyCarroDataModel extends LazyDataModel<Carro> implements Serializable {

	private CarroDAO carroDAO;
	
	public LazyCarroDataModel(CarroDAO carroDAO) {
		this.carroDAO = carroDAO;
	}
	
	@Override
	public List<Carro> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		List<Carro> carros = this.carroDAO.buscarComPaginacao(first, pageSize);
		
		this.setRowCount(this.carroDAO.encontrarQuantidadeDeCarros().intValue());
		
		return carros;
	}
	
}
