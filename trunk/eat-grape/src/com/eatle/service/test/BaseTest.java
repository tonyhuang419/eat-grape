package com.eatle.service.test;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2012-9-21 下午04:04:50
 */
public class BaseTest
{

	protected static ApplicationContext ctx;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{

		ctx = new ClassPathXmlApplicationContext(
				new String[] { "beans-myibatis.xml" });
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
		System.out.println("ApplicationContext对象：" + ctx);
	}
}
