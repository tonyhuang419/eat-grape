package com.eatle.web.action.backend.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.SystemNotice;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.frontdata.ISystemNoticeService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;

public class SystemNoticeAction extends BaseAction
{
	private static final long serialVersionUID = -8918384589226376549L;

	@Resource
	private ISystemNoticeService systemNoticeService;

	private Pagination page;

	private SystemNotice systemNotice;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public SystemNotice getSystemNotice()
	{
		return systemNotice;
	}

	public void setSystemNotice(SystemNotice systemNotice)
	{
		this.systemNotice = systemNotice;
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
		page = systemNoticeService.findPagination(params, pageNum, pageSize);
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
		if (systemNotice == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			systemNotice.setUserId(((User) session.get("user")).getId());
			systemNotice.setSendTime(new Date());
			systemNoticeService.add(systemNotice);
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (systemNotice == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			systemNoticeService.delete(systemNotice);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		systemNotice = systemNoticeService.findById(systemNotice.getId());
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (systemNotice == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			systemNoticeService.update(systemNotice);
		}
		super.writeMap(json);
	}
}