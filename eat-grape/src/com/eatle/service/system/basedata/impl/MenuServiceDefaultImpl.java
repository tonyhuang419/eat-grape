package com.eatle.service.system.basedata.impl; 

import java.util.List;
import java.util.Map;

import com.eatle.persistent.pojo.system.basedata.Menu;
import com.eatle.persistent.pojo.system.basedata.MenuCriteria;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.service.system.basedata.IMenuService;
import com.eatle.utils.Pagination;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：IMenuService默认实现类
 *  @version 日期：2012-9-13 下午10:11:18 
 */
public class MenuServiceDefaultImpl implements IMenuService
{

	@Override
	public int add(Menu entity)
	{
		return 0;
	}

	@Override
	public int delete(Menu entity)
	{
		return 0;
	}

	@Override
	public List<Menu> findAll()
	{
		return null;
	}

	@Override
	public String findAllMenu(Map<String, Priv> allPrivs,String contextName)
	{
		return null;
	}

	@Override
	public String findAllMenu()
	{
		return null;
	}

	@Override
	public List<Menu> findByCriteria(MenuCriteria criteria)
	{
		return null;
	}

	@Override
	public Menu findById(long id)
	{
		return null;
	}

	@Override
	public List<Menu> findByParentId(Long parentId)
	{
		return null;
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		return null;
	}

	@Override
	public List<Menu> findRootMenu()
	{
		return null;
	}

	@Override
	public int update(Menu entity)
	{
		return 0;
	}
}
 