package com.eatle.web.action.backend;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.system.useradmin.User;
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
	 * @deprecated: 账号数据导出Excel下载
	 */
	public InputStream getUserExcel()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			List<String[]> headNames = new ArrayList<String[]>();
			headNames.add(new String[] { "用户名", "密码", "电子邮件", "类型", "角色" });

			ExportSetInfo setInfo = new ExportSetInfo();
			setInfo.setObjsMap(userService.getExportData());
			setInfo.setClazz(new Class[] { User.class });
			setInfo.setTitles(new String[] { "馋八戒后台用户信息" });
			setInfo.setStartFieldIndexs(new int[] { 2 });
			setInfo.setEndFieldIndexs(new int[] { 6 });
			setInfo.setHeadNames(headNames);
			setInfo.setOut(baos);
			// 将需要导出的数据输出到baos
			ExcelUtil.export2Excel(setInfo);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @deprecated: 商家数据导出Excel下载
	 */
	public InputStream getMerchantExcel()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			List<String[]> headNames = new ArrayList<String[]>();
			headNames.add(new String[] { "商家名称", "商家电话", "商家邮箱", "商家地址",
					"加盟时间", "商家Logo", "法定代表人", "法定人身份证号码", "法定人电话", 
					"法定人家庭地址", "法定人现居地址" });

			ExportSetInfo setInfo = new ExportSetInfo();
			setInfo.setObjsMap(merchantService.getExportData());
			setInfo.setClazz(new Class[] { Merchant.class });
			setInfo.setTitles(new String[] { "馋八戒加盟商家信息" });
			setInfo.setStartFieldIndexs(new int[] { 1 });
			setInfo.setEndFieldIndexs(new int[] { 11 });
			setInfo.setHeadNames(headNames);
			setInfo.setOut(baos);
			// 将需要导出的数据输出到baos
			ExcelUtil.export2Excel(setInfo);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @deprecated: 餐厅数据导出Excel下载
	 */
	public InputStream getRestaurantExcel()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			LinkedHashMap<String, List> objsMap = restaurantService.getExportData();
			Class[] classes = new Class[objsMap.size()];
			String[] titles = new String[objsMap.size()];
			int[] startFieldIndexs = new int[objsMap.size()];
			int[] endFieldIndexs = new int[objsMap.size()];
			List<String[]> headNames = new ArrayList<String[]>();
			Iterator<Entry<String, List>> iterator = objsMap.entrySet().iterator();
			for(int i = 0, len = objsMap.size(); i < len; i++)
			{
				classes[i] = Restaurant.class;
				titles[i] = iterator.next().getKey() + "加盟餐厅基本信息";
				headNames.add(new String[] { "餐厅名称", "联系人", "联系电话", "联系邮箱", 
						"联系QQ", "营业时间", "起送价格", "餐厅地址", "餐厅Logo", "送餐说明"});
				startFieldIndexs[i] = 1;
				endFieldIndexs[i] = 10;
			}
			
			ExportSetInfo setInfo = new ExportSetInfo();
			setInfo.setObjsMap(objsMap);
			setInfo.setClazz(classes);
			setInfo.setTitles(titles);
			setInfo.setStartFieldIndexs(startFieldIndexs);
			setInfo.setEndFieldIndexs(endFieldIndexs);
			setInfo.setHeadNames(headNames);
			setInfo.setOut(baos);
			// 将需要导出的数据输出到baos
			ExcelUtil.export2Excel(setInfo);
		}
		catch (IOException e)
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