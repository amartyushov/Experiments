package io.mart.restws.injection;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

//http://localhost:8080/restws/services/passengerservice/ is a base path

@Path("/passengerservice")
@Produces("application/xml,application/json")
@Consumes("application/xml,application/json,application/x-www-form-urlencoded")
// application/x-www-form-urlencoded : to be able to consume data from forms
public interface PassengerService {
	
	@Path("/passengers")
	@GET
	List<Passenger> getPassengers(@QueryParam("start") int start, @QueryParam("size") int size);
	
	@Path("/passengers")
	@POST
	Passenger addPassenger(Passenger passenger);
	
	@Path("/passengersform")
	@POST
	void addPassengerForm(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName);
	
	@Path("/passengersheader")
	@POST
	void addPassengerHeader(
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@HeaderParam("agent") String agent);
	
	@Path("/passengerscontext")
	@POST
	void addPassengerContext(@Context HttpHeaders headers);
//	all headers are provided in request, you can reach them
	
}
