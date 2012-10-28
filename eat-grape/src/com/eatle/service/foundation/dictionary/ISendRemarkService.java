package com.eatle.service.foundation.dictionary;

import com.eatle.persistent.pojo.foundation.dictionary.SendRemark;
import com.eatle.persistent.pojo.foundation.dictionary.SendRemarkCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface ISendRemarkService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(SendRemark entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(SendRemark entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(SendRemark entity);

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
	SendRemark findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<SendRemark> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<SendRemark> findByCriteria(SendRemarkCriteria criteria);
}