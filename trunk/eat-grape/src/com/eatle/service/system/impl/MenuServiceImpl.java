package com.eatle.service.system.impl;

import com.eatle.persistent.mapper.MenuMapper;
import com.eatle.persistent.pojo.system.Menu;
import com.eatle.persistent.pojo.system.MenuCriteria;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.utils.Pagination;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("menuService")
public class MenuServiceImpl extends MenuServiceDefaultImpl
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
		menuMapper.updateByPrimaryKey(entity);
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
	public String findAllMenu(Map<String, Priv> allPrivs)
	{
		StringBuffer allMenuBuffer = new StringBuffer();
		for(Menu menu : findRootMenu())
		{
			if(allPrivs.containsKey(menu.getAction()))
			{
				assembleRootMenu(menu, allMenuBuffer, allPrivs);
				assembleChildMenu(menu, allMenuBuffer, allPrivs);
			}
		}
		return allMenuBuffer.toString();
	}
	
	public void assembleRootMenu(Menu menu, StringBuffer allMenuBuffer, Map<String, Priv> allPrivs)
	{
		allMenuBuffer.append("<div class=\"accordionHeader\">\n");
		allMenuBuffer.append("<h2><span>Folder</span>" + menu.getMenuName() + "</h2>\n");
		allMenuBuffer.append("</div>\n");
		allMenuBuffer.append("<div class=\"accordionContent\">\n");
	}
	
	public void assembleChildMenu(Menu menu, 
			StringBuffer allMenuBuffer, Map<String, Priv> allPrivs)
	{
		allMenuBuffer.append("<ul class=\"tree treeFolder collapse\">\n");
		findChildMenu(findByParentId(menu.getId()), allMenuBuffer, allPrivs);
		allMenuBuffer.append("</ul>\n");
		allMenuBuffer.append("</div>\n");
	}

	public void findChildMenu(List<Menu> parentMenu, 
			StringBuffer allMenuBuffer, Map<String, Priv> allPrivs)
	{
		int childMenuSize = 0;
		for(Menu menu : parentMenu)
		{
			if(allPrivs.containsKey(menu.getAction()))
			{
				List<Menu> childMenu = findByParentId(menu.getId());
				childMenuSize = childMenu.size();
				if(childMenuSize > 0)
				{
					allMenuBuffer.append("<li><a>" + menu.getMenuName() + "</a>\n<ul>\n");
					findChildMenu(childMenu, allMenuBuffer, allPrivs);
				}
				else
				{
					allMenuBuffer.append("<li><a href=\"" + menu.getUrl() + "?navTabId=" + menu.getRel() 
							+ "&action=" + menu.getAction() + "\" target=\"navTab\" rel=\"" + menu.getRel()
							+ "\">" + menu.getMenuName() + "</a></li>\n");
				}
			}
		}
//		if(childMenuSize > 0)
		allMenuBuffer.append("</ul>\n</li>\n");
	}
}