package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.useradmin.Role;
import com.eatle.persistent.pojo.system.useradmin.RoleCriteria;

import java.util.List;
import java.util.Map;

public interface RoleMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByCriteria(RoleCriteria example);

	Role selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	// 统计总的记录数
	long selectCountByCriteria(RoleCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<Role> selectByMap(Map paramMap);
}