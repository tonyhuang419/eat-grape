package com.eatle.service.customer;

import com.eatle.persistent.pojo.customer.Customer;
import com.eatle.persistent.pojo.customer.CustomerCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface ICustomerService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(Customer entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(Customer entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(Customer entity);

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
	Customer findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<Customer> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<Customer> findByCriteria(CustomerCriteria criteria);
}