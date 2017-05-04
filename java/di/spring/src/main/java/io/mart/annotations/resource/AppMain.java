package io.mart.annotations.resource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Byname Autowiring
        Application application = (Application)context.getBean("application");
        System.out.println("Application Details : "+application);

    }
}
