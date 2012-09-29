package com.eatle.service.test.system; 

import org.junit.Test;

import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.useradmin.IRoleService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-8-31 上午12:34:10 
 */
public class UserTest extends BaseTest{

	private static IUserService userService  = (IUserService) ctx.getBean("userService");

	@Test
	public void test()
	{
		User user = new User();
		user.setUserName("谭又中");
		user.setPwd("123");
		
		userService.add(user);
	}
	
	@Test
	public void b()
	{
		
	}
}