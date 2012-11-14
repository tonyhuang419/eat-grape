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

	List<Advert> selectByExampleWithBLOBs(AdvertCriteria example);

	List<Advert> selectByCriteria(AdvertCriteria example);

	Advert selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Advert record);

	int updateByPrimaryKeyWithBLOBs(Advert record);

	int updateByPrimaryKey(Advert record);

	// 统计总的记录数
	long selectCountByCriteria(AdvertCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<Advert> selectByMap(Map paramMap);
}