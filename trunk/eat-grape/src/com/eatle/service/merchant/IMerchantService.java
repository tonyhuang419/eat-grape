package com.eatle.service.merchant;

import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.persistent.pojo.merchant.MerchantCriteria;
import com.eatle.utils.Pagination;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IMerchantService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(Merchant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(Merchant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(Merchant entity);

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
	Merchant findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<Merchant> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<Merchant> findByCriteria(MerchantCriteria criteria);


	/**
	 * @Description: 数据导出到Excel
	 * 
	 */
	LinkedHashMap<String, List> getExportData();
}