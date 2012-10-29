package com.eatle.web.action.backend.system.systemdata;

import com.eatle.persistent.pojo.system.systemdata.LoginLog;
import com.eatle.service.system.systemdata.ILoginLogService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import javax.annotation.Resource;

public class LoginLogAction extends BaseAction
{
	private static final long serialVersionUID = -3728029047940484616L;

	@Resource
	private ILoginLogService loginLogService;

	private Pagination page;

	private LoginLog loginLog;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public void setLoginLog(LoginLog loginLog)
	{
		this.loginLog = loginLog;
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
		page = loginLogService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (loginLog == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			loginLogService.delete(loginLog);
		}
		super.writeMap(json);
	}
}