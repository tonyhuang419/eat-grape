package com.eatle.service.system.impl;

import com.eatle.persistent.mapper.MenuMapper;
import com.eatle.persistent.pojo.system.Menu;
import com.eatle.persistent.pojo.system.MenuCriteria;
import com.eatle.service.system.IMenuService;
import com.eatle.utils.Pagination;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("menuService2")
public class MenuServiceImpl2 implements IMenuService
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
		allMenuBuffer.append("<div class=\"accordionContent\">\n");
		allMenuBuffer.append("\t<ul class=\"tree treeFolder treeCheck collapse\">\n");
		findChildMenu(findRootMenu(), allMenuBuffer);
		allMenuBuffer.append("\t</ul>\n");
		allMenuBuffer.append("</div>\n");
		
		return allMenuBuffer.toString();
	}

	@Override
	public void findChildMenu(List<Menu> parentMenu, StringBuffer allMenuBuffer)
	{
		for(Menu menu : parentMenu)
		{
			List<Menu> childMenu = findByParentId(menu.getId());
			if(childMenu.size() > 0)
			{
				allMenuBuffer.append("\t\t<li><a id=\"" + menu.getId() 
						+ "\" class=\"menu\" rel=\"" + menu.getRel() 
						+ "\">" + menu.getMenuName() + "</a>\n");
				allMenuBuffer.append("\t\t\t<ul class=\"treeFolder treeCheck\">\n");
				findChildMenu(childMenu, allMenuBuffer);
			}
			else
			{
				allMenuBuffer.append("\t\t\t\t<li><a id=\"" + menu.getId() 
						+ "\" class=\"menu\" rel=\"" + menu.getRel() + "\" "
						+ "target=\"navTab\" href=\"" + menu.getUrl() 
						+ "?navTabId=" + menu.getRel() + "\">" 
						+ menu.getMenuName() + "</a></li>\n");
			}
		}
		allMenuBuffer.append("\t\t\t</ul>\n");
		allMenuBuffer.append("\t\t</li>\n");
	}

	@Override
	public void assembleRootMenu(Menu menu, StringBuffer allMenuBuffer)
	{

	}
	
	@Override
	public void assembleChildMenu(Menu menu, StringBuffer allMenuBuffer)
	{
		
	}
}