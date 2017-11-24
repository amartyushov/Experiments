package io.mart.annotations.qualifier;

import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("Mustang")
//@Component if you dont specify qualifier Spring will generate a default one: Mustang -> mustang
public class Mustang implements Car{

    public void getCarName() {
        System.out.println("This is Mustang");
    }

}