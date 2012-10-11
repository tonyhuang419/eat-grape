package com.eatle.service.test.system;

import java.util.List;

import org.junit.Test;

import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria.Criteria;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.service.test.BaseTest;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2012-8-31 上午12:34:10
 */
public class UserTest extends BaseTest
{

	private static IUserService userService = (IUserService) ctx.getBean("userService");

	private static IDistrictService districtService = (IDistrictService) ctx.getBean("districtService");

	@Test
	public void test()
	{
		User user = new User();
		user.setUserName("谭又中");
		user.setPwd("123");

		userService.add(user);
	}

	@Test
	public void b()
	{

		DistrictCriteria dc = new DistrictCriteria();
		Criteria criteria = dc.createCriteria();
		Long parentId = null;
		if (parentId == null)
			criteria.andParentIdIsNull();
		else
			criteria.andParentIdEqualTo(parentId);
		List<District> distincts = districtService.findByCriteria(dc);
		System.out.println(distincts.size());
	}
}