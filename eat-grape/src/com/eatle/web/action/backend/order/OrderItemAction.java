package com.eatle.web.action.backend.order;

//import com.eatle.persistent.pojo.order.OrderItem;
//import com.eatle.service.order.IOrderItemService;
//import com.eatle.utils.DwzAjaxJsonUtil;
//import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
//import java.io.IOException;
//import java.util.Map;
//import javax.annotation.Resource;

public class OrderItemAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

//	@Resource
//	private IOrderItemService orderItemService;
//
//	private Pagination page;
//
//	private OrderItem orderItem;
//
//	public void setPage(Pagination page)
//	{
//		this.page = page;
//	}
//
//	public Pagination getPage()
//	{
//		return this.page;
//	}
//
//	public OrderItem getOrderItem()
//	{
//		return this.orderItem;
//	}
//
//	public void setOrderItem(OrderItem orderItem)
//	{
//		this.orderItem = orderItem;
//	}
//
//	public String showIndex()
//	{
//		Map<String, Object> params = super.getRequestParameters(request);
//		int pageNum = Pagination.CURRENTPAGE;
//		int pageSize = Pagination.PAGESIZE;
//		if (params.containsKey("pageNum"))
//		{
//			pageNum = Integer.parseInt((String) params.get("pageNum"));
//		}
//		if (params.containsKey("numPerPage"))
//		{
//			pageSize = Integer.parseInt((String) params.get("numPerPage"));
//		}
//		page = orderItemService.findPagination(params, pageNum, pageSize);
//		return "showIndex";
//	}
//
//	public String showAdd()
//	{
//		return "showAdd";
//	}
//
//	public void add() throws IOException
//	{
//		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
//		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
//		if (orderItem == null)
//		{
//			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
//			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
//		}
//		else
//		{
//			orderItemService.add(orderItem);
//		}
//		super.writeMap(json);
//	}
//
//	public void delete() throws IOException
//	{
//		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
//		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
//		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
//		if (orderItem == null)
//		{
//			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
//			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
//		}
//		else
//		{
//			orderItemService.delete(orderItem);
//		}
//		super.writeMap(json);
//	}
//
//	public String showUpdate()
//	{
//		orderItem = orderItemService.findById(orderItem.getId());
//		return "showUpdate";
//	}
//
//	public void update() throws IOException
//	{
//		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
//		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
//		if (orderItem == null)
//		{
//			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
//			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
//		}
//		else
//		{
//			orderItemService.update(orderItem);
//		}
//		super.writeMap(json);
//	}
}