package io.mart.annotations.autowired.field;

import io.mart.annotations.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("driverField")
public class Driver {

    @Autowired
    private License license;

    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }
}