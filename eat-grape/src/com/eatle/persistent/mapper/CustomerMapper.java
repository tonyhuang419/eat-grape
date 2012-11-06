package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.customer.Customer;
import com.eatle.persistent.pojo.customer.CustomerCriteria;
import java.util.List;
import java.util.Map;

public interface CustomerMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(Customer record);

	int insertSelective(Customer record);

	List<Customer> selectByCriteria(CustomerCriteria example);

	Customer selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Customer record);

	int updateByPrimaryKey(Customer record);

	// 统计总的记录数
	long selectCountByCriteria(CustomerCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<Customer> selectByMap(Map paramMap);
}