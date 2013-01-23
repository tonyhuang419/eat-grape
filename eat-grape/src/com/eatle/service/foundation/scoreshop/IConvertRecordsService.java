package com.eatle.service.foundation.scoreshop;

import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecords;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecordsCriteria;
import com.eatle.utils.Pagination;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IConvertRecordsService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(ConvertRecords entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(ConvertRecords entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(ConvertRecords entity);

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
	ConvertRecords findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<ConvertRecords> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<ConvertRecords> findByCriteria(ConvertRecordsCriteria criteria);

	/**
	 * @Description:获取导出Excel需要的数据
	 */
	@SuppressWarnings("unchecked")
	LinkedHashMap<String, List> getExportData();
}