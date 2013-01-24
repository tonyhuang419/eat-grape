package com.eatle.service.test.order;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecords;
import com.eatle.persistent.pojo.order.Order;
import com.eatle.service.foundation.scoreshop.IConvertRecordsService;
import com.eatle.service.order.IOrderService;
import com.eatle.service.test.BaseTest;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2013-01-23 下午14:44:22
 */
public class OrderTest extends BaseTest
{
	private static IOrderService orderService = (IOrderService) ctx.getBean("orderService");

	@SuppressWarnings("unchecked")
	@Test
	public void test() throws ParseException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderNum", "tx");
		map.put("contactName", "三");
		map.put("customerName", "123");
		map.put("restaurantName", "肯德基");
		map.put("orderStatus", "0");
		map.put("startTime", "2013-01-20 11:22:11");
		map.put("endTime", "2013-01-30 11:22:11");
		List<Order> l = (List<Order>) orderService.findPagination(map, 1, 10).getItems();
		for(Order o : l)
		{
			System.out.println(o.getCustomerName() + "   " + o.getRestaurantName() + "   " + o.getOrderNum());
		}
	}
}
