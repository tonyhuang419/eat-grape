package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.dictionary.ShopType;
import com.eatle.persistent.pojo.foundation.dictionary.ShopTypeCriteria;
import java.util.List;
import java.util.Map;

public interface ShopTypeMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(ShopType record);

	int insertSelective(ShopType record);

	List<ShopType> selectByCriteria(ShopTypeCriteria example);

	ShopType selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ShopType record);

	int updateByPrimaryKey(ShopType record);

	// 统计总的记录数
	long selectCountByCriteria(ShopTypeCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<ShopType> selectByMap(Map paramMap);
}