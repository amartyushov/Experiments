package io.mart.spring_hibernate.service;

import io.mart.spring_hibernate.entity.Customer;

import java.util.List;

/**
 * Created by Aleksandr Martiushov.
 */
public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}

