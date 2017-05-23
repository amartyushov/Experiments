package io.mart.dynamic;

/**
 * @author Aleksandr Martiushov
 */
public class CustomerServiceStaticProxy implements CustomerService {

    private CustomerService service;

    public CustomerServiceStaticProxy(CustomerService service) {
        this.service = service;
    }

    @Override
    public void saveCustomer() {
        System.out.println("Some additional logic...");
        service.saveCustomer();
    }
}
