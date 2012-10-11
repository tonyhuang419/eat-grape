package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.basedata.Menu;
import com.eatle.persistent.pojo.system.basedata.MenuCriteria;

import java.util.List;
import java.util.Map;

public interface MenuMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(Menu record);

	int insertSelective(Menu record);

	List<Menu> selectByCriteria(MenuCriteria example);

	Menu selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKey(Menu record);

	// 通过map参数进行查询
	long selectCountByCriteria(MenuCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<Menu> selectByMap(Map paramMap);

	// 通过父级菜单ID(parentId)进行查询
	List<Menu> findByParentId(Long parentId);
}