package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.dictionary.MenuFeature;
import com.eatle.persistent.pojo.foundation.dictionary.MenuFeatureCriteria;
import java.util.List;
import java.util.Map;

public interface MenuFeatureMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(MenuFeature record);

	int insertSelective(MenuFeature record);

	List<MenuFeature> selectByCriteria(MenuFeatureCriteria example);

	MenuFeature selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(MenuFeature record);

	int updateByPrimaryKey(MenuFeature record);

	// 统计总的记录数
	long selectCountByCriteria(MenuFeatureCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<MenuFeature> selectByMap(Map paramMap);
}