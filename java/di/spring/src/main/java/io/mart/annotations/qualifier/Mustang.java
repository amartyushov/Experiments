package io.mart.annotations.qualifier;

import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("Mustang")
public class Mustang implements Car{

    public void getCarName() {
        System.out.println("This is Mustang");
    }

}