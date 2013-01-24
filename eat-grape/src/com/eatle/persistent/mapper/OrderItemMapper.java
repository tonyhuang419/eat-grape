package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.order.OrderItem;
import com.eatle.persistent.pojo.order.OrderItemCriteria;
import java.util.List;
import java.util.Map;

public interface OrderItemMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(OrderItem record);

	int insertSelective(OrderItem record);

	List<OrderItem> selectByCriteria(OrderItemCriteria example);

	OrderItem selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(OrderItem record);

	int updateByPrimaryKey(OrderItem record);

	// 统计总的记录数
	long selectCountByCriteria(OrderItemCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<OrderItem> selectByMap(Map paramMap);
}