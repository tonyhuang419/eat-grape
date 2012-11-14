package com.eatle.service.test.system; 

import java.util.Date;

import org.junit.Test;

import com.eatle.persistent.pojo.system.frontdata.Advert;
import com.eatle.service.system.frontdata.IAdvertService;
import com.eatle.service.test.BaseTest;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：广告测试
 *  @version 日期：2012-8-31 上午12:34:10 
 */
public class AdvertTest extends BaseTest{

	private static IAdvertService advertService  = (IAdvertService) ctx.getBean("advertService");

	@Test
	public void add()
	{
		Advert ad = new Advert();
		ad.setAdvertName("aaa");
		ad.setAdvertType(new Short("1"));
		ad.setAdvertPositionId(1L);
		ad.setAdvertLink("aaa");
		ad.setAdvertEnabled(new Short("1"));
		ad.setAdvertCode("11111111111111111111111111111111111111111");
		ad.setClickCount(222);
		ad.setStartTime(new Date());
		ad.setEndTime(new Date());
		ad.setIssueTime(new Date());
		ad.setLinkMan("谭又中");
		ad.setLinkPhone("13640516157");
		ad.setLinkEmail("453674398@qq.com");
		
		advertService.add(ad);
	}
	
	@Test
	public void update()
	{
		Advert ad = advertService.findById(1L);
		ad.setEndTime(new Date());
		
		advertService.update(ad);
	}
}