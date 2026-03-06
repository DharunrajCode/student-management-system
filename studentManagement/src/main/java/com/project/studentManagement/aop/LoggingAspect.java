package com.project.studentManagement.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.project.studentManagement.service.*.*(..))")
	public void logBefore(JoinPoint jp) {
		System.out.println("Method Started: "+jp.getSignature().getName());
	}
	
	@After("execution(* com.project.studentManagement.service.*.*(..))")
	public void logAfter(JoinPoint jp) {
		System.out.println("Method Ended: "+jp.getSignature().getName());
	}
	
	@Around("execution(* com.project.studentManagement.service.*.(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Before Method: "+pjp.getSignature());
		Object result = pjp.proceed();
		System.out.println("After Method: "+pjp.getSignature());
		return result;
	}

}
