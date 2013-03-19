package com.eatle.service.customer.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.CommunityMapper;
import com.eatle.persistent.mapper.CustomerMapper;
import com.eatle.persistent.mapper.SchoolMapper;
import com.eatle.persistent.pojo.customer.Customer;
import com.eatle.persistent.pojo.customer.CustomerCriteria;
import com.eatle.persistent.pojo.customer.CustomerCriteria.Criteria;
import com.eatle.service.customer.ICustomerService;
import com.eatle.utils.Pagination;
import com.eatle.utils.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService
{
	@Resource
	private CustomerMapper customerMapper;
	
	@Resource
	private CommunityMapper communityMapper;
	
	@Resource
	private SchoolMapper schoolMapper;

	@Resource(name = "customerTypeStr")
	private LinkedHashMap<String, String> customerTypeStr;

	@Resource(name = "customerTypeHtml")
	private LinkedHashMap<String, String> customerTypeHtml;
	
	@Resource(name = "customerEnabledStr")
	private LinkedHashMap<String, String> customerEnabledStr;
	
	@Resource(name = "customerEnabledHtml")
	private LinkedHashMap<String, String> customerEnabledHtml;

	@Override
	public int add(Customer entity)
	{
		return customerMapper.insert(entity);
	}

	@Override
	public int delete(Customer entity)
	{
		return customerMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Customer entity)
	{
		return customerMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize) throws ParseException
	{
		CustomerCriteria customerCriteria = new CustomerCriteria();
		 Criteria criteria = customerCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("loginEmail"))
			{
				criteria.andLoginEmailLike("%" + (String) queryMap.get("loginEmail") + "%");
			}
			if (queryMap.containsKey("mobilePhone"))
			{
				criteria.andMobilePhoneLike("%" + (String) queryMap.get("mobilePhone") + "%");
			}
			if (queryMap.containsKey("isEnabled"))
			{
				criteria.andIsEnabledEqualTo(Short.parseShort((String) queryMap.get("isEnabled")));
			}
			if (queryMap.containsKey("startTime"))
			{
				if(queryMap.containsKey("endTime"))
				{
					criteria.andRegisterTimeBetween(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("startTime")), 
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("endTime")));
				}
				else
				{
					criteria.andRegisterTimeBetween(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("startTime")), 
						new Date());
				}
			}
		}
		// 设置分页参数
		customerCriteria.setPageSize(pageSize);
		customerCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Customer> items = customerMapper.selectByCriteria(customerCriteria);
		for(Customer c : items)
		{
			// 可用状态
			c.setIsEnabledStr(customerEnabledHtml.get(c.getIsEnabled().toString()));
			// 注册时间
			c.setRegisterTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getRegisterTime()));
		}
		int totalCount = (int) customerMapper.selectCountByCriteria(customerCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Customer findById(long id)
	{
		Customer c = customerMapper.selectByPrimaryKey(id);

		// 可用状态
		c.setIsEnabledStr(customerEnabledHtml.get(c.getIsEnabled().toString()));
		// 顾客类型
		c.setCustomerTypeStr(customerTypeHtml.get(c.getCustomerType().toString()));
		// 注册时间
		c.setRegisterTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getRegisterTime()));
		// 最后登录时间
		c.setLastLoginTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getLastLoginTime()));
		// 所属社区
		c.setCommunityName(communityMapper.selectByPrimaryKey(c.getCommunityId()).getName());
		// 所属学校
		c.setSchoolName(schoolMapper.selectByPrimaryKey(c.getSchoolId()).getName());
		
		return c;
	}

	@Override
	public List<Customer> findAll()
	{
		return customerMapper.selectByCriteria(null);
	}

	@Override
	public List<Customer> findByCriteria(CustomerCriteria criteria)
	{
		return customerMapper.selectByCriteria(criteria);
	}

	@Override
	@SuppressWarnings("unchecked")
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List<Customer> dataList = findAll();
		for(Customer c : dataList)
		{
			// 可用状态
			c.setIsEnabledStr(customerEnabledStr.get(c.getIsEnabled().toString()));
			// 顾客类型
			c.setCustomerTypeStr(customerTypeStr.get(c.getCustomerType().toString()));
			// 注册时间
			c.setRegisterTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getRegisterTime()));
			// 最后登录时间
			c.setLastLoginTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getLastLoginTime()));
			// 所属社区
			c.setCommunityName(communityMapper.selectByPrimaryKey(c.getCommunityId()).getName());
			// 所属学校
			c.setSchoolName(schoolMapper.selectByPrimaryKey(c.getSchoolId()).getName());
		}
		map.put("前台用户", dataList);
		return map;
	}

	@Override
	public boolean changeEnabled(Customer customer)
	{
		customer = customerMapper.selectByPrimaryKey(customer.getId());
		if(customer.getIsEnabled() == Constants.IsEnabled.ENABLED)
		{
			customer.setIsEnabled(Constants.IsEnabled.UNABLED);
		}
		else
		{
			customer.setIsEnabled(Constants.IsEnabled.ENABLED);
		}
		return customerMapper.updateByPrimaryKeySelective(customer) > 0 ? true : false;
	}

	@Override
	public boolean resetPassword(Customer customer)
	{
		customer.setPassword(StringUtil.constructRandomPassword());
		return customerMapper.updateByPrimaryKeySelective(customer) > 0 ? true : false;
	}
}