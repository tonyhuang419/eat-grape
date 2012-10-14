package com.eatle.service.system.basedata.impl;

import com.eatle.persistent.mapper.MenuMapper;
import com.eatle.persistent.pojo.system.basedata.Menu;
import com.eatle.persistent.pojo.system.basedata.MenuCriteria;
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

	private Map<String, Priv> allPrivs;

	@Override
	public int add(Menu entity)
	{
		return menuMapper.insert(entity);
	}

	@Override
	public int delete(Menu entity)
	{
		return menuMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Menu entity)
	{
		return menuMapper.updateByPrimaryKeySelective(entity);
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
	public String findAllMenu(Map<String, Priv> allPrivs,String contextName)
	{
		this.allPrivs = allPrivs;
		StringBuffer allMenuBuffer = new StringBuffer();
		for(Menu menu : findRootMenu())
		{
			if(allPrivs.containsKey(menu.getAction()))
			{
				assembleRootMenu(menu, allMenuBuffer);
				assembleChildMenu(menu, allMenuBuffer,contextName);
			}
		}
		return allMenuBuffer.toString();
	}
	
	public void assembleRootMenu(Menu menu, StringBuffer allMenuBuffer)
	{
		allMenuBuffer.append("<div class=\"accordionHeader\">\n");
		allMenuBuffer.append("<h2><span>Folder</span>" + menu.getMenuName() + "</h2>\n");
		allMenuBuffer.append("</div>\n");
		allMenuBuffer.append("<div class=\"accordionContent\">\n");
	}
	
	public void assembleChildMenu(Menu menu, StringBuffer allMenuBuffer,String contextName)
	{
		allMenuBuffer.append("<ul class=\"tree treeFolder collapse\">\n");
		findChildMenu(findByParentId(menu.getId()), allMenuBuffer,contextName);
		allMenuBuffer.append("</ul>\n");
		allMenuBuffer.append("</div>\n");
	}

	public void findChildMenu(List<Menu> parentMenu, StringBuffer allMenuBuffer,String contextName)
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
					findChildMenu(childMenu, allMenuBuffer,contextName);
				}
				else
				{
					allMenuBuffer.append("<li><a href=\"" + contextName+"/"+menu.getUrl() + "?navTabId=" + menu.getRel() 
							+ "&action=" + menu.getAction() + "\" target=\"navTab\" rel=\"" + menu.getRel()
							+ "\">" + menu.getMenuName() + "</a></li>\n");
				}
			}
		}
//		if(childMenuSize > 0)
		allMenuBuffer.append("</ul>\n</li>\n");
	}
}