package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.place.Community;
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

	/**
	 * @Description: 统计总的记录数
	 * @param example: 查询条件对象
	 */
	long selectCountByCriteria(CommunityRestaurantCriteria example);

	/**
	 * @Description: 通过map参数进行查询
	 * @param paramMap: 查询条件
	 */
	@SuppressWarnings("unchecked")
	List<CommunityRestaurant> selectByMap(Map paramMap);
	
	/**
	 * @Description: 根据餐厅ID查询所有送餐社区/楼宇的条数
	 * @param queryMap: 查询条件
	 */
	long selectSendCommunitiesCountByRestaurantId(Map<String, Object> queryMap);
	
	/**
	 * @Description: 根据餐厅ID查询所有送餐社区/楼宇
	 * @param queryMap: 查询条件
	 */
	List<Community> selectSendCommunitiesByRestaurantId(Map<String, Object> queryMap);
}