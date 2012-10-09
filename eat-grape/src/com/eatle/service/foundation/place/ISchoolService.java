package com.eatle.service.foundation.place;

import com.eatle.persistent.pojo.foundation.place.School;
import com.eatle.persistent.pojo.foundation.place.SchoolCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface ISchoolService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(School entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(School entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(School entity);

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
	School findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<School> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<School> findByCriteria(SchoolCriteria criteria);
}