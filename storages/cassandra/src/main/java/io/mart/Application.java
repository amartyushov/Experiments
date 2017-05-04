package io.mart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Aleksandr Martiushov
 */
@SpringBootApplication
@RestController
public class Application {

    private CustomerRepo customerRepo = new CustomerRepo();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(path = "/save", method = RequestMethod.GET)
    public void save(
            @RequestParam(value = "lastName", required = false, defaultValue = "Mart") String lastName,
            @RequestParam(value = "firstName", required = false, defaultValue = "Alex") String firstName) {
        customerRepo.save(new Customer(firstName, lastName));
    }

    @RequestMapping(path = "/store", method = RequestMethod.POST)
    public ResponseEntity<Customer> store(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerRepo.store(customer), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/storeAll", method = RequestMethod.POST)
    public ResponseEntity<Customer> store(@RequestBody Collection<Customer> collection) {
        customerRepo.storeCollection(collection);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    Customer get(
            @RequestParam(value = "lastName", required = false, defaultValue = "Mart") String lastName,
            @RequestParam(value = "firstName", required = false, defaultValue = "Alex") String firstName) {
        return customerRepo.get(firstName, lastName);
    }

    @RequestMapping(path = "/accept", method = RequestMethod.POST)
    public ResponseEntity<Object> store(@RequestBody Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(o);

        assertThat(s, matchesJsonSchemaInClasspath("schema.json"));
        //customerRepo.save((Customer) o);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
}

