package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.business.JoinInformation;
import com.eatle.persistent.pojo.foundation.business.JoinInformationCriteria;
import java.util.List;
import java.util.Map;

public interface JoinInformationMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(JoinInformation record);

	int insertSelective(JoinInformation record);

	List<JoinInformation> selectByExampleWithBLOBs(JoinInformationCriteria example);

	List<JoinInformation> selectByCriteria(JoinInformationCriteria example);

	JoinInformation selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(JoinInformation record);

	int updateByPrimaryKeyWithBLOBs(JoinInformation record);

	int updateByPrimaryKey(JoinInformation record);

	// 统计总的记录数
	long selectCountByCriteria(JoinInformationCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<JoinInformation> selectByMap(Map paramMap);
}