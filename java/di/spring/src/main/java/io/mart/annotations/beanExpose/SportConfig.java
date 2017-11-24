package io.mart.annotations.beanExpose;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Aleksandr Martiushov.
 */
@Configuration
public class SportConfig {

    @Bean
    public Engine getEngine() {
        return new EngineImpl();
    }

    @Bean
    public Car makeCar() { // makeCar is bean id to refer
        Car car = new CarImpl(getEngine());
        return car;
    }
}
