package com.eatle.service.system.impl;

import com.eatle.persistent.mapper.MenuMapper;
import com.eatle.persistent.pojo.system.Menu;
import com.eatle.persistent.pojo.system.MenuCriteria;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.service.system.IMenuService;
import com.eatle.utils.Pagination;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("menuService2")
public class MenuServiceImpl2 extends MenuServiceDefaultImpl
{
	@Resource
	private MenuMapper menuMapper;

	@Override
	public void add(Menu entity)
	{
		menuMapper.insert(entity);
	}

	@Override
	public void delete(Menu entity)
	{
		menuMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public void update(Menu entity)
	{
		menuMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		MenuCriteria menuCriteria = new MenuCriteria();
		// 设置分页参数
		menuCriteria.setPageSize(pageSize);
		menuCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Menu> items = menuMapper.selectByCriteria(menuCriteria);
		int totalCount = (int) menuMapper.selectCountByCriteria(menuCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Menu findById(long id)
	{
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> findAll()
	{
		return menuMapper.selectByCriteria(null);
	}

	@Override
	public List<Menu> findByCriteria(MenuCriteria criteria)
	{
		return menuMapper.selectByCriteria(criteria);
	}

	@Override
	public List<Menu> findByParentId(Long parentId)
	{
		return menuMapper.findByParentId(parentId);
	}
	
	@Override
	public List<Menu> findRootMenu()
	{
		return findByParentId(0L);
	}

	@Override
	public String findAllMenu()
	{
		StringBuffer allMenuBuffer = new StringBuffer();
		findChildMenu(findRootMenu(), allMenuBuffer);
		return allMenuBuffer.toString();
	}
	
	public void findChildMenu(List<Menu> parentMenu, StringBuffer allMenuBuffer)
	{
		for(Menu menu : parentMenu)
		{
			List<Menu> childMenu = findByParentId(menu.getId());
			if(childMenu.size() > 0)
			{
				allMenuBuffer.append("<li><a id=\"" + menu.getId() + "\" class=\"menu\" rel=\"" + menu.getRel() 
						+ "\" tname=\"check_menu\" tvalue=\"" + menu.getId() + "\">" + menu.getMenuName() + "</a>\n<ul>\n");
				findChildMenu(childMenu, allMenuBuffer);
			}
			else
			{
				allMenuBuffer.append("<li><a id=\"" + menu.getId() + "\" class=\"menu\" rel=\"" + menu.getRel() 
						+ "\" tname=\"check_menu\" tvalue=\"" + menu.getId() + "\">" + menu.getMenuName() + "</a></li>\n");
			}
		}
		allMenuBuffer.append("</ul>\n</li>\n");
	}
}