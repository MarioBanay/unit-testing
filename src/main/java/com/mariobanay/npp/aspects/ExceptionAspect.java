package com.mariobanay.npp.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import com.mariobanay.npp.business.exceptions.NoItemException;

@Aspect
public class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.mariobanay.exceptions.*.*.*(..))", throwing = "ex")
    public void logError(NoItemException ex) {
        ex.printStackTrace();
    }
}
