package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.pedidovenda.dao.PedidoDAO;
import com.algaworks.pedidovenda.model.Pedido;

@FacesConverter(forClass=Pedido.class)
public class PedidoConverter implements Converter {

	@Inject
	private PedidoDAO pedidoDAO;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pedido retorno = null;
		
		if (value != null) {
			retorno = this.pedidoDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Pedido) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
