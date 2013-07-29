package com.eatle.web.action.backend;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.service.merchant.IUserMerchantService;
import com.eatle.service.system.useradmin.IPrivService;
import com.eatle.web.action.BaseAction;

/**
 * @Description: 主页
 * @Author: asus
 * @Since: 2012-6-18
 * @Version: 1.1.0
 */
public class IndexAction extends BaseAction
{

	private static final long serialVersionUID = -5221880781064937400L;

//	@Resource
//	private IMenuService menuService;
	
	@Resource
	private IPrivService privService;
	
	@Resource
	private IUserMerchantService userMerchantService;
	
	@Resource
	private IRestaurantService restaurantService;
	
	private Restaurant restaurant;
	
	private List<Restaurant> restaurants;
	
	public String index()
	{
		// 当前登陆用户
		User user = (User) session.get("user");
	
		// 当前登录用户所属角色拥有的权限集合
		Map<String, Priv> allPrivs = user.getAllPrivs();
		String contextPath = request.getContextPath();
		// 存入菜单HTML
		//String allMenuHtml = menuService.findAllMenu(allPrivs,contextPath);
		//request.setAt	tribute("allMenuHtml", allMenuHtml);
		
		//FIX 改为通过Priv里的is_show字段来显示
		String allMenuHtml = privService.findAllPrivMenu(contextPath, allPrivs);
		request.setAttribute("allMenuHtml", allMenuHtml);
		
		// 判定登陆用户是管理员还是商家
		if(user.getType() != Constants.UserType.USERTYPE_ADMINISTRATOR)
		{
			// 可管理的餐厅
			restaurants = userMerchantService
					.findRestaurantsByUserIdAndMerchantId(user.getId(), 
							user.getMerchantId());
			// 切换管理餐厅
			if(session.get("currMgrRestaurantId") != null)
			{
				if(restaurant != null && restaurant.getId() != null)	// 选择切换
				{
					restaurant = restaurantService.findById(restaurant.getId());
				}
				else	// 切换后，用户手动刷新页面，则不会带餐厅id过来
				{
					restaurant = restaurantService.findById((Long) session.get("currMgrRestaurantId"));
				}
				session.put("currMgrRestaurantId", restaurant.getId());
				session.put("currMgrRestaurantName", restaurant.getName());
			}
			else
			{
				// 存入当前默认管理餐厅id（第一次登陆进入主页）
				if(restaurants.size() > 0)
				{
					session.put("currMgrRestaurantId", restaurants.get(0).getId());
					session.put("currMgrRestaurantName", restaurants.get(0).getName());
				}
			}
		}
		
		return SUCCESS;
	}

	
	public Restaurant getRestaurant()
	{
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}

	public List<Restaurant> getRestaurants()
	{
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants)
	{
		this.restaurants = restaurants;
	}
}
