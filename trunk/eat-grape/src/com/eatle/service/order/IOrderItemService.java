package com.eatle.service.order;

import com.eatle.persistent.pojo.order.OrderItem;
import com.eatle.persistent.pojo.order.OrderItemCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

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
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize);

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
}