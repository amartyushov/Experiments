package io.mart.restws.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.mart.restws.Patient;

public class PatientWsClient {
	
	public static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientService/";
	
	
	public static void main(String[] args) {
		
		Patient patient = simpleGetPatient();
		patient.setName("NewName11111111");
		updatePatient(patient);
		simpleGetPatient();
	}
	
	
	private static Patient simpleGetPatient() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL)
				.path("patients")
				.path("{id}")
				.resolveTemplate("id", 123);
		
		Invocation.Builder request = target.request();
		
		Patient response = request.get(Patient.class);
		
		System.out.println(response.getName());
		return response;
	}
	
	
	private static void updatePatient(Patient patient) {
		Client client = ClientBuilder.newClient();
		WebTarget putTarget = client.target(PATIENT_SERVICE_URL)
				.path("patients");
		
		Invocation.Builder request = putTarget.request();
		
		Response response = request.put(Entity.entity(patient, MediaType.APPLICATION_XML_TYPE));
		
		System.out.println(response.getStatus());
		
		response.close(); // !!
		client.close();
	}
	
}
