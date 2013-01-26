package com.eatle.service.order;

import com.eatle.persistent.pojo.order.OrderItem;
import com.eatle.persistent.pojo.order.OrderItemCriteria;
import java.util.List;

public interface IOrderItemService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(OrderItem entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(OrderItem entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(OrderItem entity);

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	OrderItem findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<OrderItem> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<OrderItem> findByCriteria(OrderItemCriteria criteria);

	/**
	 * @Description: 根据订单ID查询订单项
	 */
	List<OrderItem> findOrderItemsByOrderId(Long orderId);
	
	/**
	 * @Description: 根据订单ID删除订单项
	 */
	int deleteByOrderId(Long orderId);
}