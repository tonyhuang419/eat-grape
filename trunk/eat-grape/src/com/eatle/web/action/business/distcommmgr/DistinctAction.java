package com.eatle.web.action.business.distcommmgr;

import com.eatle.persistent.pojo.business.distcommmgr.Distinct;
import com.eatle.persistent.pojo.business.distcommmgr.DistinctCriteria;
import com.eatle.persistent.pojo.business.distcommmgr.DistinctCriteria.Criteria;
import com.eatle.service.business.distcommmgr.IDistinctService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class DistinctAction extends BaseAction
{
	private static final long serialVersionUID = 2708483163314074391L;

	@Resource
	private IDistinctService distinctService;

	private Pagination page;

	private Distinct distinct;

	private List<Distinct> list;
	
	public IDistinctService getDistinctService()
	{
		return distinctService;
	}

	public void setDistinctService(IDistinctService distinctService)
	{
		this.distinctService = distinctService;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public Distinct getDistinct()
	{
		return distinct;
	}

	public void setDistinct(Distinct distinct)
	{
		this.distinct = distinct;
	}

	public List<Distinct> getList()
	{
		return list;
	}

	public void setList(List<Distinct> list)
	{
		this.list = list;
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
		params.put("pidisnull", null);
		page = distinctService.findPagination(params, pageNum, pageSize);
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
		json.put(DwzAjaxJsonUtil.KEY_DIALOGID, dialogId);
		json.put("pid", distinct.getParentId());
		if (distinct == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			distinctService.add(distinct);
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (distinct == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			distinctService.delete(distinct);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		distinct = distinctService.findById(distinct.getId());
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (distinct == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			distinctService.update(distinct);
		}
		super.writeMap(json);
	}

	public String showSetSubDist()
	{
		Map<String, Object> params = super.getRequestParameters(request);
		Object parentId = params.get("pid");
		DistinctCriteria distinctCriteria = new DistinctCriteria();
		Criteria criteria = distinctCriteria.createCriteria();
		criteria.andParentIdIsNotNull();
		criteria.andParentIdEqualTo(Long.parseLong((String) parentId));
		list = distinctService.findByCriteria(distinctCriteria);

		return "showSetSubDist";
	}
}