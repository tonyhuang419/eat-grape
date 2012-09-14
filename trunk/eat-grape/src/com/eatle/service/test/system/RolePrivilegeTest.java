package com.eatle.service.test.system; 

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import com.eatle.persistent.pojo.system.Menu;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.IMenuService;
import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.service.test.BaseTest;
import com.eatle.utils.ExcelUtil;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-8-31 上午12:34:10 
 */
public class RolePrivilegeTest extends BaseTest{

	private static IRolePrivilegeService rolePrivilegeService  = (IRolePrivilegeService) ctx.getBean("rolePrivilegeService");
	private static IUserService userService  = (IUserService) ctx.getBean("userService");
	private static IMenuService menuService  = (IMenuService) ctx.getBean("menuService");
	@Test
	public void test()
	{
		System.out.println(rolePrivilegeService.findAll().size());
	}
	
	@Test
	public void a() throws FileNotFoundException, IOException
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List l1 = userService.findAll();
		List l2 = menuService.findAll();
		map.put("用户信息表", l1);
		map.put("菜单信息1", l2);
		map.put("菜单信息2", l2);
		
		ExcelUtil.export2Excel(map,new Class[]{User.class, Menu.class, Menu.class}, 
				new String[]{"用户列表", "菜单列表1", "菜单列表2"}, new FileOutputStream("c:\\a.xls"));
	}
}