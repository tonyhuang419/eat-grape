package com.eatle.service.system.useradmin;

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
	void add(RolePrivilege entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	void delete(RolePrivilege entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	void update(RolePrivilege entity);

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
}