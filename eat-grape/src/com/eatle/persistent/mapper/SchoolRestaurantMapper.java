package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.place.School;
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

	/**
	 * @Description: 统计总的记录数
	 * @param example: 查询条件对象
	 */
	long selectCountByCriteria(SchoolRestaurantCriteria example);

	/**
	 * @Description: 通过map参数进行查询
	 * @param paramMap: 查询条件
	 */
	@SuppressWarnings("unchecked")
	List<SchoolRestaurant> selectByMap(Map paramMap);

	/**
	 * @Description: 根据餐厅ID查询所有送餐学校的条数
	 * @param queryMap: 查询条件
	 */
	long selectSendSchoolsCountByRestaurantId(Map<String, Object> queryMap);

	/**
	 * @Description: 根据餐厅ID查询所有送餐学校
	 * @param queryMap: 查询条件
	 */
	List<School> selectSendSchoolsByRestaurantId(Map<String, Object> queryMap);
}