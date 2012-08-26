/**
 */
package com.eatle.service.admin;

import java.util.List;
import java.util.Map;

import com.eatle.persistent.pojo.admin.Priv;
import com.eatle.persistent.pojo.admin.Role;
import com.eatle.persistent.pojo.admin.RoleCriteria;
import com.eatle.utils.Pagination;



/**
 *@Title: 角色service
 *@Description:
 *@Author:xt
 *@Since:2012-6-19
 *@Version:1.1.0
 */
public interface IRoleService{

	Pagination findPagination(Map<String,Object> queryMap,int currentPage,int pageSize);

	/**
	 * @Description:
		*
		* @param role
	 */
	void update(Role role);

	/**
	 * @Description:
		*
		* @param role
	 */
	void add(Role role);

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
	void delete(Role role);

	/**
	 * @Description:
		*
		* @param id
	 */
	List<Priv> findPrivsByRoleId(Long id);
	
	
}
