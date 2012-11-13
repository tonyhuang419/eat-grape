package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.frontdata.SystemNotice;
import com.eatle.persistent.pojo.system.frontdata.SystemNoticeCriteria;
import java.util.List;
import java.util.Map;

public interface SystemNoticeMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(SystemNotice record);

	int insertSelective(SystemNotice record);

	List<SystemNotice> selectByCriteria(SystemNoticeCriteria example);

	SystemNotice selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SystemNotice record);

	int updateByPrimaryKey(SystemNotice record);

	// 统计总的记录数
	long selectCountByCriteria(SystemNoticeCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<SystemNotice> selectByMap(Map paramMap);
}