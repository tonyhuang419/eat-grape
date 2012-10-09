package com.eatle.service.foundation.place;

import com.eatle.persistent.pojo.foundation.place.Community;
import com.eatle.persistent.pojo.foundation.place.CommunityCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface ICommunityService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(Community entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(Community entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(Community entity);

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
	Community findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<Community> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<Community> findByCriteria(CommunityCriteria criteria);
}