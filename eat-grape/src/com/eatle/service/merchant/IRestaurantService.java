package com.eatle.service.merchant;

import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria;
import com.eatle.utils.Pagination;

import java.util.LinkedHashMap;
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

	/**
	 * @Description: 数据导出到Excel
	 * 
	 */
	@SuppressWarnings("unchecked")
	LinkedHashMap<String, List> getExportData();
	
	/**
	 * @Description: 根据ID集合查询出餐厅集合
	 * @param : id集合数组
	 */
	String findByMultiIds(String[] ids, String separatorChars);
	/**
	 * @Description: 根据ID集合查询出餐厅集合
	 * @param : id集合数组
	 */
	List<Restaurant> findByMultiIds(String[] ids);
}