package com.eatle.web.action.backend.foundation.place;

import com.eatle.persistent.pojo.foundation.place.Community;
import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria.Criteria;
import com.eatle.service.foundation.place.ICommunityService;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.utils.ReflectionUtils;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class CommunityAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	private ICommunityService communityService;

	@Resource
	private IDistrictService districtService;

	private Pagination page;

	private Community community;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public void setCommunity(Community community)
	{
		this.community = community;
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
		page = communityService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public String showAdd()
	{
		// 查询并存入所有顶级区域
		DistrictCriteria dc = new DistrictCriteria();
		Criteria criteria = dc.createCriteria();
		criteria.andParentIdIsNull();
		List<District> topLevelDistrict = districtService.findByCriteria(dc);
		request.setAttribute("topLevelDistrict", topLevelDistrict);

		return "showAdd";
	}

	public void add() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (community == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			communityService.add(community);
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (community == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			communityService.delete(community);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		// 社区对象
		community = communityService.findById(community.getId());
		// 查询并存入所有顶级区域
		DistrictCriteria dc = new DistrictCriteria();
		Criteria criteria = dc.createCriteria();
		criteria.andParentIdIsNull();
		List<District> topLevelDistrict = districtService.findByCriteria(dc);
		request.setAttribute("topLevelDistrict", topLevelDistrict);

		return "showUpdate";
	}

	public void update() throws Exception
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (community == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			Community c = communityService.findById(community.getId());
			ReflectionUtils.copyPorperties(c, community, new String[] { "name",
					"pinyinName", "districtId" });
			communityService.update(c);
		}
		super.writeMap(json);
	}

	public Community getCommunity()
	{
		return community;
	}
}