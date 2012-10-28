package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.systemdata.LoginLog;
import com.eatle.persistent.pojo.system.systemdata.LoginLogCriteria;
import java.util.List;
import java.util.Map;

public interface LoginLogMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(LoginLog record);

	int insertSelective(LoginLog record);

	List<LoginLog> selectByCriteria(LoginLogCriteria example);

	LoginLog selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(LoginLog record);

	int updateByPrimaryKey(LoginLog record);

	// 统计总的记录数
	long selectCountByCriteria(LoginLogCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<LoginLog> selectByMap(Map paramMap);
}