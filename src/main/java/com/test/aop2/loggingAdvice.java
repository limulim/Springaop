package com.test.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class loggingAdvice {
	//모든 비즈니스 로직 메소드가 가지는 공통기능 구현
	//스프링으로부터 method, target, 매개변수등의 정보를 가진 joinpoint 객체를 전달 받는다.
	//매개변수만 선언만 해놓으면 가져다 사용할 수 있음.
	public void logging(JoinPoint joinPoint) {
		Signature method = joinPoint.getSignature();
		
		String methodName = method.getName();
		System.out.println("methodName : " + methodName);
		
	}

}
