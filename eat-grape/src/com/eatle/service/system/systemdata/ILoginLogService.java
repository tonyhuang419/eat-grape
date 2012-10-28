package com.eatle.service.system.systemdata;

import com.eatle.persistent.pojo.system.systemdata.LoginLog;
import com.eatle.persistent.pojo.system.systemdata.LoginLogCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface ILoginLogService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(LoginLog entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(LoginLog entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(LoginLog entity);

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
	LoginLog findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<LoginLog> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<LoginLog> findByCriteria(LoginLogCriteria criteria);
}