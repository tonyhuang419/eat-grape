package com.eatle.web.action.backend.foundation.business;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.foundation.business.Feedback;
import com.eatle.service.foundation.business.IFeedbackService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Resource;

public class FeedbackAction extends BaseAction
{
	private static final long serialVersionUID = -4123927220891205325L;

	@Resource
	private IFeedbackService feedbackService;
	
	@Resource(name="handleStatusStr")
	private LinkedHashMap<String, String> status;
	
	@Resource(name="userIdentityStr")
	private LinkedHashMap<String, String> userIdentity;

	private Pagination page;

	private Feedback feedback;

	public LinkedHashMap<String, String> getStatus()
	{
		return status;
	}

	public void setStatus(LinkedHashMap<String, String> status)
	{
		this.status = status;
	}

	public LinkedHashMap<String, String> getUserIdentity()
	{
		return userIdentity;
	}

	public void setUserIdentity(LinkedHashMap<String, String> userIdentity)
	{
		this.userIdentity = userIdentity;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public Feedback getFeedback()
	{
		return feedback;
	}

	public void setFeedback(Feedback feedback)
	{
		this.feedback = feedback;
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
		page = feedbackService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public String showAdd()
	{
		return "showAdd";
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (feedback == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			feedbackService.delete(feedback);
		}
		super.writeMap(json);
	}
	
	/**
	 * @Description: 显示反馈建议详细信息
	 */
	public String showDetail()
	{
		feedback = feedbackService.findById(feedback.getId());
		if(feedback.getHandleStatus() == Constants.Status.STATUS_WAIT_HANDLE)
		{
			feedback.setHandleStatus(Constants.Status.STATUS_VIEWED);
			feedbackService.update(feedback);
		}
		return "showDetail";
	}

	/**
	 * @Description: 显示反馈建议处理
	 */
	public String showHandle()
	{
		return "showHandle";
	}

	/**
	 * @Description: 处理反馈建议信息
	 */
	public void handle() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (feedback == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			feedback.setHandleStatus(Constants.Status.STATUS_HANDLED);
			feedback.setHandleTime(new Date());
			feedbackService.update(feedback);
		}
		super.writeMap(json);
	}
}