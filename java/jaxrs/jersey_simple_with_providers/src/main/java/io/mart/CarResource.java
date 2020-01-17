package io.mart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.mart.dto.Car;

@Path("car")
public class CarResource {
	
	@GET
	@Produces("application/json")
	public Response getCar(Car car) {
		return Response.ok().entity(car).build();
	}
	
	@GET
	@Path("/exception")
	@Produces("application/json")
	public Response getCarWithException(Car car) {
		throw new MyException("I am breaking things");
	}
}
