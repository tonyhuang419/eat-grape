package com.eatle.web.action.backend.merchant;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria.Criteria;
import com.eatle.persistent.pojo.merchant.CommunityRestaurant;
import com.eatle.persistent.pojo.merchant.CommunityRestaurantCriteria;
import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.merchant.SchoolRestaurant;
import com.eatle.persistent.pojo.merchant.SchoolRestaurantCriteria;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.service.merchant.ICommunityRestaurantService;
import com.eatle.service.merchant.ISchoolRestaurantService;
import com.eatle.utils.DwzAjaxJsonUtil;
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

	@Resource
	private IDistrictService districtService;

	private SchoolRestaurant schoolRestaurant;

	private CommunityRestaurant communityRestaurant;

	private Restaurant restaurant;

	private Pagination page;

	public SchoolRestaurant getSchoolRestaurant()
	{
		return schoolRestaurant;
	}

	public void setSchoolRestaurant(SchoolRestaurant schoolRestaurant)
	{
		this.schoolRestaurant = schoolRestaurant;
	}

	public CommunityRestaurant getCommunityRestaurant()
	{
		return communityRestaurant;
	}

	public void setCommunityRestaurant(CommunityRestaurant communityRestaurant)
	{
		this.communityRestaurant = communityRestaurant;
	}

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
		return "showIndex";
	}

	/**
	 * @Description: 显示送餐学校Tab页签管理
	 */
	public String showSendSchoolTab()
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

		return "showSendSchoolTab";
	}

	/**
	 * @Description: 显示送餐社区/楼宇Tab页签管理
	 */
	public String showSendCommunityTab()
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
		page = communityRestaurantService.getSendCommunitiesByRestaurantId(params, pageNum, pageSize);

		return "showSendCommunityTab";
	}

	/**
	 * @Description: 显示送餐学校添加
	 */
	public String showAddSendSchool()
	{
		// 查询并存入所有顶级区域
		DistrictCriteria dc = new DistrictCriteria();
		Criteria criteria = dc.createCriteria();
		criteria.andParentIdIsNull();
		List<District> topLevelDistrict = districtService.findByCriteria(dc);
		request.setAttribute("topLevelDistrict", topLevelDistrict);
		
		return "showAddSendSchool";
	}

	/**
	 * @Description: 显示送餐社区/楼宇添加
	 */
	public String showAddSendCommunity()
	{
		// 查询并存入所有顶级区域
		DistrictCriteria dc = new DistrictCriteria();
		Criteria criteria = dc.createCriteria();
		criteria.andParentIdIsNull();
		List<District> topLevelDistrict = districtService.findByCriteria(dc);
		request.setAttribute("topLevelDistrict", topLevelDistrict);
		
		return "showAddSendCommunity";
	}

	/**
	 * @throws IOException 
	 * @Description: 添加送餐学校
	 */
	public void addSendSchool() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (schoolRestaurant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			SchoolRestaurantCriteria src = new SchoolRestaurantCriteria();
			com.eatle.persistent.pojo.merchant.SchoolRestaurantCriteria.Criteria criteria = src.createCriteria();
			criteria.andSchoolIdEqualTo(schoolRestaurant.getSchoolId());
			criteria.andRestaurantIdEqualTo(schoolRestaurant.getRestaurantId());
			if(schoolRestaurantService.findByCriteria(src).size() < 1)
			{
				schoolRestaurantService.add(schoolRestaurant);
			}
			else
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "送餐学校重复");
			}
		}
		super.writeMap(json);
	}

	/**
	 * @throws IOException 
	 * @Description: 添加送餐社区/楼宇
	 */
	public void addSendCommunity() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (communityRestaurant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			CommunityRestaurantCriteria crc = new CommunityRestaurantCriteria();
			com.eatle.persistent.pojo.merchant.CommunityRestaurantCriteria.Criteria criteria = crc.createCriteria();
			criteria.andCommunityIdEqualTo(communityRestaurant.getCommunityId());
			criteria.andRestaurantIdEqualTo(communityRestaurant.getRestaurantId());
			if(communityRestaurantService.findByCriteria(crc).size() < 1)
			{
				communityRestaurantService.add(communityRestaurant);
			}
			else
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "送餐社区重复");
			}
		}
		super.writeMap(json);
	}

	/**
	 * @throws IOException 
	 * @Description: 删除送餐学校
	 */
	public void delSendSchool() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (schoolRestaurant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			schoolRestaurantService.deleteBySelective(schoolRestaurant);
		}
		super.writeMap(json);
	}

	/**
	 * @throws IOException 
	 * @Description: 删除送餐社区/楼宇
	 */
	public void delSendCommunity() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (communityRestaurant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			communityRestaurantService.deleteBySelective(communityRestaurant);
		}
		super.writeMap(json);
	}
}