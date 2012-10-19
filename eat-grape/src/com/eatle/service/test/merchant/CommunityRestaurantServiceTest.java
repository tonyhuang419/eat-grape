package com.eatle.service.test.merchant; 

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.eatle.persistent.pojo.foundation.place.Community;
import com.eatle.service.merchant.ICommunityRestaurantService;
import com.eatle.service.test.BaseTest;
import com.eatle.utils.Pagination;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-10-19 上午10:18:25 
 */
public class CommunityRestaurantServiceTest extends BaseTest
{
	private static ICommunityRestaurantService communityRestaurantService  
		= (ICommunityRestaurantService) ctx.getBean("communityRestaurantService");
	
	@Test
	public void test()
	{
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("restaurantId", 1);
//		queryMap.put("communityName", "花");
//		queryMap.put("pinyinName", "果");
//		queryMap.put("districtName", "观");
		
		Pagination page = communityRestaurantService.getSendCommunitiesByRestaurantId(queryMap, 1, 10);
		for(Object s : page.getItems())
		{
			System.out.println(((Community) s).getName() + "   " + ((Community) s).getDistrictName());
		}
	}
}
 