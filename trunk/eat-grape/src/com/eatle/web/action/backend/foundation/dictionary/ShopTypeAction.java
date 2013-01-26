package com.eatle.web.action.backend.foundation.dictionary;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.foundation.dictionary.ShopType;
import com.eatle.service.foundation.dictionary.IShopTypeService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

public class ShopTypeAction extends BaseAction
{
	private static final long serialVersionUID = -3217007698801637305L;

	@Resource
	private IShopTypeService shopTypeService;

	private Pagination page;

	private ShopType shopType;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public void setShopType(ShopType shopType)
	{
		this.shopType = shopType;
	}

	public ShopType getShopType()
	{
		return shopType;
	}

	public String showIndex()
	{
		Map<String, Object> params = super.getRequestParameters(request);
		int pageNum = Pagination.CURRENTPAGE;
		int pageSize = Pagination.PAGESIZE;
		if (params.containsKey("pageNum"))
		{
			pageNum = Integer.parseInt((String) params.get("pageNum"));
		}
		if (params.containsKey("numPerPage"))
		{
			pageSize = Integer.parseInt((String) params.get("numPerPage"));
		}
		page = shopTypeService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public String showAdd()
	{
		return "showAdd";
	}

	public void add() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (shopType == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			int result = shopTypeService.add(shopType);
			if(result == Constants.Base.REPEAT)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "类型标识已存在，请重新输入！");
			}
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (shopType == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			shopTypeService.delete(shopType);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		shopType = shopTypeService.findById(shopType.getId());
		// 存入修改的主营类型，执行修改时查重使用
		session.put("oldShopType", shopType);
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (shopType == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			int result = shopTypeService.update(shopType, (ShopType) session.get("oldShopType"));
			if(result == Constants.Base.REPEAT)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "类型标识已存在，请重新输入！");
			}
			else if(result == Constants.Base.SUCCESS)
			{
				session.remove("oldShopType");
			}
		}
		super.writeMap(json);
	}
}