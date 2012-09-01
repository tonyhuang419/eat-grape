package com.eatle.service.test.system; 

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

import com.eatle.persistent.pojo.system.Menu;
import com.eatle.persistent.pojo.system.MenuCriteria;
import com.eatle.service.system.IMenuService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-8-31 上午12:34:10 
 */
public class MenuTest extends BaseTest{

	private static IMenuService menuService  = (IMenuService) ctx.getBean("menuService");

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
		
		String allMenu = menuService.findAllMenu();
//		a(allMenu);
		System.out.println(allMenu);
	}
	
	public void a(Map map)
	{
		Iterator ii = map.entrySet().iterator();
		while(ii.hasNext())
		{
			Entry entry = (Entry) ii.next();
			Long k = (Long) entry.getKey();
			Menu v = (Menu) entry.getValue();
			System.out.println(k + "    " + v.getMenuName());
		}
	}
}