package com.eatle.service.foundation.place;

import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria;
import com.eatle.utils.Pagination;

import java.util.List;
import java.util.Map;

public interface IDistrictService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(District entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(District entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(District entity);

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
	District findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<District> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<District> findByCriteria(DistrictCriteria criteria);

	/**
	 * @Description:
	 * 
	 */
	void findAllFatherById(long id, StringBuffer fatherStr);
}