package com.eatle.web.action.backend.merchant;

import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

public class RestaurantAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	private IRestaurantService restaurantService;
	
	@Resource
	private IMerchantService merchantService;

	private Pagination page;

	private Restaurant restaurant;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public Restaurant getRestaurant()
	{
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
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
		page = restaurantService.findPagination(params, pageNum, pageSize);
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
		if (restaurant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			restaurantService.add(restaurant);
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (restaurant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			restaurantService.delete(restaurant);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		restaurant = restaurantService.findById(restaurant.getId());
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (restaurant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			restaurantService.update(restaurant);
		}
		super.writeMap(json);
	}
	
	/**
	 * @deprecated: 显示详细信息
	 */
	public String showDetail()
	{
		restaurant = restaurantService.findById(restaurant.getId());
		// 设置所属商家
		restaurant.setMerchantName(merchantService.
				findById(restaurant.getMerchantId()).getMerchantName());
		
		return "showDetail";
	}

	/**
	 * @deprecated: 显示Logo上传
	 */
	public String showLogoUpload()
	{
		return "showLogoUpload";
	}
	
	/**
	 * @deprecated: 显示营业时间设置
	 */
	public String showSetBusinessHours()
	{
		return "showSetBusinessHours";
	}
	
	/**
	 * @deprecated: 设置营业时间
	 */
	public String setBusinessHours()
	{
		return "setBusinessHours";
	}
	
	/**
	 * @deprecated: 显示送餐地点设置
	 */
	public String showSetSendPlace()
	{
		return "showSetSendPlace";
	}

	/**
	 * @deprecated: 设置送餐地点
	 */
	public String setSendPlace()
	{
		return "setSendPlace";
	}
}