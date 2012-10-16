package com.eatle.service.test.merchant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.service.test.BaseTest;
import com.eatle.utils.ExcelUtil;
import com.eatle.utils.ExcelUtil.ExportSetInfo;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2012-10-10 下午12:40:06
 */
public class RestaurantTest extends BaseTest
{
	private static IRestaurantService restaurantService = (IRestaurantService) ctx.getBean("restaurantService");

	@Test
	public void test()
	{
		Restaurant r = new Restaurant();
		r.setName("肯德基观音桥分店");
		r.setAddress("江北区观音桥北城天街");

		System.out.println(restaurantService.add(r));

		System.out.println(restaurantService.findAll().size());
	}
	
	@Test
	public void export2Excel() throws IOException, IllegalArgumentException, IllegalAccessException
	{
		System.out.println("a");
		OutputStream out = new FileOutputStream(new File("c:/a.xls"));
		
		LinkedHashMap<String, List> objsMap = restaurantService.getExportData();
		String[] fieldNames = new String[]{"name", "contactName", "contactPhone",
				"contactEmail", "contactQq", "businessHours", "sendUpPrice",
				"address", "sendMealsDescription", "logoUrl"};
		String[] titles = new String[objsMap.size()];
		List<String[]> headNames = new ArrayList<String[]>();
		Iterator<Entry<String, List>> iterator = objsMap.entrySet().iterator();
		for(int i = 0, len = objsMap.size(); i < len; i++)
		{
			titles[i] = iterator.next().getKey() + "基本信息";
			headNames.add(new String[] { "餐厅名称", "联系人", "联系电话", "联系邮箱", 
					"联系QQ", "营业时间", "起送价格", "餐厅地址", "送餐说明", "餐厅Logo"});
		}
		
		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(objsMap);
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(titles);
		setInfo.setHeadNames(headNames);
		setInfo.setOut(out);
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		System.out.println("a");
	}
}
