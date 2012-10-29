package com.eatle.service.system.systemdata;

import com.eatle.persistent.pojo.system.systemdata.Menu;
import com.eatle.persistent.pojo.system.systemdata.MenuCriteria;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IMenuService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(Menu entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(Menu entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(Menu entity);

	/**
	 * @Description:
	 * 
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize);

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	Menu findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<Menu> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<Menu> findByCriteria(MenuCriteria criteria);

	/**
	 * @Description: 根据父菜单id（parent_id）查找
	 * 
	 */
	List<Menu> findByParentId(Long parentId);

	/**
	 * @Description: 查找所有根菜单
	 * 
	 */
	List<Menu> findRootMenu();

	/**
	 * @Description: 查找所有菜单(展示首页，权限处理)
	 * @param allPrivs 所拥有的权限集合
	 */
	String findAllMenu(Map<String, Priv> allPrivs,String contextName);

	/**
	 * @Description: 查找所有菜单(菜单管理树形展示)
	 * 
	 */
	String findAllMenu();
}