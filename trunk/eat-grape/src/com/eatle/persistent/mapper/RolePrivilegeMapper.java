package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilege;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilegeCriteria;
import java.util.List;

public interface RolePrivilegeMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(RolePrivilege record);

	int insertSelective(RolePrivilege record);

	List<RolePrivilege> selectByCriteria(RolePrivilegeCriteria example);

	RolePrivilege selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(RolePrivilege record);

	int updateByPrimaryKey(RolePrivilege record);

	// 统计总的记录数
	long selectCountByCriteria(RolePrivilegeCriteria example);

	// 根据角色ID查询出所拥有的权限集合
	List<Priv> selectPrivsByRoleId(Long id);

	// 根据条件删除
	void deleteByCriteria(RolePrivilegeCriteria criteria);
}