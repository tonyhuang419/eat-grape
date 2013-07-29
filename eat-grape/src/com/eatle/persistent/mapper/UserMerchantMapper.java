package com.eatle.persistent.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.eatle.persistent.pojo.merchant.UserMerchant;
import com.eatle.persistent.pojo.merchant.UserMerchantCriteria;

@Repository
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
	
	/**
	 * @Description: 根据用户id和商家id查询
	 */
	UserMerchant selectUserMerchantByUserIdAndMerchantId(
			@Param("userId") Long userId, 
			@Param("merchantId") Long merchantId);
}