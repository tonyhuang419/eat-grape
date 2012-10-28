package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.frontdata.FrontMenu;
import com.eatle.persistent.pojo.system.frontdata.FrontMenuCriteria;
import java.util.List;
import java.util.Map;

public interface FrontMenuMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(FrontMenu record);

	int insertSelective(FrontMenu record);

	List<FrontMenu> selectByCriteria(FrontMenuCriteria example);

	FrontMenu selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(FrontMenu record);

	int updateByPrimaryKey(FrontMenu record);

	// 统计总的记录数
	long selectCountByCriteria(FrontMenuCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<FrontMenu> selectByMap(Map paramMap);
}