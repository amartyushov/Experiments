package io.mart;

import com.datastax.driver.mapping.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author Aleksandr Martiushov
 */
public class CustomerRepo {

    private Cassandra cassandra = new Cassandra();
    private Mapper<Customer> mapper = cassandra.getMapper(Customer.class);

    public void save(Customer customer){
        mapper.save(customer);
    }

    public Customer store(Customer customer){
        mapper.save(customer);
        return mapper.get(customer.getFirstName(), customer.getLastName());
    }

    public void storeCollection(Collection<Customer> customer){
        customer.stream().forEach(c -> mapper.save(c));
    }

    public Customer get(String firstName, String lastName){
        return mapper.get(firstName, lastName);
    }

}
