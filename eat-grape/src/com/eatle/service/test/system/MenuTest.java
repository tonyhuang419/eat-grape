package com.eatle.service.test.system; 

import org.junit.Test;

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
	}
}