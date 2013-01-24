package com.eatle.service.order;

import com.eatle.persistent.pojo.order.Order;
import com.eatle.persistent.pojo.order.OrderCriteria;
import com.eatle.utils.Pagination;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IOrderService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(Order entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(Order entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(Order entity);

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
	Order findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<Order> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<Order> findByCriteria(OrderCriteria criteria);

	/**
	 * @Description: 数据导出到Excel
	 * 
	 */
	@SuppressWarnings("unchecked")
	LinkedHashMap<String, List> getExportData();
}