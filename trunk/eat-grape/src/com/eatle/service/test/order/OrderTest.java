package com.eatle.service.test.order;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.eatle.persistent.pojo.order.Order;
import com.eatle.service.order.IOrderService;
import com.eatle.service.test.BaseTest;
import com.eatle.utils.ExcelUtil;
import com.eatle.utils.ExcelUtil.ExportSetInfo;
import com.sun.corba.se.spi.orbutil.fsm.Input;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2013-01-23 下午14:44:22
 */
@SuppressWarnings("unchecked")
public class OrderTest extends BaseTest
{
	private static IOrderService orderService = (IOrderService) ctx.getBean("orderService");
	private static Map<String, String> userTypeStr = (Map<String, String>) ctx.getBean("userTypeStr");
	private static Map<String, String> userTypeHtml = (Map<String, String>) ctx.getBean("userTypeHtml");

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
	
	@Test
	public void a()
	{
		System.out.println(userTypeStr.get("0"));
		System.out.println(userTypeHtml.get("0"));
	}
	
	@Test
	public void exportTest() throws IllegalArgumentException, IOException, IllegalAccessException
	{
		OutputStream out = new FileOutputStream("c:/order.xls");
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "订单号", "下单时间", "订单状态", 
				"订单状态说明", "折扣", "总价", "送餐地址", "联系人", "联系电话", 
				"备选电话", "送餐备注", "订餐顾客", "餐厅名称", "送餐时间", "通知类型" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "orderNum", "orderTimeStr", "orderStatus", "orderStatusDescription", 
				"orderDiscount", "orderTotalMoney", "sendAddress", "contactName", "contactPhone", "anotherPhone", 
				"sendRemark", "customerName", "restaurantName", "sendTimeStr", "notifyTypeStr" }); 

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(orderService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒积分商城兑换记录信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(out);
		
		// 将需要导出的数据输出到out
		ExcelUtil.export2Excel(setInfo);
	}
}
