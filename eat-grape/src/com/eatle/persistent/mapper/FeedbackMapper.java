package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.business.Feedback;
import com.eatle.persistent.pojo.foundation.business.FeedbackCriteria;
import java.util.List;
import java.util.Map;

public interface FeedbackMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(Feedback record);

	int insertSelective(Feedback record);

	List<Feedback> selectByExampleWithBLOBs(FeedbackCriteria example);

	List<Feedback> selectByCriteria(FeedbackCriteria example);

	Feedback selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Feedback record);

	int updateByPrimaryKeyWithBLOBs(Feedback record);

	int updateByPrimaryKey(Feedback record);

	// 统计总的记录数
	long selectCountByCriteria(FeedbackCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<Feedback> selectByMap(Map paramMap);
}