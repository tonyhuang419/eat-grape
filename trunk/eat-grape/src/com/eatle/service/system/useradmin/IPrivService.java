/**
 */
package com.eatle.service.system.useradmin;

import java.util.List;
import java.util.Map;

import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.PrivCriteria;
import com.eatle.persistent.pojo.system.useradmin.PrivTree;
import com.eatle.utils.Pagination;

/**
 *@Title:权限service
 *@Description:
 *@Author:xt
 *@Since:2012-6-19
 *@Version:1.1.0
 */
public interface IPrivService
{
	Pagination findPagination(Map<String, Object> queryMap, int currentPage,
			int pageSize);

	/**
	 * @Description:
	 * 
	 * @param priv
	 */
	int update(Priv priv);

	/**
	 * @Description:
	 * 
	 * @param priv
	 */
	int add(Priv priv);

	/**
	 * @Description:
	 * 
	 * @param id
	 * @return
	 */
	Priv findById(long id);

	/**
	 * @Description:
	 * 
	 * @return
	 */
	List<Priv> findAll();

	/**
	 * @Description:
	 * 
	 * @param criteria
	 * @return
	 */
	List<Priv> findByCriteria(PrivCriteria criteria);

	/**
	 * @Description:
	 * 
	 * @param priv
	 */
	int delete(Priv priv);

	/**
	 * @Description:
	 * 
	 * @return
	 */
	List<PrivTree> findPrivTree();
}
