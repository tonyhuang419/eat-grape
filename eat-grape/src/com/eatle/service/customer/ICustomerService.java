package com.eatle.service.customer;

import com.eatle.persistent.pojo.customer.Customer;
import com.eatle.persistent.pojo.customer.CustomerCriteria;
import com.eatle.utils.Pagination;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface ICustomerService
{
	/**
	 * @Description:
	 * @param entity
	 */
	int add(Customer entity);

	/**
	 * @Description:
	 * @param entity
	 */
	int delete(Customer entity);

	/**
	 * @Description:
	 * @param entity
	 */
	int update(Customer entity);

	/**
	 * @Description:
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) throws ParseException;

	/**
	 * @Description:
	 * @param id
	 */
	Customer findById(long id);

	/**
	 * @Description:
	 */
	List<Customer> findAll();

	/**
	 * @Description:
	 */
	List<Customer> findByCriteria(CustomerCriteria criteria);

	/**
	 * @Description: 获取导出到Excel的数据
	 */
	@SuppressWarnings("unchecked")
	LinkedHashMap<String, List> getExportData();
	
	/**
	 * @Description: 改变顾客账号可用状态
	 */
	boolean changeEnabled(Customer customer);
	
	/**
	 * @Description: 重置顾客账号密码（默认重置为登录邮箱）
	 */
	boolean resetPassword(Customer customer);
}