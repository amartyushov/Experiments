package io.mart.restasync.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import io.mart.restasync.ChecksList;

public class AsyncClient {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:8080/async/services/checkprocessingservice/checks");
		
		AsyncInvoker asyncInvoker = target.request().async();
		
		Future<Boolean> response =
				asyncInvoker.post(Entity.entity(new ChecksList(), MediaType.APPLICATION_XML), Boolean.class);
		
		try {
			System.out.println(response.get());
		} catch (InterruptedException | ExecutionException e) {
			if (e.getCause() instanceof BadRequestException) {
				BadRequestException bre = (BadRequestException) e.getCause();
				System.out.println("Please send valid list of checks");
			}
		}
	}
	
}
