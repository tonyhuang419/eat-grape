package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.dictionary.SendRemark;
import com.eatle.persistent.pojo.foundation.dictionary.SendRemarkCriteria;
import java.util.List;
import java.util.Map;

public interface SendRemarkMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(SendRemark record);

	int insertSelective(SendRemark record);

	List<SendRemark> selectByCriteria(SendRemarkCriteria example);

	SendRemark selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SendRemark record);

	int updateByPrimaryKey(SendRemark record);

	// 统计总的记录数
	long selectCountByCriteria(SendRemarkCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<SendRemark> selectByMap(Map paramMap);
}