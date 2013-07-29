package com.eatle.service.test.merchant;

import org.junit.Test;

import com.eatle.persistent.mapper.UserMerchantMapper;
import com.eatle.service.test.BaseTest;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2012-10-10 下午12:40:06
 */
public class UserMerchantTest extends BaseTest
{
	private static UserMerchantMapper s = (UserMerchantMapper) ctx.getBean("userMerchantMapper");

	@Test
	public void test()
	{
		System.out.println(s.selectUserMerchantByUserIdAndMerchantId(6L, 1L));
	}
	
}
