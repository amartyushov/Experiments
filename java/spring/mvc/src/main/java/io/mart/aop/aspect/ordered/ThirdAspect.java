package io.mart.aop.aspect.ordered;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ThirdAspect {

    @Before("execution(* jumping())")
    public void beforeAddAccount() {
        System.out.println("\n======> Executing Third advice");
    }
}
