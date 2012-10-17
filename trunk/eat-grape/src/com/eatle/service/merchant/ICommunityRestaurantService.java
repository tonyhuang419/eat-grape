package com.eatle.service.merchant;

import com.eatle.persistent.pojo.merchant.CommunityRestaurant;
import com.eatle.persistent.pojo.merchant.CommunityRestaurantCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface ICommunityRestaurantService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(CommunityRestaurant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(CommunityRestaurant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(CommunityRestaurant entity);

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
	CommunityRestaurant findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<CommunityRestaurant> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<CommunityRestaurant> findByCriteria(CommunityRestaurantCriteria criteria);
}