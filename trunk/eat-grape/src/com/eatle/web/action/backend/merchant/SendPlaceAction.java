package com.eatle.web.action.backend.merchant;

import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.service.merchant.ICommunityRestaurantService;
import com.eatle.service.merchant.ISchoolRestaurantService;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：餐厅送餐地点管理
 * @version 日期：2012-10-17 下午10:42:49
 */
public class SendPlaceAction extends BaseAction
{
	private static final long serialVersionUID = 4352897890873020136L;

	@Resource
	ISchoolRestaurantService schoolRestaurantService;
	
	@Resource
	ICommunityRestaurantService communityRestaurantService;
	
	private Restaurant restaurant;
	
	private Pagination page;
	
	
	public Restaurant getRestaurant()
	{
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}

	public Pagination getPage()
	{
		return page;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	/**
	 * @Description: 显示送餐地点设置
	 */
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
		page = schoolRestaurantService.getSendSchoolsByRestaurantId(params, pageNum, pageSize);
		
		return "showIndex";
	}

	/**
	 * @Description: 显示送餐学校Tab页签管理
	 */
	public String showSchoolTab()
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
		page = schoolRestaurantService.getSendSchoolsByRestaurantId(params, pageNum, pageSize);
		
		return "showSchoolTab";
	}

	/**
	 * @Description: 显示送餐社区/楼宇Tab页签管理
	 */
	public String showCommunityTab()
	{
		return "showCommunityTab";
	}
}
