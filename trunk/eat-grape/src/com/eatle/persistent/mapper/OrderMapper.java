package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.order.Order;
import com.eatle.persistent.pojo.order.OrderCriteria;
import java.util.List;
import java.util.Map;

public interface OrderMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(Order record);

	int insertSelective(Order record);

	List<Order> selectByCriteria(OrderCriteria example);

	Order selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);

	// 统计总的记录数
	long selectCountByCriteria(OrderCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<Order> selectByMap(Map paramMap);
	
	/**
	 * @Description: 根据条件去t_order、t_customer、t_restaurant查询订单记录
	 * @param queryMap: 查询条件
	 */
	List<Order> selectOrdersByCondition(Map<String, Object> queryMap);
	
	/**
	 * @Description: 根据条件去t_order、t_customer、t_restaurant查询订单记录条数
	 * @param queryMap: 查询条件
	 */
	long selectOrdersCountByCondition(Map<String, Object> queryMap);
}