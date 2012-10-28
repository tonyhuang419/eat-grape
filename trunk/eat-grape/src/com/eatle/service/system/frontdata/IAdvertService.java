package com.eatle.service.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.Advert;
import com.eatle.persistent.pojo.system.frontdata.AdvertCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IAdvertService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(Advert entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(Advert entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(Advert entity);

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
	Advert findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<Advert> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<Advert> findByCriteria(AdvertCriteria criteria);
}