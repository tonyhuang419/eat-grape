package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.persistent.pojo.merchant.MerchantCriteria;
import java.util.List;
import java.util.Map;

public interface MerchantMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(Merchant record);

	int insertSelective(Merchant record);

	List<Merchant> selectByCriteria(MerchantCriteria example);

	Merchant selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Merchant record);

	int updateByPrimaryKey(Merchant record);

	// 统计总的记录数
	long selectCountByCriteria(MerchantCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<Merchant> selectByMap(Map paramMap);
}