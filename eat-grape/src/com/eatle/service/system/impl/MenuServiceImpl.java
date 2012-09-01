package com.eatle.service.system.impl;

import com.eatle.persistent.mapper.MenuMapper;
import com.eatle.persistent.pojo.system.Menu;
import com.eatle.persistent.pojo.system.MenuCriteria.Criteria;
import com.eatle.persistent.pojo.system.MenuCriteria;
import com.eatle.service.system.IMenuService;
import com.eatle.utils.Pagination;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("menuService")
public class MenuServiceImpl implements IMenuService
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
		Criteria criteria = menuCriteria.createCriteria();
		// if(queryMap!=null){
		// if(queryMap.containsKey("username")){
		// criteria.andUserNameLike("%"+(String)queryMap.get("username")+"%");
		// }
		// if(queryMap.containsKey("email")){
		// criteria.andEmailLike((String)queryMap.get("email"));
		// }
		// }
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
		for(Menu menu : findRootMenu())
		{
			assembleRootMenu(menu, allMenuBuffer);
			assembleChildMenu(menu, allMenuBuffer);
		}
		return allMenuBuffer.toString();
	}

	@Override
	public void findChildMenu(List<Menu> parentMenu, StringBuffer allMenuBuffer)
	{
		boolean hasChild = false;
		for(Menu menu : parentMenu)
		{
			List<Menu> childMenu = findByParentId(menu.getId());
			if(childMenu.size() > 0)
			{
				allMenuBuffer.append("\t\t<li><a>" + menu.getMenuName() + "</a>\n");
				allMenuBuffer.append("\t\t\t<ul class=\"treeFolder treeCheck\">\n");
				hasChild = true;
				findChildMenu(childMenu, allMenuBuffer);
			}
			else
			{
				allMenuBuffer.append("\t\t\t\t<li><a href=\"" + menu.getUrl() 
						+ "\" target=\"navTab\" rel=\"" + menu.getRel()
						+ "\">" + menu.getMenuName() + "</a></li>\n");
			}
		}
		if(!hasChild)
		{
			allMenuBuffer.append("\t\t\t</ul>\n");
			allMenuBuffer.append("\t\t</li>\n");
		}
	}
	
	@Override
	public void assembleRootMenu(Menu menu, StringBuffer allMenuBuffer)
	{
		allMenuBuffer.append("<div class=\"accordionHeader\">\n");
		allMenuBuffer.append("\t<h2><span>Folder</span>" + menu.getMenuName() + "</h2>\n");
		allMenuBuffer.append("</div>\n");
		allMenuBuffer.append("<div class=\"accordionContent\">\n");
	}
	
	@Override
	public void assembleChildMenu(Menu menu, StringBuffer allMenuBuffer)
	{
		allMenuBuffer.append("\t<ul class=\"tree treeFolder treeCheck\">\n");
		findChildMenu(findByParentId(menu.getId()), allMenuBuffer);
		allMenuBuffer.append("\t</ul>\n");
		allMenuBuffer.append("</div>\n");
	}
	
//	@Override
//	public Map findAllMenu()
//	{
//		Map<Long, Menu> map = new LinkedHashMap<Long, Menu>();
//		findChildMenu(findRootMenu(), map);
//		return map;
//	}
//
//	@Override
//	public void findChildMenu(List<Menu> parentMenu, Map map)
//	{
//		for(Menu menu : parentMenu)
//		{
//			List<Menu> childMenu = findByParentId(menu.getId());
//			if(childMenu.size() > 0)
//			{
//				findChildMenu(childMenu, map);
//			}
//			map.put(menu.getId(), menu);
//		}
//	}
}