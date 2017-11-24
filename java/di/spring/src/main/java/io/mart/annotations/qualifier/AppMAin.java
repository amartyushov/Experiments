package io.mart.annotations.qualifier;

import io.mart.annotations.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class AppMAin {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        Bond bond = (Bond) context.getBean("bond");
        bond.showCar();
    }
}
