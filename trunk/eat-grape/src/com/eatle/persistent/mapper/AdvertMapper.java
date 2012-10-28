package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.frontdata.Advert;
import com.eatle.persistent.pojo.system.frontdata.AdvertCriteria;
import java.util.List;
import java.util.Map;

public interface AdvertMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(Advert record);

	int insertSelective(Advert record);

	List<Advert> selectByCriteria(AdvertCriteria example);

	Advert selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Advert record);

	int updateByPrimaryKey(Advert record);

	// 统计总的记录数
	long selectCountByCriteria(AdvertCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<Advert> selectByMap(Map paramMap);
}