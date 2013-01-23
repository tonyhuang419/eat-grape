package com.eatle.service.order.impl;

import com.eatle.persistent.mapper.OrderItemMapper;
import com.eatle.persistent.pojo.order.OrderItem;
import com.eatle.persistent.pojo.order.OrderItemCriteria.Criteria;
import com.eatle.persistent.pojo.order.OrderItemCriteria;
import com.eatle.service.order.IOrderItemService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
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
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		OrderItemCriteria orderItemCriteria = new OrderItemCriteria();
		Criteria criteria = orderItemCriteria.createCriteria();
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
		orderItemCriteria.setPageSize(pageSize);
		orderItemCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<OrderItem> items = orderItemMapper
				.selectByCriteria(orderItemCriteria);
		int totalCount = (int) orderItemMapper
				.selectCountByCriteria(orderItemCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
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
}