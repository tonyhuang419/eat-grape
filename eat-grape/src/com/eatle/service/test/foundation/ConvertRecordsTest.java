package com.eatle.service.test.foundation;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecords;
import com.eatle.service.foundation.scoreshop.IConvertRecordsService;
import com.eatle.service.test.BaseTest;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2013-01-23 下午14:44:22
 */
public class ConvertRecordsTest extends BaseTest
{
	private static IConvertRecordsService convertRecordsService = (IConvertRecordsService) ctx
			.getBean("convertRecordsService");

	@SuppressWarnings("unchecked")
	@Test
	public void test() throws ParseException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsName", "层");
		map.put("customerName", "456");
		map.put("startTime", "2013-01-20 11:22:11");
		map.put("endTime", "2013-01-30 11:22:11");
		List<ConvertRecords> l = (List<ConvertRecords>) convertRecordsService.findPagination(map, 1, 10).getItems();
		for(ConvertRecords cr : l)
		{
			System.out.println(cr.getGoodsName());
			System.out.println(cr.getConvertTimeStr());
		}
	}
}
