package io.mart;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    List<Customer> findByLastname(String lastname);

    List<Customer> findByFirstnameLike(String firstname);
}
