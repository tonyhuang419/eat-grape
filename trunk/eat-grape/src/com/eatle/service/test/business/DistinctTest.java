package com.eatle.service.test.business; 

import org.junit.Test;

import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-9-21 下午04:04:50 
 */
public class DistinctTest extends BaseTest
{
	private static IDistrictService districtService  = (IDistrictService) ctx.getBean("districtService");

	@Test
	public void test()
	{
		System.out.println(districtService.findAll().size());
	}
}
 