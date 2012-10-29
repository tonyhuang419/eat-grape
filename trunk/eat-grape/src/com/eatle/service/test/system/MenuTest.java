package com.eatle.service.test.system; 

import java.util.List;

import org.junit.Test;

import com.eatle.persistent.pojo.system.systemdata.Menu;
import com.eatle.persistent.pojo.system.systemdata.MenuCriteria;
import com.eatle.service.system.systemdata.IMenuService;
import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-8-31 上午12:34:10 
 */
public class MenuTest extends BaseTest{

	private static IMenuService menuService  = (IMenuService) ctx.getBean("menuService");
	private static IRolePrivilegeService rpService  = (IRolePrivilegeService) ctx.getBean("rolePrivilegeService");
	
	
//	private static IPrivService privService  = (IPrivService) ctx.getBean("privService");

	@Test
	public void test()
	{
		System.out.println(menuService.findById(1).getMenuName());
		System.out.println(menuService.findAll().size() + "a");
		
		MenuCriteria criteria = new MenuCriteria();
		criteria.setStartIndex(1);
		criteria.setPageSize(4);
		System.out.println(menuService.findByCriteria(criteria).size());
		
		// 查询所有根菜单
		List<Menu> rootMenus = menuService.findRootMenu();
		for(Menu m : rootMenus)
			System.out.println("谭又中："+m.getMenuName());
		
//		String allMenu = menuService.findAllMenu();
//		System.out.println(allMenu);
		
		//--------------
//		String allMenu1 = privService.findAllPrivMenu("/eatle");
//		System.out.println(allMenu1);
		
	}
	
	@Test
	public void b()
	{
		System.out.println(menuService.findAllMenu(rpService.findPrivsByRoleId(2L),"/eatle"));
	}
}