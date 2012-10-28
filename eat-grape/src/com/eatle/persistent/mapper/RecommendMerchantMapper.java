package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.business.RecommendMerchant;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchantCriteria;
import java.util.List;
import java.util.Map;

public interface RecommendMerchantMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(RecommendMerchant record);

	int insertSelective(RecommendMerchant record);

	List<RecommendMerchant> selectByCriteria(RecommendMerchantCriteria example);

	RecommendMerchant selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(RecommendMerchant record);

	int updateByPrimaryKey(RecommendMerchant record);

	// 统计总的记录数
	long selectCountByCriteria(RecommendMerchantCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<RecommendMerchant> selectByMap(Map paramMap);
}