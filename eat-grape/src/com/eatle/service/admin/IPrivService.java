/**
 */
package com.eatle.service.admin;

import java.util.List;
import java.util.Map;

import com.eatle.persistent.pojo.admin.Priv;
import com.eatle.persistent.pojo.admin.PrivCriteria;
import com.eatle.persistent.pojo.admin.PrivTree;
import com.eatle.utils.Pagination;



/**
 *@Title:权限service
 *@Description:
 *@Author:xt
 *@Since:2012-6-19
 *@Version:1.1.0
 */
public interface IPrivService{

	Pagination findPagination(Map<String,Object> queryMap,int currentPage,int pageSize);

	/**
	 * @Description:
		*
		* @param priv
	 */
	void update(Priv priv);

	/**
	 * @Description:
		*
		* @param priv
	 */
	void add(Priv priv);

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
	void delete(Priv priv);

	/**
	 * @Description:
		*
		* @return
	 */
	List<PrivTree> findPrivTree();
	
	
}
