package com.adj.select.service.controller;

import com.adj.select.dto.SelectOptionsDTO;
import com.adj.select.exception.NoSuchSelectException;
import com.adj.select.service.SelectLocalServiceUtil;
import com.adj.select.service.persistence.SelectFinder;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/ofb",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Ofb.Rest", "liferay.auth.verifier=false", "liferay.oauth2=false",
		"liferay.cors=false" }, immediate = true, service = Application.class)
public class SelectOptionsController extends Application {

	@Reference
	SelectFinder selectFinder;

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/selectoptions/{tableName}/{idFieldName}/{valueFieldName}")
	@Produces("application/json")
	public List<SelectOptionsDTO> getSelectOptionsData(@PathParam("idFieldName") String idFieldName,
			@PathParam("valueFieldName") String valueFieldName, @PathParam("tableName") String tableName)
			throws NoSuchSelectException {
		return SelectLocalServiceUtil.getSelectOptionsData(idFieldName, valueFieldName, tableName);
	}

}
