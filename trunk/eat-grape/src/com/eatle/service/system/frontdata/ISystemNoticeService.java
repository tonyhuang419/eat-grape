package com.eatle.service.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.SystemNotice;
import com.eatle.persistent.pojo.system.frontdata.SystemNoticeCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface ISystemNoticeService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(SystemNotice entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(SystemNotice entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(SystemNotice entity);

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
	SystemNotice findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<SystemNotice> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<SystemNotice> findByCriteria(SystemNoticeCriteria criteria);
}