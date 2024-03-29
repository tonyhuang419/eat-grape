package com.eatle.service.system.useradmin.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.PrivMapper;
import com.eatle.persistent.mapper.RoleMapper;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.Role;
import com.eatle.persistent.pojo.system.useradmin.RoleCriteria;
import com.eatle.persistent.pojo.system.useradmin.RoleCriteria.Criteria;
import com.eatle.service.system.useradmin.IRoleService;
import com.eatle.utils.Pagination;

/**
 *@Title:
 *@Description:
 *@Author:xt
 *@Since:2012-6-19
 *@Version:1.1.0
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService
{
	@Resource
	private RoleMapper roleMapper;

	@Resource
	private PrivMapper privMapper;

	@Override
	public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize)
	{
		RoleCriteria roleCriteria = new RoleCriteria();
		Criteria criteria = roleCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("roleName"))
			{
				criteria.andRoleNameLike("%" + (String) queryMap.get("roleName") + "%");
			}
			if (queryMap.containsKey("description"))
			{
				criteria.andDescriptionLike((String) queryMap .get("description"));
			}
		}
		// 设置分页参数
		roleCriteria.setPageSize(pageSize);
		roleCriteria.setStartIndex((currentPage - 1) * pageSize);

		List<Role> items = roleMapper.selectByCriteria(roleCriteria);
		int totalCount = (int) roleMapper.selectCountByCriteria(roleCriteria);

		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public List<Role> findByCriteria(RoleCriteria criteria)
	{
		return roleMapper.selectByCriteria(criteria);
	}

	@Override
	public List<Role> findAll()
	{
		return roleMapper.selectByCriteria(null);
	}

	@Override
	public Role findById(long id)
	{
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int add(Role role)
	{
		int result = Constants.Base.FAIL;
		
		RoleCriteria roleCriteria = new RoleCriteria();
		Criteria criteria = roleCriteria.createCriteria();
		criteria.andRoleNameEqualTo(role.getRoleName());
		List<Role> roles = roleMapper.selectByCriteria(roleCriteria);
		if (roles.size() < 1)
		{
			if(roleMapper.insert(role) > 0)
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
	public int update(Role role, Role oldRole)
	{
		int result = Constants.Base.FAIL;
		
		RoleCriteria roleCriteria = new RoleCriteria();
		Criteria criteria = roleCriteria.createCriteria();
		criteria.andRoleNameEqualTo(role.getRoleName());
		List<Role> roles = roleMapper.selectByCriteria(roleCriteria);
		if (roles.size() < 1)
		{
			if(roleMapper.updateByPrimaryKeySelective(role) > 0)
			{
				result = Constants.Base.SUCCESS;
			}
		}
		else
		{
			if(roles.get(0).getRoleName().equals(oldRole.getRoleName()))
			{
				if(roleMapper.updateByPrimaryKeySelective(role) > 0)
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
	public int delete(Role role)
	{
		return roleMapper.deleteByPrimaryKey(role.getId());
	}

	@Override
	public List<Priv> findPrivsByRoleId(Long id)
	{
		return privMapper.selectByRoleId(id);
	}
}
