package io.mart.xml.autowire.bytype;

/**
 * @author Aleksandr Martiushov
 */
public class Employee {

    private EmployeeAddress address;

    public EmployeeAddress getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [address=" + address + "]";
    }
}