package com.eatle.service.test.system; 

import org.junit.Test;

import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-8-31 上午12:34:10 
 */
public class RolePrivilegeTest extends BaseTest{

	private static IRolePrivilegeService rolePrivilegeService  = (IRolePrivilegeService) ctx.getBean("rolePrivilegeService");

	@Test
	public void test()
	{
		System.out.println(rolePrivilegeService.findAll().size());
	}
}