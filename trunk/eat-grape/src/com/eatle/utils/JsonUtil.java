package com.eatle.utils; 

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-10-8 下午05:30:22 
 */
public class JsonUtil
{
	public static String map2Json(Map<Long, String> map)
	{
		StringBuilder jsonStr = new StringBuilder();
		if(map.size() > 0)
		{
			jsonStr.append("[");
			
			for(Entry<Long, String> entry : map.entrySet())
			{
				jsonStr.append("[");
				jsonStr.append("\"" + entry.getKey() + "\" , ");
				jsonStr.append("\"" + entry.getValue() + "\"");
				jsonStr.append("],");
			}
			jsonStr.replace(jsonStr.length() - 1, jsonStr.length(), "");
			jsonStr.append("]");
		}
		return jsonStr.toString();
	}
	
	public static void main(String[] args)
	{
		Map<Long, String> map = new HashMap<Long, String>();
		map.put(1L, "aa");
		map.put(2L, "bb");
		map.put(3L, "cc");
		System.out.println(map2Json(map));
	}
}
 