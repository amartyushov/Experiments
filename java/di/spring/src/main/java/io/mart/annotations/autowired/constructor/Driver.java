package io.mart.annotations.autowired.constructor;

import io.mart.annotations.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("driverConstructor")
public class Driver {

    private License license;

    @Autowired
    public Driver(License license){
        this.license = license;
    }

    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }
}