package io.mart.spring_hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* io.mart.spring_hibernate.CustomerController.*(..))")
    private void forControllerClass() {}

    @Pointcut("execution(* io.mart.spring_hibernate.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* io.mart.spring_hibernate.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerClass() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n===> is Before: calling " + method);

        Object[] args = joinPoint.getArgs();
        for (Object arg:args) {
            logger.info("\n===> Argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n===> in @AfterReturning: from method " + method);

        logger.info("\n===> result: " + result);
    }

}
