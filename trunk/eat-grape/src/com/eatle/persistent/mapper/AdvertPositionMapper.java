package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.frontdata.AdvertPosition;
import com.eatle.persistent.pojo.system.frontdata.AdvertPositionCriteria;
import java.util.List;
import java.util.Map;

public interface AdvertPositionMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(AdvertPosition record);

	int insertSelective(AdvertPosition record);

	List<AdvertPosition> selectByExampleWithBLOBs(AdvertPositionCriteria example);

	List<AdvertPosition> selectByCriteria(AdvertPositionCriteria example);

	AdvertPosition selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AdvertPosition record);

	int updateByPrimaryKeyWithBLOBs(AdvertPosition record);

	int updateByPrimaryKey(AdvertPosition record);

	// 统计总的记录数
	long selectCountByCriteria(AdvertPositionCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<AdvertPosition> selectByMap(Map paramMap);
}