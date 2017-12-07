package io.mart.aop.aspect;

import io.mart.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectWithJoinPoint {

    @Before("execution(* moving(..))")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("\n======> Executing advice");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\n======> Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("\n ======> " + arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name " + account.getName());
                System.out.println("Account level " + account.getLevel());
            }
        }
    }
}
