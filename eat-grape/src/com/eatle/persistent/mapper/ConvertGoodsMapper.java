package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoods;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoodsCriteria;
import java.util.List;
import java.util.Map;

public interface ConvertGoodsMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(ConvertGoods record);

	int insertSelective(ConvertGoods record);

	List<ConvertGoods> selectByCriteria(ConvertGoodsCriteria example);

	ConvertGoods selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ConvertGoods record);

	int updateByPrimaryKey(ConvertGoods record);

	// 统计总的记录数
	long selectCountByCriteria(ConvertGoodsCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<ConvertGoods> selectByMap(Map paramMap);
}