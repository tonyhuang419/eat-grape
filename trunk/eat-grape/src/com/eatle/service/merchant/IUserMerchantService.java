package com.eatle.service.merchant;

import com.eatle.persistent.pojo.merchant.UserMerchant;
import com.eatle.persistent.pojo.merchant.UserMerchantCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IUserMerchantService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(UserMerchant userMerchant);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(UserMerchant entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(UserMerchant userMerchant, UserMerchant oldUserMerchant);

	/**
	 * @Description:
	 * 
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	Pagination findPagination(Map<String, Object> queryMap, int currentPage,
			int pageSize);

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	UserMerchant findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<UserMerchant> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<UserMerchant> findByCriteria(UserMerchantCriteria criteria);
}