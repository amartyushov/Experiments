package io.mart;

import java.util.List;

/**
 * @author Aleksandr Martiushov
 */
public class Evaluate {

    static CustomerRepository repo;

    public static void main(String[] args) {
        List<Customer> customers = repo.findByFirstnameLike("name1");
        System.out.println(customers);

    }
}
