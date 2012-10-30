package com.eatle.service.system.frontdata.impl;

import com.eatle.persistent.mapper.FrontMenuMapper;
import com.eatle.persistent.pojo.system.frontdata.FrontMenu;
import com.eatle.persistent.pojo.system.frontdata.FrontMenuCriteria;
import com.eatle.service.system.frontdata.IFrontMenuService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("frontMenuService")
public class FrontMenuServiceImpl implements IFrontMenuService
{
	@Resource
	private FrontMenuMapper frontMenuMapper;

	@Override
	public int add(FrontMenu entity)
	{
		return frontMenuMapper.insert(entity);
	}

	@Override
	public int delete(FrontMenu entity)
	{
		return frontMenuMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(FrontMenu entity)
	{
		return frontMenuMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		FrontMenuCriteria menuCriteria = new FrontMenuCriteria();
		// 设置分页参数
		menuCriteria.setPageSize(pageSize);
		menuCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<FrontMenu> items = frontMenuMapper.selectByCriteria(menuCriteria);
		int totalCount = (int) frontMenuMapper.selectCountByCriteria(menuCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public FrontMenu findById(long id)
	{
		return frontMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<FrontMenu> findAll()
	{
		return frontMenuMapper.selectByCriteria(null);
	}

	@Override
	public List<FrontMenu> findByCriteria(FrontMenuCriteria criteria)
	{
		return frontMenuMapper.selectByCriteria(criteria);
	}

	@Override
	public List<FrontMenu> findByParentId(Long parentId)
	{
		return frontMenuMapper.findByParentId(parentId);
	}
	
	@Override
	public List<FrontMenu> findRootMenu()
	{
		return findByParentId(0L);
	}

	@Override
	public String findAllFrontMenu()
	{
		StringBuffer allMenuBuffer = new StringBuffer();
		findChildMenu(findRootMenu(), allMenuBuffer);
		return allMenuBuffer.toString();
	}
	
	public void findChildMenu(List<FrontMenu> parentMenu, StringBuffer allMenuBuffer)
	{
		for(FrontMenu menu : parentMenu)
		{
			List<FrontMenu> childMenu = findByParentId(menu.getId());
			if(childMenu.size() > 0)
			{
				allMenuBuffer.append("<li><a id=\"" + menu.getId() + "\" class=\"frontMenu\" " +
					"tname=\"check_frontMenu\" tvalue=\"" + menu.getId() + "\">" + menu.getName() + "</a>\n<ul>\n");
				findChildMenu(childMenu, allMenuBuffer);
			}
			else
			{
				allMenuBuffer.append("<li><a id=\"" + menu.getId() + "\" class=\"frontMenu\" " +
					"tname=\"check_frontMenu\" tvalue=\"" + menu.getId() + "\">" + menu.getName() + "</a></li>\n");
			}
		}
		allMenuBuffer.append("</ul>\n</li>\n");
	}
}