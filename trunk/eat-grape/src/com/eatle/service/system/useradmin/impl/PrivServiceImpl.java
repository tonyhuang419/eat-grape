package com.eatle.service.system.useradmin.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.PrivMapper;
//import com.eatle.persistent.pojo.system.basedata.Menu;
import com.eatle.persistent.pojo.foundation.dictionary.ShopType;
import com.eatle.persistent.pojo.foundation.dictionary.ShopTypeCriteria;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.PrivCriteria;
import com.eatle.persistent.pojo.system.useradmin.PrivTree;
//import com.eatle.persistent.pojo.system.useradmin.Role;
//import com.eatle.persistent.pojo.system.useradmin.RoleCriteria;
import com.eatle.persistent.pojo.system.useradmin.PrivCriteria.Criteria;
import com.eatle.service.system.useradmin.IPrivService;
import com.eatle.utils.Pagination;

/**
 *@Title:
 *@Description:
 *@Author:xt
 *@Since:2012-6-19
 *@Version:1.1.0
 */
@Service("privService")
public class PrivServiceImpl implements IPrivService
{
	@Resource
	private PrivMapper privMapper;
	
	@SuppressWarnings("unused")
	private Map<String, Priv> allPrivs;

	@Override
	public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize)
	{
		PrivCriteria privCriteria = new PrivCriteria();
		Criteria criteria = privCriteria.createCriteria();
        // 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("privName"))
			{
				criteria.andPrivNameLike("%" + (String) queryMap.get("privName") + "%");
			}
			if (queryMap.containsKey("menuName"))
			{
				criteria.andMeueNameLike("%" + (String) queryMap.get("menuName") + "%");
			}
			if (queryMap.containsKey("actionCmd"))
			{
				criteria.andActionLike("%" + (String) queryMap.get("actionCmd") + "%");
			}
			if (queryMap.containsKey("pidisnull"))
			{
				criteria.andPIdIsNull();
			}
		}
		// 设置分页参数
		privCriteria.setPageSize(pageSize);
		privCriteria.setStartIndex((currentPage - 1) * pageSize);

		List<Priv> items = privMapper.selectByCriteria(privCriteria);
		int totalCount = (int) privMapper.selectCountByCriteria(privCriteria);

		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public List<Priv> findByCriteria(PrivCriteria criteria)
	{
		return privMapper.selectByCriteria(criteria);
	}

	@Override
	public List<Priv> findAll()
	{
		return privMapper.selectByCriteria(null);
	}

	@Override
	public Priv findById(long id)
	{
		return privMapper.selectByPrimaryKey(id);
	}

	@Override
	public int add(Priv priv)
	{
		int result = Constants.Base.FAIL;
		
		PrivCriteria privCriteria = new PrivCriteria();
		Criteria criteria = privCriteria.createCriteria();
		criteria.andActionEqualTo(priv.getAction());
		List<Priv> privs = privMapper.selectByCriteria(privCriteria);
		if (privs.size() < 1)
		{
			if(privMapper.insert(priv) > 0)
			{
				result = Constants.Base.SUCCESS;
			}
		}
		else
		{
			result = Constants.Base.REPEAT;
		}
		return result;
	}

	@Override
	public int update(Priv priv, Priv oldPiv)
	{
		int result = Constants.Base.FAIL;
		
		PrivCriteria privCriteria = new PrivCriteria();
		Criteria criteria = privCriteria.createCriteria();
		criteria.andActionEqualTo(priv.getAction());
		List<Priv> privs = privMapper.selectByCriteria(privCriteria);
		if (privs.size() < 1)
		{
			if(privMapper.updateByPrimaryKeySelective(priv) > 0)
			{
				result = Constants.Base.SUCCESS;
			}
		}
		else
		{
			if(privs.get(0).getAction().equals(oldPiv.getAction()))
			{
				if(privMapper.updateByPrimaryKeySelective(priv) > 0)
				{
					result = Constants.Base.SUCCESS;
				}
			}
			else
			{
				result = Constants.Base.REPEAT;
			}
		}
		return result;
	}

	@Override
	public int delete(Priv priv)
	{
		return privMapper.deleteByPrimaryKey(priv.getId());
	}

	@Override
	public List<PrivTree> findPrivTree()
	{
		List<Priv> list = privMapper.selectByMap(null);
		List<PrivTree> ptList = new ArrayList<PrivTree>();
		if (list == null)
			return null;
		for (int i = 0; i < list.size(); i++)
		{
			Priv pri = list.get(i);
			if (pri.getPid() == null)
			{
				ptList.add(findAllChildPrivs(pri, null, list));
			}
		}
		return ptList;
	}

	@SuppressWarnings("unused")
	private Priv findParentPriv(Priv priv, List<Priv> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			Priv pri = list.get(i);
			if (priv.getPid() == pri.getId())
			{
				return pri;
			}
		}
		return null;
	}

	private PrivTree findAllChildPrivs(Priv cur, PrivTree ptree, List<Priv> list)
	{
		PrivTree topTree = new PrivTree();
		topTree.setParent(ptree);
		topTree.setPriv(cur);

		List<PrivTree> temp = new ArrayList<PrivTree>();
		for (int i = 0; i < list.size(); i++)
		{
			Priv pri = list.get(i);
			if (cur.getId() == pri.getPid())
			{
				temp.add(findAllChildPrivs(pri, topTree, list));
			}
		}
		if (temp.size() == 0)
		{
			topTree.setChildPrivs(null);
		}
		else
		{
			topTree.setChildPrivs(temp);
		}
		return topTree;
	}

	@SuppressWarnings("unused")
	private List<Priv> findChildPrivs(Priv priv, List<Priv> list)
	{
		List<Priv> temp = new ArrayList<Priv>();
		for (int i = 0; i < list.size(); i++)
		{
			Priv pri = list.get(i);
			if (priv.getId() == pri.getPid())
			{
				temp.add(pri);
			}
		}
		return temp;
	}
	
	@Override
	public String findAllPrivMenu(String contextName, Map<String, Priv> allPrivs)
	{
		this.allPrivs = allPrivs;
		StringBuffer allMenuBuffer = new StringBuffer();
		for(Priv priv : findRootPrivMenu())
		{
//			if(allPrivs.get(priv.getAction()) != null)
//			{
				assembleRootPrivMenu(priv, allMenuBuffer);
				assembleChildPrivMenu(priv, allMenuBuffer,contextName);
//			}
		}
		return allMenuBuffer.toString();
	}
	
	@Override
	public List<Priv> findRootPrivMenu()
	{
		PrivCriteria privCriteria = new PrivCriteria();
		Criteria criteria = privCriteria.createCriteria();
		criteria.andIsShowEqualTo((byte)1);
		criteria.andPIdIsNull();
		return findByCriteria(privCriteria);
	}
	
	public void assembleRootPrivMenu(Priv priv, StringBuffer allMenuBuffer)
	{
		allMenuBuffer.append("<div class=\"accordionHeader\">\n");
		allMenuBuffer.append("<h2><span>Folder</span>" + priv.getMeueName() + "</h2>\n");
		allMenuBuffer.append("</div>\n");
		allMenuBuffer.append("<div class=\"accordionContent\">\n");
	}
	public void assembleChildPrivMenu(Priv priv, StringBuffer allMenuBuffer, String contextName)
	{
		allMenuBuffer.append("<ul class=\"tree treeFolder collapse\">\n");
		
		PrivCriteria privCriteria = new PrivCriteria();
		Criteria criteria = privCriteria.createCriteria();
		criteria.andPIdEqualTo(priv.getId());
		criteria.andIsShowEqualTo((byte)1);
		findChildPrivMenu(findByCriteria(privCriteria), allMenuBuffer,contextName);
		allMenuBuffer.append("</ul>\n");
		allMenuBuffer.append("</div>\n");
	}
	
	public void findChildPrivMenu(List<Priv> parentPrivMenu, StringBuffer allMenuBuffer, String contextName)
	{
		int childMenuSize = 0;
		for(Priv priv : parentPrivMenu)
		{
//			if(allPrivs.get(priv.getAction()) != null)
//			{
				PrivCriteria privCriteria = new PrivCriteria();
				Criteria criteria = privCriteria.createCriteria();
				criteria.andPIdEqualTo(priv.getId());
				criteria.andIsShowEqualTo((byte)1);
				List<Priv> childPrivMenu = findByCriteria(privCriteria);
				childMenuSize = childPrivMenu.size();
				if(childMenuSize > 0)
				{
					allMenuBuffer.append("<li><a>" + priv.getMeueName() + "</a>\n<ul>\n");
					findChildPrivMenu(childPrivMenu, allMenuBuffer,contextName);
				}
				else
				{
					allMenuBuffer.append("<li><a href=\"" + contextName+"/"+priv.getAction() + "?navTabId=" + priv.getId() 
							+ "&action=" + priv.getAction() + "\" target=\"navTab\" rel=\"" + priv.getId()
							+ "\">" + priv.getMeueName() + "</a></li>\n");
				}
//			}
		}
		allMenuBuffer.append("</ul>\n</li>\n");
	}
}
