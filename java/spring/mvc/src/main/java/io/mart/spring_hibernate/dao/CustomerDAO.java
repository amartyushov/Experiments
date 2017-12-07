package io.mart.spring_hibernate.dao;

import io.mart.spring_hibernate.entity.Customer;

import java.util.List;

/**
 * Created by Aleksandr Martiushov.
 */
public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
