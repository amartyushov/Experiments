package io.mart.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutDeclarationAspect {

    @Pointcut("execution(* work())")
    private void pointcutDeclaration() {}

    @Before("pointcutDeclaration()")
    public void beforeStep() {
        System.out.println("====> Doing it before");
    }

    @Before("pointcutDeclaration()")
    public void beforeSecondStep() {
        System.out.println("====> Doing it before AGAIN");
    }

}
