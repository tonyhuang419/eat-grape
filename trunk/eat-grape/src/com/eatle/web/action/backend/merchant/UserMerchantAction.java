package com.eatle.web.action.backend.merchant;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria;
import com.eatle.persistent.pojo.merchant.UserMerchant;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria.Criteria;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.service.merchant.IUserMerchantService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.utils.StringUtil;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class UserMerchantAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	private IUserMerchantService userMerchantService;
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IRestaurantService restaurantService;

	private Pagination page;

	private UserMerchant userMerchant;
	
	private List<User> users;
	
	private List<Restaurant> restaurants;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public UserMerchant getUserMerchant()
	{
		return this.userMerchant;
	}

	public void setUserMerchant(UserMerchant userMerchant)
	{
		this.userMerchant = userMerchant;
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	public List<Restaurant> getRestaurants()
	{
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants)
	{
		this.restaurants = restaurants;
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
		page = userMerchantService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public String showAdd()
	{
		// 获取所有用户
		users = userService.findAll();
		// 根据商家ID获取相应餐厅
		RestaurantCriteria rc = new RestaurantCriteria();
		Criteria criteria = rc.createCriteria();
		criteria.andMerchantIdEqualTo(userMerchant.getMerchantId());
		restaurants = restaurantService.findByCriteria(rc);
		return "showAdd";
	}

	public void add() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (userMerchant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			userMerchant.setManageRestaurantList(
					StringUtil.trim(userMerchant.getManageRestaurantList()));
			int result = userMerchantService.add(userMerchant);
			if(result == Constants.Base.REPEAT)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "抱歉，账号已被占用，请选择其它账号！");
			}
		
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (userMerchant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			userMerchantService.delete(userMerchant);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		// 被修改对象
		userMerchant = userMerchantService.findById(userMerchant.getId());
		// 获取所有用户
		users = userService.findAll();
		// 根据商家ID获取相应餐厅
		RestaurantCriteria rc = new RestaurantCriteria();
		Criteria criteria = rc.createCriteria();
		criteria.andMerchantIdEqualTo(userMerchant.getMerchantId());
		restaurants = restaurantService.findByCriteria(rc);
		// 对可管理餐厅处理，将可管理的餐厅标记，迭代展示时使用
		List<String> ids = Arrays.asList(userMerchant.getManageRestaurantList().split(","));
		for(Restaurant r : restaurants)
		{
			if(ids.contains(r.getId() + ""))
			{
				r.setIsManaged(true);
			}
		}
		// 存入被修改的对象，执行修改时查重使用
		session.put("oldUserMerchant", userMerchant);
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (userMerchant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			userMerchant.setManageRestaurantList(
					StringUtil.trim(userMerchant.getManageRestaurantList()));
			int result = userMerchantService.update(userMerchant, (UserMerchant) session.get("oldUserMerchant"));
			if(result == Constants.Base.REPEAT)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "抱歉，账号已被占用，请选择其它账号！");
			}
			else if(result == Constants.Base.SUCCESS)
			{
				session.remove("oldUserMerchant");
			}
		}
		super.writeMap(json);
	}
}