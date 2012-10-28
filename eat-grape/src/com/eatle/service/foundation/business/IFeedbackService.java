package com.eatle.service.foundation.business;

import com.eatle.persistent.pojo.foundation.business.Feedback;
import com.eatle.persistent.pojo.foundation.business.FeedbackCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IFeedbackService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(Feedback entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(Feedback entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(Feedback entity);

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
	Feedback findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<Feedback> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<Feedback> findByCriteria(FeedbackCriteria criteria);
}