package com.eatle.web.action.backend.system.systemdata;

import com.eatle.common.Constants;
import com.eatle.service.system.systemdata.IColorIdentifyService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.web.action.BaseAction;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

public class ColorIdentifyAction extends BaseAction
{
	private static final long serialVersionUID = -3728029047940484616L;

	@Resource
	private IColorIdentifyService colorIdentifyService;

	private LinkedHashMap<String, String> colorMap;

	public LinkedHashMap<String, String> getColorMap()
	{
		return colorMap;
	}

	public void setColorMap(LinkedHashMap<String, String> colorMap)
	{
		this.colorMap = colorMap;
	}

	public String showIndex() throws ParseException
	{
		colorMap = colorIdentifyService.getAllColors();
		return "showIndex";
	}

	public void doSetColor() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (colorMap == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			int result = colorIdentifyService.setColor(colorMap);
			if(result == Constants.Base.FAIL)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "抱歉，保存失败！");
			}
		}
		super.writeMap(json);
	}
}