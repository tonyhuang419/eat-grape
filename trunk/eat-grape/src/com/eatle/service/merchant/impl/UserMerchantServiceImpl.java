package com.eatle.service.merchant.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.UserMerchantMapper;
import com.eatle.persistent.pojo.merchant.UserMerchant;
import com.eatle.persistent.pojo.merchant.UserMerchantCriteria.Criteria;
import com.eatle.persistent.pojo.merchant.UserMerchantCriteria;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.service.merchant.IUserMerchantService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("userMerchantService")
public class UserMerchantServiceImpl implements IUserMerchantService
{
	@Resource
	private UserMerchantMapper userMerchantMapper;
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IMerchantService merchantService;
	
	@Resource
	private IRestaurantService restaurantService;

	@Override
	public int add(UserMerchant userMerchant)
	{
		int result = Constants.Base.FAIL;

		UserMerchantCriteria umc = new UserMerchantCriteria();
		Criteria criteria = umc.createCriteria();
		criteria.andUserIdEqualTo(userMerchant.getUserId());
		criteria.andMerchantIdEqualTo(userMerchant.getMerchantId());
		List<UserMerchant> userMerchants = userMerchantMapper.selectByCriteria(umc);

		if (userMerchants.size() < 1)
		{
			if(userMerchantMapper.insert(userMerchant) > 0)
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
	public int delete(UserMerchant entity)
	{
		return userMerchantMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(UserMerchant userMerchant, UserMerchant oldUserMerchant)
	{
		int result = Constants.Base.FAIL;
		
		UserMerchantCriteria umc = new UserMerchantCriteria();
		Criteria criteria = umc.createCriteria();
		criteria.andUserIdEqualTo(userMerchant.getUserId());
		criteria.andMerchantIdEqualTo(userMerchant.getMerchantId());
		List<UserMerchant> userMerchants = userMerchantMapper.selectByCriteria(umc);
		if (userMerchants.size() < 1)
		{
			if(userMerchantMapper.updateByPrimaryKeySelective(userMerchant) > 0)
			{
				result = Constants.Base.SUCCESS;
			}
		}
		else
		{
			if(userMerchants.get(0).getUserId().equals(oldUserMerchant.getUserId()))
			{
				if(userMerchantMapper.updateByPrimaryKeySelective(userMerchant) > 0)
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
		UserMerchantCriteria userMerchantCriteria = new UserMerchantCriteria();
		Criteria criteria = userMerchantCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if(queryMap.containsKey("merchantId"))
			{
				criteria.andMerchantIdEqualTo(Long.parseLong((String) queryMap.get("merchantId")));
			}
			else
			{
				// 如果未传入商家ID则停止查询，否则会查询到所有的餐厅（安全漏洞）
				return new Pagination(pageSize, currentPage, 0, new ArrayList<UserMerchant>());
			}
			if (queryMap.containsKey("userName"))
			{
				User user = new User();
				user.setUserName((String) queryMap.get("userName"));
				user = userService.find(user);
				if(user != null)
				{
					criteria.andUserIdEqualTo(user.getId());
				}
			}
		}
		// 设置分页参数
		userMerchantCriteria.setPageSize(pageSize);
		userMerchantCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<UserMerchant> items = userMerchantMapper.selectByCriteria(userMerchantCriteria);
		for(UserMerchant um : items)
		{
			um.setUserName(userService.findById(um.getUserId()).getUserName());
			um.setMerchantName(merchantService.findById(um.getMerchantId()).getMerchantName());
			um.setManageRestaurantListStr(restaurantService.findByMultiIds(um.getManageRestaurantList().split(","), " | "));
		}
		int totalCount = (int) userMerchantMapper.selectCountByCriteria(userMerchantCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public UserMerchant findById(long id)
	{
		return userMerchantMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserMerchant> findAll()
	{
		return userMerchantMapper.selectByCriteria(null);
	}

	@Override
	public List<UserMerchant> findByCriteria(UserMerchantCriteria criteria)
	{
		return userMerchantMapper.selectByCriteria(criteria);
	}
}