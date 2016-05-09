package com.github.awvalenti.zssn.config.application;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationDebugExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		exception.printStackTrace();
		return Response.serverError().entity(exception.getMessage()).build();
	}

}
