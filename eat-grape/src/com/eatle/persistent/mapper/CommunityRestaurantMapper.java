package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.merchant.CommunityRestaurant;
import com.eatle.persistent.pojo.merchant.CommunityRestaurantCriteria;
import java.util.List;
import java.util.Map;

public interface CommunityRestaurantMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(CommunityRestaurant record);

	int insertSelective(CommunityRestaurant record);

	List<CommunityRestaurant> selectByCriteria(CommunityRestaurantCriteria example);

	CommunityRestaurant selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(CommunityRestaurant record);

	int updateByPrimaryKey(CommunityRestaurant record);

	// 统计总的记录数
	long selectCountByCriteria(CommunityRestaurantCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<CommunityRestaurant> selectByMap(Map paramMap);
}