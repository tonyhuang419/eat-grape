package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.merchant.SchoolRestaurant;
import com.eatle.persistent.pojo.merchant.SchoolRestaurantCriteria;
import java.util.List;
import java.util.Map;

public interface SchoolRestaurantMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(SchoolRestaurant record);

	int insertSelective(SchoolRestaurant record);

	List<SchoolRestaurant> selectByCriteria(SchoolRestaurantCriteria example);

	SchoolRestaurant selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SchoolRestaurant record);

	int updateByPrimaryKey(SchoolRestaurant record);

	// 统计总的记录数
	long selectCountByCriteria(SchoolRestaurantCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<SchoolRestaurant> selectByMap(Map paramMap);
}