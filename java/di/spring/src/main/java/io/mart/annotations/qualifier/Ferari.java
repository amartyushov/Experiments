package io.mart.annotations.qualifier;

import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("Ferari")
public class Ferari implements Car{

    public void getCarName() {
        System.out.println("This is Ferari");
    }

}