package com.eatle.service.test.merchant;

import org.junit.Test;

import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.service.test.BaseTest;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2012-10-10 下午12:40:06
 */
public class RestaurantTest extends BaseTest
{
	private static IRestaurantService restaurantService = (IRestaurantService) ctx.getBean("restaurantService");

	@Test
	public void test()
	{
		Restaurant r = new Restaurant();
		r.setName("肯德基观音桥分店");
		r.setAddress("江北区观音桥北城天街");

		System.out.println(restaurantService.add(r));

		System.out.println(restaurantService.findAll().size());
	}
}
