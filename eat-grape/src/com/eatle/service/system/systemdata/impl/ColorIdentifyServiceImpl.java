package com.eatle.service.system.systemdata.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.eatle.common.Constants;
import com.eatle.service.system.systemdata.IColorIdentifyService;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2013-1-24 下午12:03:20
 */
@Service("colorIdentifyService")
public class ColorIdentifyServiceImpl implements IColorIdentifyService
{
	private static String CONFIG_FILE_PATH = "res/dev/color.properties";
	
	private Properties props;
	
	@Override
	public LinkedHashMap<String, String> getAllColors()
	{
		init();
		
		LinkedHashMap<String, String> colorMap = new LinkedHashMap<String, String>();
		
		colorMap.put("level1", props.getProperty("color.level.1"));
		colorMap.put("level2", props.getProperty("color.level.2"));
		colorMap.put("level3", props.getProperty("color.level.3"));
		colorMap.put("level4", props.getProperty("color.level.4"));
		colorMap.put("level5", props.getProperty("color.level.5"));
		colorMap.put("level6", props.getProperty("color.level.6"));
		
		return colorMap;
	}
	
	@Override
	public int setColor(LinkedHashMap<String, String> colorMap)
	{
		init();
		
		int result = Constants.Base.SUCCESS;
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("color.level.1", colorMap.get("level1"));
		map.put("color.level.2", colorMap.get("level2"));
		map.put("color.level.3", colorMap.get("level3"));
		map.put("color.level.4", colorMap.get("level4"));
		map.put("color.level.5", colorMap.get("level5"));
		map.put("color.level.6", colorMap.get("level6"));
		this.saveConfigItem(map);
		
		return result;
	}
	
	private void init()
	{
		try
		{
			props = new Properties();
			InputStream in = new FileInputStream(new File(this.getClass()
					.getClassLoader().getResource(CONFIG_FILE_PATH).toURI()));
			props.load(in);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private int saveConfigItem(LinkedHashMap<String, String> items)
	{
		int result = Constants.Base.SUCCESS;
		
		Set<String> keySet = items.keySet();
		for(String key : keySet)
		{
			props.setProperty(key, items.get(key));
		}
		try
		{
			props.store(new FileOutputStream(new File(this.getClass()
					.getClassLoader().getResource(CONFIG_FILE_PATH).toURI())), "");
		}
		catch (Exception e)
		{
			result = Constants.Base.FAIL;
			e.printStackTrace();
		}
		
		return result;
	}
}
