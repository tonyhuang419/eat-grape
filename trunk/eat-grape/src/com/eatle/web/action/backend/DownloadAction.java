package com.eatle.web.action.backend;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.eatle.service.merchant.IMerchantService;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.ExcelUtil;
import com.eatle.utils.ExcelUtil.ExportSetInfo;
import com.eatle.web.action.BaseAction;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：登陆验证
 *  @version 日期：2012-9-12 下午12:50:00 
 */
public class DownloadAction extends BaseAction
{
	private static final long serialVersionUID = -8529832147792896689L;

	@Resource
	private IUserService userService;

	@Resource
	private IMerchantService merchantService;

	@Resource
	private IRestaurantService restaurantService;

	// 下载文件名
	private String fileName;

	/**
	 * @Description: 账号数据导出Excel下载
	 */
	public InputStream getUserExcel()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			List<String[]> headNames = new ArrayList<String[]>();
			headNames.add(new String[] { "用户名", "密码", "电子邮件", "类型", "角色" });
			List<String[]> fieldNames = new ArrayList<String[]>();
			fieldNames.add(new String[] { "userName", "pwd", "email", "type", "roleId"});

			ExportSetInfo setInfo = new ExportSetInfo();
			setInfo.setObjsMap(userService.getExportData());
			setInfo.setFieldNames(fieldNames);
			setInfo.setTitles(new String[] { "馋八戒后台用户信息" });
			setInfo.setHeadNames(headNames);
			setInfo.setOut(baos);
			// 将需要导出的数据输出到baos
			ExcelUtil.export2Excel(setInfo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @Description: 商家数据导出Excel下载
	 */
	public InputStream getMerchantExcel()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
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
			setInfo.setOut(baos);
			// 将需要导出的数据输出到baos
			ExcelUtil.export2Excel(setInfo);
			long startTime = System.currentTimeMillis();
			// 将需要导出的数据输出到baos
			ExcelUtil.export2Excel(setInfo);
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) / 1000.0 + "秒");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @Description: 餐厅数据导出Excel下载
	 */
	@SuppressWarnings("unchecked")
	public InputStream getRestaurantExcel()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			LinkedHashMap<String, List> objsMap = restaurantService.getExportData();
			List<String[]> fieldNames = new ArrayList<String[]>();
			String[] titles = new String[objsMap.size()];
			List<String[]> headNames = new ArrayList<String[]>();
			Iterator<Entry<String, List>> iterator = objsMap.entrySet().iterator();
			for(int i = 0, len = objsMap.size(); i < len; i++)
			{
				titles[i] = iterator.next().getKey() + "基本信息";
				headNames.add(new String[] { "餐厅名称", "联系人", "联系电话", "联系邮箱", 
						"联系QQ", "营业时间", "起送价格", "餐厅地址", "送餐说明", "餐厅Logo"});
				fieldNames.add(new String[]{"name", "contactName", "contactPhone",
						"contactEmail", "contactQq", "businessHours", "sendUpPrice",
						"address", "sendMealsDescription", "logoUrl"});
			}
			
			ExportSetInfo setInfo = new ExportSetInfo();
			setInfo.setObjsMap(objsMap);
			setInfo.setFieldNames(fieldNames);
			setInfo.setTitles(titles);
			setInfo.setHeadNames(headNames);
			setInfo.setOut(baos);
			long startTime = System.currentTimeMillis();
			// 将需要导出的数据输出到baos
			ExcelUtil.export2Excel(setInfo);
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) / 1000.0 + "秒");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}

	public String downXls() throws Exception
	{
		return SUCCESS;
	}

	public IUserService getUserService()
	{
		return userService;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
}