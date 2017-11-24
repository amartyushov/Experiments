package io.mart.annotations.lifecycle;

import io.mart.annotations.AppConfig;
import io.mart.annotations.scope.Prototype;
import io.mart.annotations.scope.Singleton;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class Demo {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean("myBean", MyBean.class);
        context.close();

    }
}
