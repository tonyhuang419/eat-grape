package com.eatle.service.order.impl;

import com.eatle.persistent.mapper.OrderMapper;
import com.eatle.persistent.pojo.order.Order;
import com.eatle.persistent.pojo.order.OrderCriteria.Criteria;
import com.eatle.persistent.pojo.order.OrderCriteria;
import com.eatle.service.order.IOrderService;
import com.eatle.utils.Pagination;
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
		OrderCriteria orderCriteria = new OrderCriteria();
		Criteria criteria = orderCriteria.createCriteria();
		// 设置搜索条件参数
		// if(queryMap != null){
		// if(queryMap.containsKey("username")){
		// criteria.andUserNameLike("%"+(String)queryMap.get("username")+"%");
		// }
		// if(queryMap.containsKey("email")){
		// criteria.andEmailLike((String)queryMap.get("email"));
		// }
		// }
		// 设置分页参数
		orderCriteria.setPageSize(pageSize);
		orderCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Order> items = orderMapper.selectByCriteria(orderCriteria);
		int totalCount = (int) orderMapper.selectCountByCriteria(orderCriteria);
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
}