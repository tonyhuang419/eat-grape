package com.eatle.service.system.useradmin.impl;

import com.eatle.persistent.mapper.UserMapper;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.persistent.pojo.system.useradmin.UserCriteria;
import com.eatle.persistent.pojo.system.useradmin.UserCriteria.Criteria;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void add(User entity) {
        userMapper.insert(entity);
    }

    @Override
    public void delete(User entity) {
        userMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public void update(User entity) {
        userMapper.updateByPrimaryKey(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        UserCriteria userCriteria = new UserCriteria();
        Criteria criteria = userCriteria.createCriteria();
        // 设置搜索条件参数
        if(queryMap != null)
        {
	        if(queryMap.containsKey("userName"))
	        {
	        	criteria.andUserNameLike("%" + queryMap.get("userName") + "%");
	        }
	        if(queryMap.containsKey("email"))
	        {
	        	criteria.andEmailLike("%" + queryMap.get("email") + "%");
	        }
	        if(queryMap.containsKey("type"))
	        {
	        	criteria.andTypeEqualTo(new Byte((String) queryMap.get("type")));
	        }
	        if(queryMap.containsKey("roleId"))
	        {
	        	criteria.andRoleIdEqualTo(Long.parseLong((String) queryMap.get("roleId")));
	        }
        }
        // 设置分页参数
        userCriteria.setPageSize(pageSize);
        userCriteria.setStartIndex((currentPage - 1) * pageSize);
        
        List<User> items = userMapper.selectByCriteria(userCriteria);
        int totalCount = (int) userMapper.selectCountByCriteria(userCriteria);
        
        return new Pagination(pageSize, currentPage, totalCount, items);
	}

    @Override
    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectByCriteria(null);
    }

    @Override
    public List<User> findByCriteria(UserCriteria criteria) {
        return userMapper.selectByCriteria(criteria);
    }

	@Override
	public User find(User user)
	{
		return userMapper.find(user);
	}
}