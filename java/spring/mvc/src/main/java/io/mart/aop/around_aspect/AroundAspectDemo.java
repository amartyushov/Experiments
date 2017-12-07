package io.mart.aop.around_aspect;

import io.mart.aop.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundAspectDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String fortune = trafficFortuneService.getFortune();

        System.out.println("My fortune is: " + fortune);

    }
}
