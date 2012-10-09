package com.eatle.web.action.backend.foundation.place;

import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria;
import com.eatle.persistent.pojo.foundation.place.School;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria.Criteria;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.service.foundation.place.ISchoolService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.utils.ReflectionUtils;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class SchoolAction extends BaseAction
{
	@Resource
	private ISchoolService schoolService;

	@Resource
	private IDistrictService districtService;

	private Pagination page;

	private School school;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public void setSchool(School school)
	{
		this.school = school;
	}

	public School getSchool()
	{
		return school;
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
		page = schoolService.findPagination(params, pageNum, pageSize);

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
		if (school == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			schoolService.add(school);
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (school == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			schoolService.delete(school);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		// 学校对象
		school = schoolService.findById(school.getId());
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
		if (school == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			School sl = schoolService.findById(school.getId());
			ReflectionUtils.copyPorperties(sl, school, new String[] { "name", "englishName", "districtId" });
			schoolService.update(sl);
		}
		super.writeMap(json);
	}
}