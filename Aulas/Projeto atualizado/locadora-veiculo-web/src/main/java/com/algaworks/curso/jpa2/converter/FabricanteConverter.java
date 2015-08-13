package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {

	@Inject
	private FabricanteDAO fabricanteDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Fabricante) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}