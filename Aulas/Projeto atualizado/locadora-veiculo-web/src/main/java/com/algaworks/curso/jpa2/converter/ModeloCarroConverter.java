package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

@FacesConverter(forClass=ModeloCarro.class)
public class ModeloCarroConverter implements Converter {

	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloCarro retorno = null;

		if (StringUtils.isNotBlank(value)) {
			retorno = this.modeloCarroDAO.buscarComFabricantePeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((ModeloCarro) value).getCodigo();
			return codigo == null ? null : codigo.toString();
		}
		return "";
	}

}