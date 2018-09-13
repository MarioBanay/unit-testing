package com.mariobanay.npp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LoggerAspect {
	
	@Pointcut("execution(* com.mariobanay.npp.business.ItemServiceImpl.*(..))")
	public void itemsFromService() { }
		
	
/*	@Pointcut("execution(* dummyItem (..))")
	public void dummyItem() { };*/
	
	@Before("itemsFromService()")
	public void testAdvice() {
		System.out.println("Test AdviceBefore");
	}
	
	@After("itemsFromService()")
	public void testAdvice1() {
		System.out.println("Test AdviceAfter");
	}

	@AfterReturning(pointcut="execution(* com.mariobanay.npp.controller.ItemController.*(..))", returning="result")
	public void testAdvice2(JoinPoint joinpoint, Object result) {
		System.out.println("Controller returned: " + result.toString());
	}
	
}
