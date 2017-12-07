package io.mart.aop.around_aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {

    @Around("execution(* io.mart.aop.around_aspect.TrafficFortuneService.getFortune(..))")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @Around for " + method);

        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e);
            result = "No worries => muting exception";

            throw e; // if you want to rethrow the exception
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("\n====> Duration " + duration/1000);

        return result;
    }
}
