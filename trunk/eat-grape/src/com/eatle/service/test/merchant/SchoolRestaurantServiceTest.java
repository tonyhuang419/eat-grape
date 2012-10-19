package com.eatle.service.test.merchant; 

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.eatle.persistent.pojo.foundation.place.School;
import com.eatle.service.merchant.ISchoolRestaurantService;
import com.eatle.service.test.BaseTest;
import com.eatle.utils.Pagination;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-10-19 上午10:18:25 
 */
public class SchoolRestaurantServiceTest extends BaseTest
{
	private static ISchoolRestaurantService schoolRestaurantService  
		= (ISchoolRestaurantService) ctx.getBean("schoolRestaurantService");
	
	@Test
	public void test()
	{
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("restaurantId", 1);
		queryMap.put("schoolName", "电");
		queryMap.put("englishName", "elec");
		queryMap.put("districtName", "大");
		
		Pagination page = schoolRestaurantService.getSendSchoolsByRestaurantId(queryMap, 1, 10);
		for(Object s : page.getItems())
		{
			System.out.println(((School) s).getName() + "   " + ((School) s).getDistrictName());
		}
	}
}
 