package io.mart.annotations.scope;

import io.mart.annotations.AppConfig;
import io.mart.annotations.resource.Application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class AnnotationScopeDemo {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        Singleton singleton1 = context.getBean("singleton", Singleton.class);
        Singleton singleton2 = context.getBean("singleton", Singleton.class);

        System.out.println(singleton1==singleton2);
        System.out.println(singleton1);
        System.out.println(singleton2);

        Prototype prototype1 = context.getBean("prototype", Prototype.class);
        Prototype prototype2 = context.getBean("prototype", Prototype.class);

        System.out.println(prototype1==prototype2);
        System.out.println(prototype1);
        System.out.println(prototype2); // diff memory location io.mart.annotations.scope.Prototype@5cdd8682
    }
}
