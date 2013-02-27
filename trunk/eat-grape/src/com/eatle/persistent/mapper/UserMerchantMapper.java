package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.merchant.UserMerchant;
import com.eatle.persistent.pojo.merchant.UserMerchantCriteria;
import java.util.List;
import java.util.Map;

public interface UserMerchantMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(UserMerchant record);

	int insertSelective(UserMerchant record);

	List<UserMerchant> selectByCriteria(UserMerchantCriteria example);

	UserMerchant selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserMerchant record);

	int updateByPrimaryKey(UserMerchant record);

	// 统计总的记录数
	long selectCountByCriteria(UserMerchantCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<UserMerchant> selectByMap(Map paramMap);
}