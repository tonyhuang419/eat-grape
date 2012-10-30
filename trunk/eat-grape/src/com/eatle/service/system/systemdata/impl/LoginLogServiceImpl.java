package com.eatle.service.system.systemdata.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.LoginLogMapper;
import com.eatle.persistent.mapper.UserMapper;
import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria;
import com.eatle.persistent.pojo.system.systemdata.LoginLog;
import com.eatle.persistent.pojo.system.systemdata.LoginLogCriteria.Criteria;
import com.eatle.persistent.pojo.system.systemdata.LoginLogCriteria;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.systemdata.ILoginLogService;
import com.eatle.utils.Pagination;

import freemarker.template.SimpleDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("loginLogService")
public class LoginLogServiceImpl implements ILoginLogService
{
	@Resource
	private LoginLogMapper loginLogMapper;
	
	@Resource
	private UserMapper userMapper;

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
			int currentPage, int pageSize) throws ParseException
	{
		LoginLogCriteria loginLogCriteria = new LoginLogCriteria();
		Criteria criteria = loginLogCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("userName"))
			{
				User user = new User();
				user.setUserName((String) queryMap.get("userName"));
				user = userMapper.find(user);
				if(user != null)
				{
					criteria.andIdentifyIdEqualTo(user.getId());
				}
			}
			if (queryMap.containsKey("startTime"))
			{
				if(queryMap.containsKey("endTime"))
				{
					criteria.andLoginTimeBetween(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("startTime")), 
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("endTime")));
				}
				else
				{
					criteria.andLoginTimeBetween(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("startTime")), 
						new Date());
				}
			}
			if(queryMap.containsKey("identifyType"))
			{
				criteria.andIdentifyTypeEqualTo(Short.parseShort((String) queryMap.get("identifyType")));
			}
		}
		// 设置分页参数
		loginLogCriteria.setPageSize(pageSize);
		loginLogCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<LoginLog> items = new ArrayList<LoginLog>();
		List<LoginLog> loginLogs = loginLogMapper.selectByCriteria(loginLogCriteria);
		for(LoginLog loginLog : loginLogs)
		{
			loginLog.setUserName(userMapper.selectByPrimaryKey(loginLog.getIdentifyId()).getUserName());
			loginLog.setLoginTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(loginLog.getLoginTime()));
			items.add(loginLog);
		}
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

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List<LoginLog> loginLogs = findAll();
		List<LoginLog> dataList = new ArrayList<LoginLog>();
		for(LoginLog loginLog : loginLogs)
		{
			loginLog.setUserName(userMapper.selectByPrimaryKey(loginLog.getIdentifyId()).getUserName());
			if(loginLog.getIdentifyType() == Constants.Identity.IDENTITY_ADMINISTRATOR)
			{
				loginLog.setIdentifyTypeStr("管理员");
			}
			else if(loginLog.getIdentifyType() == Constants.Identity.IDENTITY_CUSTOMER)
			{
				loginLog.setIdentifyTypeStr("顾客");
			}
			else
			{
				loginLog.setIdentifyTypeStr("商家");
			}
			loginLog.setLoginTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(loginLog.getLoginTime()));
			
			dataList.add(loginLog);
		}
		map.put("登陆日志", dataList);
		return map;
	}
}