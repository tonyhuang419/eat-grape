package com.eatle.service.foundation.dictionary;

import com.eatle.persistent.pojo.foundation.dictionary.MenuFeature;
import com.eatle.persistent.pojo.foundation.dictionary.MenuFeatureCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IMenuFeatureService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(MenuFeature entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(MenuFeature entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(MenuFeature entity);

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
	MenuFeature findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<MenuFeature> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<MenuFeature> findByCriteria(MenuFeatureCriteria criteria);
}