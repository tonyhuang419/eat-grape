/**
 */
package com.eatle.service.system.useradmin;

import java.util.List;
import java.util.Map;

import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.Role;
import com.eatle.persistent.pojo.system.useradmin.RoleCriteria;
import com.eatle.utils.Pagination;

/**
 *@Title: 角色service
 *@Description:
 *@Author:xt
 *@Since:2012-6-19
 *@Version:1.1.0
 */
public interface IRoleService
{
	Pagination findPagination(Map<String, Object> queryMap, int currentPage,
			int pageSize);

	/**
	 * @Description:
	 * 
	 * @param role
	 */
	int update(Role role, Role oldRole);

	/**
	 * @Description:
	 * 
	 * @param role
	 */
	int add(Role role);

	/**
	 * @Description:
	 * 
	 * @param id
	 * @return
	 */
	Role findById(long id);

	/**
	 * @Description:
	 * 
	 * @return
	 */
	List<Role> findAll();

	/**
	 * @Description:
	 * 
	 * @param criteria
	 * @return
	 */
	List<Role> findByCriteria(RoleCriteria criteria);

	/**
	 * @Description:
	 * 
	 * @param role
	 */
	int delete(Role role);

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	List<Priv> findPrivsByRoleId(Long id);
}
