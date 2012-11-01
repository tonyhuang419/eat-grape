package com.eatle.web.action.backend.foundation.business;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.foundation.business.JoinInformation;
import com.eatle.service.foundation.business.IJoinInformationService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;

public class JoinInformationAction extends BaseAction
{
	private static final long serialVersionUID = -5691630973563793082L;

	@Resource
	private IJoinInformationService joinInformationService;

	private Pagination page;

	private JoinInformation joinInformation;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public void setJoinInformation(JoinInformation joinInformation)
	{
		this.joinInformation = joinInformation;
	}

	public JoinInformation getJoinInformation()
	{
		return joinInformation;
	}

	public String showIndex() throws ParseException
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
		page = joinInformationService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (joinInformation == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			joinInformationService.delete(joinInformation);
		}
		super.writeMap(json);
	}
	
	/**
	 * @Description: 显示加盟审核详细信息
	 */
	public String showDetail()
	{
		joinInformation = joinInformationService.findById(joinInformation.getId());
		return "showDetail";
	}

	/**
	 * @Description: 显示加盟审核
	 */
	public String showAudit()
	{
		return "showAudit";
	}

	/**
	 * @Description: 审核加盟信息
	 */
	public void audit() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (joinInformation == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			joinInformation.setAuditStatus(Constants.Status.STATUS_COMPLETED);
			joinInformation.setAuditTime(new Date());
			joinInformationService.update(joinInformation);
		}
		super.writeMap(json);
	}
}