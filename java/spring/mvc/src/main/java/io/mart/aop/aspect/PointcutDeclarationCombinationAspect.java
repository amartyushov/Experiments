package io.mart.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutDeclarationCombinationAspect {

    @Pointcut("execution(* io.mart.aop.dao.*.get*())")
    private void getter() {}

    @Pointcut("execution(* io.mart.aop.dao.*.set*())")
    private void setter() {}

    @Pointcut("execution(* io.mart.aop.dao.AccountDAO.*(..))")
    private void allMethodsFromAccountDAO() {}

    @Before("allMethodsFromAccountDAO() && !getter() && !setter()")
    public void combination() {
        System.out.println("====> Combination (always except get* and set*)");
    }

}
