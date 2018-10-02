package io.mart.restws.injection;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;

import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	List<Passenger> passengers = new ArrayList<>();
	int currentId = 123;
	
	@Override
	public List<Passenger> getPassengers(int start, int size) {
		System.out.println(start);
		System.out.println(size);
		return passengers;
	}
	
	
	@Override
	public Passenger addPassenger(Passenger passenger) {
		passenger.setId(currentId++);
		passengers.add(passenger);
		return null;
	}
	
	
	@Override
	public void addPassengerForm(String firstName, String lastName) {
		System.out.println(firstName);
		System.out.println(lastName);
	}
	
	
	@Override
	public void addPassengerHeader(String firstName, String lastName, String agent) {
		System.out.println(agent);
	}
	
	
	@Override
	public void addPassengerContext(HttpHeaders headers) {
		headers.getRequestHeaders()
				.forEach((key, value) -> System.out.println(key + " -> " + value));
		
		headers.getCookies().forEach((s, cookie) -> System.out.println(s + "\n" + cookie));
	}
}
