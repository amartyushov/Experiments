package io.mart.aop.aspect;

import io.mart.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class AfterThrowingAspect {

    @AfterThrowing(
            pointcut = "execution(* io.mart.aop.dao.AccountDAO.throwException(..))",
            throwing = "exception"
    ) // result above and below show have the same name
    public void afterReturning(JoinPoint joinPoint, Throwable exception) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("====> Executing @AfterThrowing for " + method);

        System.out.println("Exception is " + exception);

    }
}
