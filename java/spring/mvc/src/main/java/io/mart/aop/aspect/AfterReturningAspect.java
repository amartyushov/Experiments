package io.mart.aop.aspect;

import io.mart.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class AfterReturningAspect {

    @AfterReturning(
            pointcut = "execution(* io.mart.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    ) // result above and below show have the same name
    public void afterReturning(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterReturning for " + method);

        System.out.println("Result is " + result);

        if (!result.isEmpty()) {
            Account account = result.get(0);
            account.setName("Mama");
        }
    }
}
