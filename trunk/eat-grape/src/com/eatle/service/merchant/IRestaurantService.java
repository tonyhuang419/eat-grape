package com.eatle.service.merchant;

import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IRestaurantService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(Restaurant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(Restaurant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(Restaurant entity);

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
	Restaurant findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<Restaurant> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<Restaurant> findByCriteria(RestaurantCriteria criteria);
}