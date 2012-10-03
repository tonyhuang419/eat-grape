package com.eatle.service.system.useradmin.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eatle.persistent.mapper.PrivMapper;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.PrivCriteria;
import com.eatle.persistent.pojo.system.useradmin.PrivTree;
import com.eatle.persistent.pojo.system.useradmin.Role;
import com.eatle.persistent.pojo.system.useradmin.RoleCriteria;
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
		int result = 0;
		PrivCriteria privCriteria = new PrivCriteria();
		Criteria criteria = privCriteria.createCriteria();
		criteria.andActionEqualTo(priv.getAction());
		List<Priv> privs = privMapper.selectByCriteria(privCriteria);
		if (privs.size() < 1)
		{
			result = privMapper.insert(priv);
		}
		return result;
	}

	@Override
	public int update(Priv priv, Priv oldPiv)
	{
		int result = 0;
		PrivCriteria privCriteria = new PrivCriteria();
		Criteria criteria = privCriteria.createCriteria();
		criteria.andActionEqualTo(priv.getAction());
		List<Priv> privs = privMapper.selectByCriteria(privCriteria);
		if (privs.size() < 1)
		{
			result = privMapper.updateByPrimaryKey(priv);
		}
		else
		{
			if(privs.get(0).getAction().equals(oldPiv.getAction()))
			{
				result = privMapper.updateByPrimaryKey(priv);
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
}
