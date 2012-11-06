package com.eatle.service.foundation.business;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.eatle.persistent.pojo.foundation.business.RecommendMerchant;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchantCriteria;
import com.eatle.utils.Pagination;

public interface IRecommendMerchantService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(RecommendMerchant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(RecommendMerchant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(RecommendMerchant entity);

	/**
	 * @Description:
	 * 
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	Pagination findPagination(Map<String, Object> queryMap, 
			int currentPage, int pageSize) throws ParseException;

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	RecommendMerchant findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<RecommendMerchant> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<RecommendMerchant> findByCriteria(RecommendMerchantCriteria criteria);

	/**
	 * @Description: 数据导出到Excel
	 * 
	 */
	@SuppressWarnings("unchecked")
	LinkedHashMap<String, List> getExportData();
}