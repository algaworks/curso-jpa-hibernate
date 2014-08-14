package com.algaworks.gerenciador.util.jpa;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
public class TenantProducer {

	@Produces
	@RequestScoped
	@TenantInject
	public Tenant create() {
		String requestURL = getRequest().getRequestURL().toString();
		String tenantId = requestURL.substring(7).replaceAll("\\..+", "");
		return new Tenant(tenantId);
	}
	
	private HttpServletRequest getRequest() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (HttpServletRequest) context.getExternalContext().getRequest();
	}
	
}
