package io.mart.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {
	
	@Override
	public Response toResponse(PatientBusinessException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\t\"status\":\"error\",");
		sb.append("\t\"message\":\"try again later\"");
		sb.append("}");
		return Response
				.serverError().entity(sb.toString())
				.type(MediaType.APPLICATION_JSON_TYPE)
				.status(404)
				.build();
	}
}
