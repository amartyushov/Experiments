package io.mart.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
	
	Map<Long, Patient> patients = new HashMap<>();
	long currentId = 123;
	
	
	public PatientServiceImpl() {
		init();
	}
	
	
	private void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("John");
		patients.put(patient.getId(), patient);
	}
	
//	http://localhost:8080/restws/services/patientService/patients
	@Override
	public List<Patient> getPatients() {
		Collection<Patient> results = patients.values();
		ArrayList<Patient> response = new ArrayList<>(results);
		return response;
	}
	
//	http://localhost:8080/restws/services/patientService/patients/123
	@Override
	public Patient getPatient(Long id) {
		return patients.get(id);
	}
	
	
	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}
	
	
	@Override
	public Response updatePatient(Patient patient) {
		Patient currentPatient = patients.get(patient.getId());
		Response response;
		if (currentPatient != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}
	
	
	@Override
	public Response deletePatient(Long id) {
		Patient candidateToDelete = patients.get(id);
		
		Response response;
		if (candidateToDelete != null) {
			patients.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}
}
