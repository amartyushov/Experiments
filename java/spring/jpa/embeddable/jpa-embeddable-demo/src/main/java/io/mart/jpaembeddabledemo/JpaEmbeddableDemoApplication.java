package io.mart.jpaembeddabledemo;

import io.mart.jpaembeddabledemo.model.Address;
import io.mart.jpaembeddabledemo.model.Name;
import io.mart.jpaembeddabledemo.model.User;
import io.mart.jpaembeddabledemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaEmbeddableDemoApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaEmbeddableDemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// Cleanup the users table
		userRepository.deleteAllInBatch();
		
		// Insert a new user in the database
		Name name = new Name("TheFirstName", "TheMiddleName", "TheLastName");
		Address address = new Address("AddressLine1", "AddressLine2", "TheCity", "TheState", "TheCountry", "000000");
		User user = new User(name, "theemail@s.com", address);
		
		userRepository.save(user);
		
		User byEmail = userRepository.findByEmail("theemail@s.com");
		System.out.println(byEmail);
		
		User theCountry = userRepository.findByAddressCountry("TheCountry");
		System.out.println(theCountry);
		
		User theFirstName = userRepository.findByNameFirstName("TheFirstName");
		System.out.println(theFirstName);
	}
}
