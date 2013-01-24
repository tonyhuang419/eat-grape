package com.eatle.service.system.systemdata.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.eatle.common.Constants;
import com.eatle.service.system.systemdata.IColorIdentifyService;
import com.eatle.utils.ConfigurationRead;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2013-1-24 下午12:03:20
 */
@Service("colorIdentifyService")
public class ColorIdentifyServiceImpl implements IColorIdentifyService
{
	public static final ConfigurationRead config = ConfigurationRead.getInstance();
	
	@Override
	public LinkedHashMap<String, String> getAllColors()
	{
		LinkedHashMap<String, String> colorMap = new LinkedHashMap<String, String>();
		
		colorMap.put("level1", config.getConfigItem("color.level.1"));
		colorMap.put("level2", config.getConfigItem("color.level.2"));
		colorMap.put("level3", config.getConfigItem("color.level.3"));
		colorMap.put("level4", config.getConfigItem("color.level.4"));
		colorMap.put("level5", config.getConfigItem("color.level.5"));
		colorMap.put("level6", config.getConfigItem("color.level.6"));
		
		return colorMap;
	}
	
	@Override
	public int setColor(LinkedHashMap<String, String> colorMap)
	{
		int result = Constants.Base.SUCCESS;
		try
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("color.level.1", colorMap.get("level1"));
			map.put("color.level.2", colorMap.get("level2"));
			map.put("color.level.3", colorMap.get("level3"));
			map.put("color.level.4", colorMap.get("level4"));
			map.put("color.level.5", colorMap.get("level5"));
			map.put("color.level.6", colorMap.get("level6"));
			config.setConfigItem(map);
		}
		catch (FileNotFoundException e)
		{
			result = Constants.Base.FAIL;
			e.printStackTrace();
		}
		catch (IOException e)
		{
			result = Constants.Base.FAIL;
			e.printStackTrace();
		}
		catch (URISyntaxException e)
		{
			result = Constants.Base.FAIL;
			e.printStackTrace();
		}
		
		return result;
	}
}
