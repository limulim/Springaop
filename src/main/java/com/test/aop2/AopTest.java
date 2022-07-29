package com.test.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) {
		ApplicationContext	ctx =  new FileSystemXmlApplicationContext("/src/main/resources/aopEX02.xml");
		Service service =(Service)ctx.getBean("service");
  
		service.addBoard();
		service.getBoard();
	}

}
