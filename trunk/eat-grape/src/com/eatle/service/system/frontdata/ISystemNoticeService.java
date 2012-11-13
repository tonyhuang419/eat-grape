package com.eatle.service.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.SystemNotice;
import com.eatle.persistent.pojo.system.frontdata.SystemNoticeCriteria;
import com.eatle.utils.Pagination;

import java.text.ParseException;
import java.util.LinkedHashMap;
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
	Pagination findPagination(Map<String, Object> queryMap, 
			int currentPage, int pageSize) throws ParseException;

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

	/**
	 * @Description: 数据导出到Excel
	 * 
	 */
	@SuppressWarnings("unchecked")
	LinkedHashMap<String, List> getExportData();
}