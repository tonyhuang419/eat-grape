package com.eatle.service.test;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

	protected static  ApplicationContext ctx;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		 ctx = new ClassPathXmlApplicationContext(
				new String[] {"beans-myibatis.xml"});
	}
	
	public static void main(String[] args)
	{
		try
		{
			setUpBeforeClass();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ApplicationContext对象："+ctx);
	}
}
