package io.mart.annotations.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component
public class Bond {

    /**
     * By default, @Autowored annotation makes sure that field is indeed autowired.
     * In case autowiring is not successful, Spring will throw an exception.
     * There are times however when you want to make autowiring optional.
     * Setting @Autowired required attribute to ‘false’ will make this field optional for autowiring
     * and Spring will skip it(remain null) if dependency not found.
     *
     * implementations can be referenced by default qualifiers, if you did not specify them explicitly for class.
     * default is Mustang -> mustang (lowered first letter)
     * if two first letters are capital, there is no transformation. URL -> URL
     */
    @Autowired(required=false)
    @Qualifier("Mustang")
    private Car car;

    public void showCar(){
        car.getCarName();
    }
}
