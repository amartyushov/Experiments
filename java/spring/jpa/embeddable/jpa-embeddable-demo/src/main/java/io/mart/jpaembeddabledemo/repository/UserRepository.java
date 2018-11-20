package io.mart.jpaembeddabledemo.repository;

import io.mart.jpaembeddabledemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
	// In case of embeddable specify A class name (Address) and then a field from this class
	User findByAddressCountry(String country);
	
	User findByNameFirstName(String firstName);
}