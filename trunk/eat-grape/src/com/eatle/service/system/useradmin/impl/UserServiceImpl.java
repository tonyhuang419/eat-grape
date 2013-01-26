package com.eatle.service.system.useradmin.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.RoleMapper;
import com.eatle.persistent.mapper.UserMapper;
import com.eatle.persistent.pojo.system.useradmin.Role;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.persistent.pojo.system.useradmin.UserCriteria;
import com.eatle.persistent.pojo.system.useradmin.UserCriteria.Criteria;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.Pagination;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService
{
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private Map<String, String> userTypeStr;
	
	@Resource
	private Map<String, String> userTypeHtml;

	@Override
	public int add(User user)
	{
		int result = Constants.Base.FAIL;
		
		UserCriteria userCriteria = new UserCriteria();
		Criteria criteria = userCriteria.createCriteria();
		criteria.andUserNameEqualTo(user.getUserName());
		List<User> users = userMapper.selectByCriteria(userCriteria);

		if (users.size() < 1)
		{
			if(userMapper.insert(user) > 0)
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
	public int delete(User entity)
	{
		return userMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(User user, User oldUser)
	{
		int result = Constants.Base.FAIL;
		
		UserCriteria userCriteria = new UserCriteria();
		Criteria criteria = userCriteria.createCriteria();
		criteria.andUserNameEqualTo(user.getUserName());
		List<User> users = userMapper.selectByCriteria(userCriteria);
		if (users.size() < 1)
		{
			if(userMapper.updateByPrimaryKeySelective(user) > 0)
			{
				result = Constants.Base.SUCCESS;
			}
		}
		else
		{
			if(users.get(0).getUserName().equals(oldUser.getUserName()))
			{
				if(userMapper.updateByPrimaryKeySelective(user) > 0)
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
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		UserCriteria userCriteria = new UserCriteria();
		Criteria criteria = userCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("userName"))
			{
				criteria.andUserNameLike("%" + queryMap.get("userName") + "%");
			}
			if (queryMap.containsKey("email"))
			{
				criteria.andEmailLike("%" + queryMap.get("email") + "%");
			}
			if (queryMap.containsKey("type"))
			{
				criteria.andTypeEqualTo(Short.parseShort((String) queryMap.get("type")));
			}
			if (queryMap.containsKey("roleId"))
			{
				criteria.andRoleIdEqualTo(Long.parseLong((String) queryMap.get("roleId")));
			}
		}
		// 设置分页参数
		userCriteria.setPageSize(pageSize);
		userCriteria.setStartIndex((currentPage - 1) * pageSize);
		
		List<User> items = userMapper.selectByCriteria(userCriteria);
		for(User user : items)
		{
			user.setTypeStr(userTypeHtml.get("" + user.getType()));
		}
		int totalCount = (int) userMapper.selectCountByCriteria(userCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public User findById(long id)
	{
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> findAll()
	{
		return userMapper.selectByCriteria(null);
	}

	@Override
	public List<User> findByCriteria(UserCriteria criteria)
	{
		return userMapper.selectByCriteria(criteria);
	}

	@Override
	public User find(User user)
	{
		return userMapper.find(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List<Role> roles = roleMapper.selectByCriteria(null);
		List<User> dataList = findAll();
		for(User user : dataList)
		{
			user.setTypeStr(userTypeStr.get("" + user.getType()));
			
			for(Role role : roles)
			{
				if(user.getRoleId() == role.getId())
				{
					user.setRoleStr(role.getRoleName());
					break;
				}
			}
		}
		map.put("后台用户信息", dataList);
		return map;
	}
}