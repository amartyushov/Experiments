package io.mart.annotations.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Aleksandr Martiushov.
 */
@Component
public class MyBean {

    @PostConstruct
    public void post(){
        System.out.println("Happening after construct");
    }

    @PreDestroy
    public void pre() {
        System.out.println("Happening before destroy");
    }
    // For "prototype" scoped beans, Spring does not call the @PreDestroy method
}
