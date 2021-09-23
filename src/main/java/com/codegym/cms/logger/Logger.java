package com.codegym.cms.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
//    cach 1
    @AfterReturning(pointcut = "within(com.codegym.cms.controller.*)", returning = "e")
    public void log(JoinPoint joinPoint, Object e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(className +" "+method);
        System.out.println(args);
        System.out.println(e.toString());
    }
//    cach 2
    @Pointcut(value = "within(com.codegym.cms.service.*)")
    public void exception(){
    }

    @AfterThrowing(value = "exception()",throwing = "e")
    public void error(Exception e){
        System.out.println(e.getMessage());
    }
}
