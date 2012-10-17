package com.eatle.service.test.merchant; 

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.service.test.BaseTest;
import com.eatle.utils.ExcelUtil;
//import com.eatle.utils.OutputTo2003ExcelUtils;
import com.eatle.utils.ExcelUtil.ExportSetInfo;

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
		for(int i = 0; i < 800; i++)
		{
			Merchant m = new Merchant();
			m.setMerchantName("谭又中");
			m.setLegalAddress("111");
			m.setLegalHomeAddress("111");
			m.setLegalIdCard("111");
			m.setLegalName("111");
			m.setLegalPhone("111");
			m.setMerchantAddress("111");
			m.setMerchantEmail("111");
			m.setMerchantJoinTime(new Date(new java.util.Date().getTime()));
			m.setMerchantName("111");
			m.setMerchantPhone("111");
			System.out.println(merchantService.add(m));
		}
	}
	
	@Test
	public void export2Excel() throws IOException, IllegalArgumentException, IllegalAccessException
	{
		long startTime = System.currentTimeMillis();
		
		OutputStream bout = new FileOutputStream("c:\\a.xls");
		List<String[]> headNames = new ArrayList<String[]>();
		List<String[]> fieldNames = new ArrayList<String[]>();
		headNames.add(new String[] { "商家名称", "商家电话", "商家邮箱", "商家地址",
				"加盟时间", "商家Logo", "法定代表人", "法定人身份证号码", "法定人电话", 
				"法定人家庭地址", "法定人现居地址" });
		fieldNames.add(new String[]{"merchantName", "merchantPhone","merchantEmail",
				"merchantAddress","merchantJoinTime", "merchantLogoUrl","legalName",
				"legalIdCard","legalPhone","legalHomeAddress","legalAddress"});
		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(merchantService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒加盟商家信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(bout);
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
//		OutputTo2003ExcelUtils.output("馋八戒加盟商家信息", new String[]{"merchantName",
//				"merchantPhone","merchantEmail","merchantAddress","merchantJoinTime",
//				"merchantLogoUrl","legalName","legalIdCard","legalPhone","legalHomeAddress","legalAddress"}, 
//				new String[] { "商家名称", "商家电话", "商家邮箱", "商家地址",
//				"加盟时间", "商家Logo", "法定代表人", "法定人身份证号码", "法定人电话", 
//				"法定人家庭地址", "法定人现居地址" }, merchantService.findAll());
		
		long endTime = System.currentTimeMillis();
		
		System.out.println((endTime - startTime) / 1000.0 + "秒");
	}
}
 