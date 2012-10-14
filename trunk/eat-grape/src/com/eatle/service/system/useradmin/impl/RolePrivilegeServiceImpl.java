package com.eatle.service.system.useradmin.impl;

import com.eatle.persistent.mapper.RolePrivilegeMapper;
import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilege;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilegeCriteria;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilegeCriteria.Criteria;
import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.utils.Pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("rolePrivilegeService")
public class RolePrivilegeServiceImpl implements IRolePrivilegeService
{
	@Resource
	private RolePrivilegeMapper rolePrivilegeMapper;

	@Override
	public int add(RolePrivilege entity)
	{
		return rolePrivilegeMapper.insert(entity);
	}

	@Override
	public int delete(RolePrivilege entity)
	{
		return rolePrivilegeMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(RolePrivilege entity)
	{
		return rolePrivilegeMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize)
	{
		RolePrivilegeCriteria rolePrivilegeCriteria = new RolePrivilegeCriteria();
		rolePrivilegeCriteria.setPageSize(pageSize);
		rolePrivilegeCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<RolePrivilege> items = rolePrivilegeMapper.selectByCriteria(rolePrivilegeCriteria);
		int totalCount = (int) rolePrivilegeMapper.selectCountByCriteria(rolePrivilegeCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public RolePrivilege findById(long id)
	{
		return rolePrivilegeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RolePrivilege> findAll()
	{
		return rolePrivilegeMapper.selectByCriteria(null);
	}

	@Override
	public List<RolePrivilege> findByCriteria(RolePrivilegeCriteria criteria)
	{
		return rolePrivilegeMapper.selectByCriteria(criteria);
	}
	
	@Override
	public Map<String, Priv> findPrivsByRoleId(Long id)
	{
		Map<String, Priv> privsMap = new HashMap<String, Priv>();
		for(Priv priv : rolePrivilegeMapper.selectPrivsByRoleId(id))
		{
			privsMap.put(priv.getAction(), priv);
		}
		
		return privsMap;
	}
	
	@Override
	public void deleteByRoleIdAndPrivId(Long roleId, Long privId)
	{
		RolePrivilegeCriteria rpCriteria = new RolePrivilegeCriteria();
		Criteria criteria = rpCriteria.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		criteria.andPrivIdEqualTo(privId);
		
		rolePrivilegeMapper.deleteByCriteria(rpCriteria);
	}
}