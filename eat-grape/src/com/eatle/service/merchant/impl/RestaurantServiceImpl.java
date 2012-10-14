package com.eatle.service.merchant.impl;

import com.eatle.persistent.mapper.RestaurantMapper;
import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria.Criteria;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("restaurantService")
public class RestaurantServiceImpl implements IRestaurantService
{
	@Resource
	private RestaurantMapper restaurantMapper;

	@Override
	public int add(Restaurant entity)
	{
		return restaurantMapper.insert(entity);
	}

	@Override
	public int delete(Restaurant entity)
	{
		return restaurantMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Restaurant entity)
	{
		return restaurantMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		RestaurantCriteria restaurantCriteria = new RestaurantCriteria();
		Criteria criteria = restaurantCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("merchantId"))
			{
				criteria.andMerchantIdEqualTo(Long.parseLong((String) queryMap.get("merchantId")));
			}
			if (queryMap.containsKey("name"))
			{
				criteria.andNameLike("%" + (String) queryMap.get("name") + "%");
			}
			if (queryMap.containsKey("address"))
			{
				criteria.andAddressLike("%" + (String) queryMap.get("address") + "%");
			}
			if (queryMap.containsKey("contactName"))
			{
				criteria.andBusinessHoursLike("%" + (String) queryMap.get("contactName") + "%");
			}
			if (queryMap.containsKey("contactPhone"))
			{
				criteria.andContactPhoneLike("%" + (String) queryMap.get("contactPhone") + "%");
			}
		}
		// 设置分页参数
		restaurantCriteria.setPageSize(pageSize);
		restaurantCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Restaurant> items = restaurantMapper.selectByCriteria(restaurantCriteria);
		int totalCount = (int) restaurantMapper.selectCountByCriteria(restaurantCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Restaurant findById(long id)
	{
		return restaurantMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Restaurant> findAll()
	{
		return restaurantMapper.selectByCriteria(null);
	}

	@Override
	public List<Restaurant> findByCriteria(RestaurantCriteria criteria)
	{
		return restaurantMapper.selectByCriteria(criteria);
	}
}