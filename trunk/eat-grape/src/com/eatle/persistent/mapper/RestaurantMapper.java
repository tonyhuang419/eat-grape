package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria;
import java.util.List;
import java.util.Map;

public interface RestaurantMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(Restaurant record);

	int insertSelective(Restaurant record);

	List<Restaurant> selectByCriteria(RestaurantCriteria example);

	Restaurant selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Restaurant record);

	int updateByPrimaryKey(Restaurant record);

	// 统计总的记录数
	long selectCountByCriteria(RestaurantCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<Restaurant> selectByMap(Map paramMap);
}