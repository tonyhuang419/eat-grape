package com.eatle.service.foundation.scoreshop;

import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoods;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoodsCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IConvertGoodsService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(ConvertGoods entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(ConvertGoods entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(ConvertGoods entity);

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
	ConvertGoods findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<ConvertGoods> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<ConvertGoods> findByCriteria(ConvertGoodsCriteria criteria);
}