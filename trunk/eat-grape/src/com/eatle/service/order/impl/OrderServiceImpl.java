package com.eatle.service.order.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.OrderMapper;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecords;
import com.eatle.persistent.pojo.order.Order;
import com.eatle.persistent.pojo.order.OrderCriteria.Criteria;
import com.eatle.persistent.pojo.order.OrderCriteria;
import com.eatle.service.order.IOrderService;
import com.eatle.utils.Pagination;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements IOrderService
{
	@Resource
	private OrderMapper orderMapper;

	@Override
	public int add(Order entity)
	{
		return orderMapper.insert(entity);
	}

	@Override
	public int delete(Order entity)
	{
		return orderMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Order entity)
	{
		return orderMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		int totalCount = (int) orderMapper.selectOrdersCountByCondition(queryMap);
		
		queryMap.put("startIndex", (currentPage - 1) * pageSize);
		queryMap.put("pageSize", pageSize);
		
		List<Order> items = orderMapper.selectOrdersByCondition(queryMap);
		for(Order o : items)
		{
			// 设置下单时间
			o.setOrderTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getOrderTime()));
			// 设置送餐时间
			o.setSendTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getSendTime()));
			// 设置订单状态
			int os = o.getOrderStatus();
			if(os == Constants.OrderStatus.ORDER_STATUS_WAITCONFIRM)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_WAITCONFIRM_HTML);
			if(os == Constants.OrderStatus.ORDER_STATUS_CONFIRMED)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_CONFIRMED_HTML);
			if(os == Constants.OrderStatus.ORDER_STATUS_SENDING)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_SENDING_HTML);
			if(os == Constants.OrderStatus.ORDER_STATUS_SENDOK)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_SENDOK_HTML);
			if(os == Constants.OrderStatus.ORDER_STATUS_SENDFAIL)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_SENDFAIL_HTML);
			if(os == Constants.OrderStatus.ORDER_STATUS_CANCEL)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_CANCEL_HTML);
			// 设置通知类型
			int nt = o.getNotifyType();
			if(nt == Constants.NotifyType.NOTIFY_TYPE_NONE)
				o.setNotifyTypeStr(Constants.NotifyType.NOTIFY_TYPE_NONE_HTML);
			if(nt == Constants.NotifyType.NOTIFY_TYPE_SMS)
				o.setNotifyTypeStr(Constants.NotifyType.NOTIFY_TYPE_SMS_HTML);
			if(nt == Constants.NotifyType.NOTIFY_TYPE_TEL)
				o.setNotifyTypeStr(Constants.NotifyType.NOTIFY_TYPE_TEL_HTML);
			
		}

		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Order findById(long id)
	{
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Order> findAll()
	{
		return orderMapper.selectByCriteria(null);
	}

	@Override
	public List<Order> findByCriteria(OrderCriteria criteria)
	{
		return orderMapper.selectByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		
		List<Order> items = orderMapper.selectOrdersByCondition(null);
		for(Order o : items)
		{
			// 设置下单时间
			o.setOrderTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getOrderTime()));
			// 设置送餐时间
			o.setSendTimeStr(new SimpleDateFormat("HH:mm:ss").format(o.getSendTime()));
			// 设置订单状态
			int os = o.getOrderStatus();
			if(os == Constants.OrderStatus.ORDER_STATUS_WAITCONFIRM)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_WAITCONFIRM_STR);
			if(os == Constants.OrderStatus.ORDER_STATUS_CONFIRMED)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_CONFIRMED_STR);
			if(os == Constants.OrderStatus.ORDER_STATUS_SENDING)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_SENDING_STR);
			if(os == Constants.OrderStatus.ORDER_STATUS_SENDOK)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_SENDOK_STR);
			if(os == Constants.OrderStatus.ORDER_STATUS_SENDFAIL)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_SENDFAIL_STR);
			if(os == Constants.OrderStatus.ORDER_STATUS_CANCEL)
				o.setOrderStatusStr(Constants.OrderStatus.ORDER_STATUS_CANCEL_STR);
			// 设置通知类型
			int nt = o.getNotifyType();
			if(nt == Constants.NotifyType.NOTIFY_TYPE_NONE)
				o.setNotifyTypeStr(Constants.NotifyType.NOTIFY_TYPE_NONE_STR);
			if(nt == Constants.NotifyType.NOTIFY_TYPE_SMS)
				o.setNotifyTypeStr(Constants.NotifyType.NOTIFY_TYPE_SMS_STR);
			if(nt == Constants.NotifyType.NOTIFY_TYPE_TEL)
				o.setNotifyTypeStr(Constants.NotifyType.NOTIFY_TYPE_TEL_STR);
		}
		map.put("订单记录数据", items);
		
		return map;
	}
}