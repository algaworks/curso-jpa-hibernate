package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.dao.MotoristaDAO;
import com.algaworks.curso.jpa2.modelo.Motorista;

@FacesConverter(forClass=Motorista.class)
public class MotoristaConverter implements Converter {

	@Inject
	private MotoristaDAO motoristaDAO;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Motorista retorno = null;

		if (StringUtils.isNotBlank(value)) {
			retorno = this.motoristaDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Motorista) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}