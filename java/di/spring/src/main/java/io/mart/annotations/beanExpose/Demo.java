package io.mart.annotations.beanExpose;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class Demo {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        CarImpl car = context.getBean("makeCar", CarImpl.class);
        System.out.println(car.drive());
        car.embeddingEngine();
    }
}
