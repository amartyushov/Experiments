package io.mart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/message")
public class MessageRestService {
	
	@GET
	public String message() {
		return "The message";
	}
	
}
