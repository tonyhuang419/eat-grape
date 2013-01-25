package com.eatle.service.order.impl;

import com.eatle.persistent.mapper.OrderItemMapper;
import com.eatle.persistent.pojo.order.OrderItem;
import com.eatle.persistent.pojo.order.OrderItemCriteria.Criteria;
import com.eatle.persistent.pojo.order.OrderItemCriteria;
import com.eatle.service.order.IOrderItemService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("orderItemService")
public class OrderItemServiceImpl implements IOrderItemService
{
	@Resource
	private OrderItemMapper orderItemMapper;

	@Override
	public int add(OrderItem entity)
	{
		return orderItemMapper.insert(entity);
	}

	@Override
	public int delete(OrderItem entity)
	{
		return orderItemMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(OrderItem entity)
	{
		return orderItemMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public OrderItem findById(long id)
	{
		return orderItemMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<OrderItem> findAll()
	{
		return orderItemMapper.selectByCriteria(null);
	}

	@Override
	public List<OrderItem> findByCriteria(OrderItemCriteria criteria)
	{
		return orderItemMapper.selectByCriteria(criteria);
	}

	@Override
	public List<OrderItem> findOrderItemsByOrderId(Long orderId)
	{
		OrderItemCriteria orderItemCriteria = new OrderItemCriteria();
		Criteria criteria = orderItemCriteria.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		return orderItemMapper.selectByCriteria(orderItemCriteria);
	}

	@Override
	public int deleteByOrderId(Long orderId)
	{
		return orderItemMapper.deleteByOrderId(orderId);
	}
}