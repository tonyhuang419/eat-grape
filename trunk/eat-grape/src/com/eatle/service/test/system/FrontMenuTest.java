package com.eatle.service.test.system; 

import org.junit.Test;

import com.eatle.service.system.frontdata.IFrontMenuService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-8-31 上午12:34:10 
 */
public class FrontMenuTest extends BaseTest{

	private static IFrontMenuService frontMenuService  = (IFrontMenuService) ctx.getBean("frontMenuService");

	@Test
	public void test()
	{
		System.out.println(frontMenuService.findAllFrontMenu());
//		System.out.println(frontMenuService.findAll().size());
	}
}