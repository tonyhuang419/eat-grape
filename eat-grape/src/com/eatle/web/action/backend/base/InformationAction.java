package com.eatle.web.action.backend.base;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.web.action.BaseAction;

/** 
 * @corpor: sxit
 * @author: tanyouzhong
 * @Description: 餐厅基本资料Action（商家功能）
 * @date: 2013-7-28 上午12:49:37
 */
public class InformationAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	IRestaurantService restaurantService;

	private Restaurant restaurant;

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
		Long restaurantId = (Long) session.get("currMgrRestaurantId");
		if(restaurantId != null)
		{
			restaurant = restaurantService.findById(restaurantId);
		}

		return "showIndex";
	}
	
	public String showUpdate()
	{
		Long restaurantId = (Long) session.get("currMgrRestaurantId");
		if(restaurantId != null)
		{
			restaurant = restaurantService.findById(restaurantId);
		}
		
		return "showUpdate";
	}
}