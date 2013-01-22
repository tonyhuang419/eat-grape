package com.eatle.service.foundation.dictionary;

import com.eatle.persistent.pojo.foundation.dictionary.ShopType;
import com.eatle.persistent.pojo.foundation.dictionary.ShopTypeCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IShopTypeService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(ShopType entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(ShopType entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	public int update(ShopType shopType, ShopType oldShopType);

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
	ShopType findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<ShopType> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<ShopType> findByCriteria(ShopTypeCriteria criteria);
	
	/**
	 * @Description: 根据主营类型标识查询
	 * 
	 */
	ShopType findByIdentify(String identify);
}