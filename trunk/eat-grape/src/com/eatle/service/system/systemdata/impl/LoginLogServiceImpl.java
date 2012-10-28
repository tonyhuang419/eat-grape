package com.eatle.service.system.systemdata.impl;

import com.eatle.persistent.mapper.LoginLogMapper;
import com.eatle.persistent.pojo.system.systemdata.LoginLog;
import com.eatle.persistent.pojo.system.systemdata.LoginLogCriteria.Criteria;
import com.eatle.persistent.pojo.system.systemdata.LoginLogCriteria;
import com.eatle.service.system.systemdata.ILoginLogService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("loginLogService")
public class LoginLogServiceImpl implements ILoginLogService
{
	@Resource
	private LoginLogMapper loginLogMapper;

	@Override
	public int add(LoginLog entity)
	{
		return loginLogMapper.insert(entity);
	}

	@Override
	public int delete(LoginLog entity)
	{
		return loginLogMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(LoginLog entity)
	{
		return loginLogMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		LoginLogCriteria loginLogCriteria = new LoginLogCriteria();
		Criteria criteria = loginLogCriteria.createCriteria();
		// 设置搜索条件参数
		// if(queryMap != null){
		// if(queryMap.containsKey("username")){
		// criteria.andUserNameLike("%"+(String)queryMap.get("username")+"%");
		// }
		// if(queryMap.containsKey("email")){
		// criteria.andEmailLike((String)queryMap.get("email"));
		// }
		// }
		// 设置分页参数
		loginLogCriteria.setPageSize(pageSize);
		loginLogCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<LoginLog> items = loginLogMapper.selectByCriteria(loginLogCriteria);
		int totalCount = (int) loginLogMapper.selectCountByCriteria(loginLogCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public LoginLog findById(long id)
	{
		return loginLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LoginLog> findAll()
	{
		return loginLogMapper.selectByCriteria(null);
	}

	@Override
	public List<LoginLog> findByCriteria(LoginLogCriteria criteria)
	{
		return loginLogMapper.selectByCriteria(criteria);
	}
}