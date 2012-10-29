package com.eatle.service.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.FrontMenu;
import com.eatle.persistent.pojo.system.frontdata.FrontMenuCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IFrontMenuService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(FrontMenu entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(FrontMenu entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(FrontMenu entity);

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
	FrontMenu findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<FrontMenu> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<FrontMenu> findByCriteria(FrontMenuCriteria criteria);

	/**
	 * @Description: 根据父菜单id（parent_id）查找
	 * 
	 */
	List<FrontMenu> findByParentId(Long parentId);

	/**
	 * @Description: 查找所有根菜单
	 * 
	 */
	List<FrontMenu> findRootMenu();

	/**
	 * @Description: 查找所有菜单(菜单管理树形展示)
	 * 
	 */
	String findAllFrontMenu();
}