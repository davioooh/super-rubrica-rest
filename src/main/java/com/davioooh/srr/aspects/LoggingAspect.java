package com.davioooh.srr.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.davioooh.srr.services.ContactService.*(..))")
    public void logBeforeContactServiceMethoodsInvocation(JoinPoint joinPoint){
        log.trace("Invoking method: " + joinPoint.getSignature());
    }
}
