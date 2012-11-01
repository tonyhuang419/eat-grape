package com.eatle.service.foundation.business;

import com.eatle.persistent.pojo.foundation.business.JoinInformation;
import com.eatle.persistent.pojo.foundation.business.JoinInformationCriteria;
import com.eatle.utils.Pagination;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IJoinInformationService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(JoinInformation entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(JoinInformation entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(JoinInformation entity);

	/**
	 * @Description:
	 * 
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 * @throws ParseException 
	 */
	Pagination findPagination(Map<String, Object> queryMap, 
			int currentPage, int pageSize) throws ParseException;

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	JoinInformation findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<JoinInformation> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<JoinInformation> findByCriteria(JoinInformationCriteria criteria);

	/**
	 * @Description: 数据导出到Excel
	 * 
	 */
	@SuppressWarnings("unchecked")
	LinkedHashMap<String, List> getExportData();
}