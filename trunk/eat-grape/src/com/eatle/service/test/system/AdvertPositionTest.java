package com.eatle.service.test.system; 


import java.util.List;

import org.junit.Test;

import com.eatle.persistent.pojo.system.frontdata.AdvertPosition;
import com.eatle.service.system.frontdata.IAdvertPositionService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：广告位测试
 *  @version 日期：2012-8-31 上午12:34:10 
 */
public class AdvertPositionTest extends BaseTest{

	private static IAdvertPositionService advertPositionService  = (IAdvertPositionService) ctx.getBean("advertPositionService");

	@Test
	public void add()
	{
		
	}
	
	@Test
	public void update()
	{
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void query()
	{
		List<AdvertPosition> l = (List<AdvertPosition>) advertPositionService.findPagination(null, 1, 5).getItems();
		System.out.println(l.size());
		System.out.println(l.get(0).getPositionStyle());
		
//		System.out.println(advertPositionService.findById(1L).getPositionStyle());
	}
}