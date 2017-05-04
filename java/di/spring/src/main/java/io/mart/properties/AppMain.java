package io.mart.properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        FileService fileService = (FileService) context.getBean("fileService");
        fileService.readValues();

        context.close();
    }
}
