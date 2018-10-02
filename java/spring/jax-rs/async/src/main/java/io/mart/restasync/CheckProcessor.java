package io.mart.restasync;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("/checkprocessingservice")
public interface CheckProcessor {
	
	@POST
	@Path("/checks")
	void processChecks(@Suspended AsyncResponse response, ChecksList checksList);
	// tells Apache CXF that method is async (@Suspended AsyncResponse response)
	
}
