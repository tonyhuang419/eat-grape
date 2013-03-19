package com.eatle.web.action.backend.customer;

import com.eatle.persistent.pojo.customer.Customer;
import com.eatle.service.customer.ICustomerService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Resource;

public class CustomerAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	private ICustomerService customerService;

	@Resource(name = "customerEnabledStr")
	private LinkedHashMap<String, String> enabled;

	private Pagination page;

	private Customer customer;

	public LinkedHashMap<String, String> getEnabled()
	{
		return enabled;
	}

	public void setEnabled(LinkedHashMap<String, String> enabled)
	{
		this.enabled = enabled;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Customer getCustomer()
	{
		return this.customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
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
		page = customerService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	/**
	 * @Description: 删除顾客账号
	 */
	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (customer == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			customerService.delete(customer);
		}
		super.writeMap(json);
	}

	/**
	 * @Description: 显示详细信息
	 */
	public String showDetail()
	{
		// 顾客信息
		customer = customerService.findById(customer.getId());
		return "showDetail";
	}
	
	/**
	 * @Description: 改变顾客账号可用状态（禁用或激活）
	 */
	public void changeEnable() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (customer == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			if(!customerService.changeEnabled(customer))
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
			}
		}
		super.writeMap(json);
	}
	
	/**
	 * @Description: 重置顾客账号密码（默认重置为登录邮箱）
	 */
	public void resetPassword() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (customer == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			if(!customerService.resetPassword(customer))
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
			}
		}
		super.writeMap(json);
	}
}