package com.test.aop4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdviceLog {
	
	
	
	//@Pointcut("within(com.test.aop4.*)")
	//@Pointcut("execution(* com.test.aop4.*.*())")
	@Pointcut("bean(student)")
	private void pointcutMethod() {}
	//ProceedingJoinPoint 객체는 원래 실행되어야 할 대상 메소드(핵심 기능)
	@Around("pointcutMethod()")
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable{
		String signStr = joinPoint.getSignature().toShortString();
		System.out.println(signStr + " is start!!");
		long startTime = System.currentTimeMillis();
		
		try{
			Object obj = joinPoint.proceed();
			return obj;
		}finally{
			long endTime = System.currentTimeMillis();
			System.out.println(signStr + " is finished!!!");
			System.out.println(signStr + " 경과 시간 : "+(endTime - startTime));		
		}
	}//profile()
	
	//@Before("within(com.test.aop4.*)")
	@Before("pointcutMethod()")
	public void beforeAdvice(){
		System.out.println("beforeAdvice()........");
	}
	
	//	public void afterReturningAdvice(){
	//		System.out.println("afterReturningAdvice().........");
	//	}
	
	//	public void afterThrowingAdvice(){
	//		System.out.println("afterThrowingAdvice()..........");
	//	}
	
	//	public void afterAdvice(){
	//		System.out.println("afterAdvice().........");
	//	}
}
