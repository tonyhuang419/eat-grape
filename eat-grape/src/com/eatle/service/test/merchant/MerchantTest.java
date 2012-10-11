package com.eatle.service.test.merchant; 

import org.junit.Test;

import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-10-10 下午12:40:06 
 */
public class MerchantTest extends BaseTest
{
	private static IMerchantService merchantService  = (IMerchantService) ctx.getBean("merchantService");
	
	@Test
	public void test()
	{
		Merchant m = new Merchant();
		m.setMerchantName("谭又中");
		System.out.println(merchantService.add(m));
	}
}
 