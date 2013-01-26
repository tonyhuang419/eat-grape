package com.eatle.service.test.order;

import java.util.Map;

import org.junit.Test;
import com.eatle.service.test.BaseTest;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2013-01-23 下午14:44:22
 */
@SuppressWarnings("unchecked")
public class OrderTest extends BaseTest
{
//	private static IOrderService orderService = (IOrderService) ctx.getBean("orderService");
	private static Map<String, String> userTypeStr = (Map<String, String>) ctx.getBean("userTypeStr");
	private static Map<String, String> userTypeHtml = (Map<String, String>) ctx.getBean("userTypeHtml");

//	@SuppressWarnings("unchecked")
//	@Test
//	public void test() throws ParseException
//	{
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("orderNum", "tx");
//		map.put("contactName", "三");
//		map.put("customerName", "123");
//		map.put("restaurantName", "肯德基");
//		map.put("orderStatus", "0");
//		map.put("startTime", "2013-01-20 11:22:11");
//		map.put("endTime", "2013-01-30 11:22:11");
//		List<Order> l = (List<Order>) orderService.findPagination(map, 1, 10).getItems();
//		for(Order o : l)
//		{
//			System.out.println(o.getCustomerName() + "   " + o.getRestaurantName() + "   " + o.getOrderNum());
//		}
//	}
	
	@Test
	public void a()
	{
		System.out.println(userTypeStr.get("0"));
		System.out.println(userTypeHtml.get("0"));
	}
}
