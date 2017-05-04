package io.mart.properties.evaluation;

import io.mart.properties.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author Aleksandr Martiushov
 */
@Controller
public class MainApp {

    @Autowired(required = false)
    @Qualifier("Service")
    private SignInExecutor executor;

    public SignInExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(SignInExecutor executor) {
        this.executor = executor;
    }

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("properties-example.xml");
        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MainApp app = context.getBean(MainApp.class);
        app.getExecutor().pressLogin();

    }
}
