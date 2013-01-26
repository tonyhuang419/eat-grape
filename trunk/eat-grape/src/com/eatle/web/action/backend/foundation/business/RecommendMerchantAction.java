package com.eatle.web.action.backend.foundation.business;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchant;
import com.eatle.service.foundation.business.IRecommendMerchantService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Resource;

public class RecommendMerchantAction extends BaseAction
{
	private static final long serialVersionUID = -5715111086568337877L;

	@Resource
	private IRecommendMerchantService recommendMerchantService;
	
	@Resource(name="handleStatusStr")
	private LinkedHashMap<String, String> status;

	private Pagination page;

	private RecommendMerchant recommendMerchant;

	public LinkedHashMap<String, String> getStatus()
	{
		return status;
	}

	public void setStatus(LinkedHashMap<String, String> status)
	{
		this.status = status;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public RecommendMerchant getRecommendMerchant()
	{
		return recommendMerchant;
	}

	public void setRecommendMerchant(RecommendMerchant recommendMerchant)
	{
		this.recommendMerchant = recommendMerchant;
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
		page = recommendMerchantService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (recommendMerchant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			recommendMerchantService.delete(recommendMerchant);
		}
		super.writeMap(json);
	}
	
	/**
	 * @Description: 显示顾客推荐详细信息
	 */
	public String showDetail()
	{
		recommendMerchant = recommendMerchantService.findById(recommendMerchant.getId());
		if(recommendMerchant.getHandleStatus() == Constants.Status.STATUS_WAIT_HANDLE)
		{
			recommendMerchant.setHandleStatus(Constants.Status.STATUS_VIEWED);
			recommendMerchantService.update(recommendMerchant);
		}
		return "showDetail";
	}

	/**
	 * @Description: 显示顾客推荐处理
	 */
	public String showHandle()
	{
		return "showHandle";
	}

	/**
	 * @Description: 处理顾客推荐信息
	 */
	public void handle() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (recommendMerchant == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			recommendMerchant.setHandleStatus(Constants.Status.STATUS_HANDLED);
			recommendMerchant.setHandleTime(new Date());
			recommendMerchantService.update(recommendMerchant);
		}
		super.writeMap(json);
	}
}