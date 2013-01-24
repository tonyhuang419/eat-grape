package com.eatle.service.system.systemdata;

import java.util.LinkedHashMap;

public interface IColorIdentifyService
{
	/**
	 * @Description:
	 */
	LinkedHashMap<String, String> getAllColors();

	/**
	 * @Description:
	 * 
	 * @param colorMap ：颜色集合
	 */
	int setColor(LinkedHashMap<String, String> colorMap);
}