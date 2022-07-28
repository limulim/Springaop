package com.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceLog {
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable{
		String signStr = joinPoint.getSignature().toShortString();
	System.out.println(signStr + "is start!!");
	long startTime = System.currentTimeMillis();
	try {
	Object obj = joinPoint.proceed();	
	return obj;
	}finally {
		long endTime = System.currentTimeMillis();
		System.out.println(signStr + "is finished!!");
		System.out.println(signStr + "경과시간 (endTime = startTime)");
	}
	
	
	
 }
}