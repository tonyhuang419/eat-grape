package com.eatle.service.system.useradmin;

import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilege;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilegeCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IRolePrivilegeService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(RolePrivilege entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(RolePrivilege entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(RolePrivilege entity);

	/**
	 * @Description:
	 * 
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	Pagination findPagination(Map<String, Object> queryMap, int currentPage,
			int pageSize);

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	RolePrivilege findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<RolePrivilege> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<RolePrivilege> findByCriteria(RolePrivilegeCriteria criteria);
	
	/**
	 * @Description: 根据角色ID查询出所拥有的权限集合
	 * @param id 角色id
	 * @return: 该角色所拥有的所有权限集合
	 */
	Map<String, Priv> findPrivsByRoleId(Long id);
	
	/**
	 * @Description: 根据角色ID和权限ID删除
	 * @param roleId 角色ID
	 * @param privId 权限ID
	 */
	void deleteByRoleIdAndPrivId(Long roleId, Long privId);
}