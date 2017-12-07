package io.mart.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterFinallyAspect {

    @After("execution(* io.mart.aop.dao.AccountDAO.throwException(..))") // called independently of either exception is thrown or normal return
    public void afterReturning(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @After for " + method);

    }
}
