package io.mart.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // pointcut expression
    //@Before("execution(* add*(io.mart.aop.Account))")
    //@Before("execution(* add*(io.mart.aop.Account, ..))")
    //@Before("execution(* io.mart.aop.dao.*.*(..))")
    @Before("execution(* add*(..))")
    //@Before("execution(public void addAccount())")
    public void beforeAddAccount() {
        System.out.println("\n======> Executing @Before advice");
    }

    // execution(public void io.mart.aop.dao.AccountDAO.addAccount()) only for particluar method
    // execution(* io.mart.aop.dao.*.*()) all methods from all classes in a package
    // execution(public void add*())
    // execution(* add*())

    // parameters of the method:
    // () no args
    // (*) one arg of any type
    // (..) 0 or more args of any type


}
