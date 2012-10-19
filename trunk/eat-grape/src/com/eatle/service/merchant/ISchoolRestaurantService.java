package com.eatle.service.merchant;

import com.eatle.persistent.pojo.merchant.SchoolRestaurant;
import com.eatle.persistent.pojo.merchant.SchoolRestaurantCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface ISchoolRestaurantService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(SchoolRestaurant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(SchoolRestaurant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(SchoolRestaurant entity);

	/**
	 * @Description:
	 * 
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize);

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	SchoolRestaurant findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<SchoolRestaurant> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<SchoolRestaurant> findByCriteria(SchoolRestaurantCriteria criteria);
	
	/**
	 * @Description: 根据餐厅ID获取所有送餐学校
	 * @param queryMap: 查询条件
	 * @param startIndex: 起始索引
	 * @param pageSize: 分页大小
	 */
	Pagination getSendSchoolsByRestaurantId(Map<String, Object> queryMap, int currentPage, int pageSize);
}