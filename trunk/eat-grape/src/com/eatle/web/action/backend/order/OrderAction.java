package com.eatle.web.action.backend.order;

import com.eatle.persistent.pojo.order.Order;
import com.eatle.persistent.pojo.order.OrderItem;
import com.eatle.service.order.IOrderItemService;
import com.eatle.service.order.IOrderService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class OrderAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	private IOrderService orderService;
	
	@Resource
	private IOrderItemService orderItemService;
	
	@Resource(name="orderStatusStr")
	private LinkedHashMap<String, String> status;
	
	@Resource(name="notifyTypeStr")
	private LinkedHashMap<String, String> notify;

	private Pagination page;

	private Order order;
	
	private List<OrderItem> orderItems;

	public LinkedHashMap<String, String> getStatus()
	{
		return status;
	}

	public void setStatus(LinkedHashMap<String, String> status)
	{
		this.status = status;
	}

	public LinkedHashMap<String, String> getNotify()
	{
		return notify;
	}

	public void setNotify(LinkedHashMap<String, String> notify)
	{
		this.notify = notify;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public Order getOrder()
	{
		return this.order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	public List<OrderItem> getOrderItems()
	{
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems)
	{
		this.orderItems = orderItems;
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
		page = orderService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (order == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			// 删除订单项
			orderItemService.deleteByOrderId(order.getId());
			// 删除订单
			orderService.delete(order);
		}
		super.writeMap(json);
	}

	/**
	 * @Description: 显示详细信息
	 */
	public String showDetail()
	{
		// 订单信息
		Map<String, Object> params = super.getRequestParameters(request);
		params.put("id", order.getId());
		order = (Order) orderService.findPagination(params, 1, 1).getItems().get(0);
		
		// 订单项集合
		orderItems = orderItemService.findOrderItemsByOrderId(order.getId());
		
		return "showDetail";
	}
}