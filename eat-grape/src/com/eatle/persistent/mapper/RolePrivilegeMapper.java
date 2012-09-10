package com.eatle.persistent.mapper;

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

    //统计总的记录数
    long selectCountByCriteria(RolePrivilegeCriteria example);
}