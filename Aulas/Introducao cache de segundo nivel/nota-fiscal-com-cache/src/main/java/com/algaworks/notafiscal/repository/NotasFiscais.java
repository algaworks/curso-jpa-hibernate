package com.algaworks.notafiscal.repository;

import java.io.Serializable;

import com.algaworks.notafiscal.model.NFe;

public interface NotasFiscais extends Serializable {

	public NFe guardar(NFe nfe);
	
}
