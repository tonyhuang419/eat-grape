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

import com.eatle.service.foundation.business.IFeedbackService;
import com.eatle.service.foundation.business.IJoinInformationService;
import com.eatle.service.foundation.business.IRecommendMerchantService;
import com.eatle.service.foundation.scoreshop.IConvertRecordsService;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.service.order.IOrderService;
import com.eatle.service.system.frontdata.IFriendshipLinkService;
import com.eatle.service.system.frontdata.ISystemNoticeService;
import com.eatle.service.system.systemdata.ILoginLogService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.ExcelUtil;
import com.eatle.utils.ExcelUtil.ExportSetInfo;
import com.eatle.web.action.BaseAction;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：Excel导出下载
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

	@Resource
	private ILoginLogService loginLogService;
	
	@Resource
	private IJoinInformationService joinInformationService;

	@Resource
	private IRecommendMerchantService recommendMerchantService;

	@Resource
	private IFeedbackService feedbackService;

	@Resource
	private ISystemNoticeService systemNoticeService;

	@Resource
	private IFriendshipLinkService friendshipLinkService;
	
	@Resource
	private IConvertRecordsService convertRecordsService;
	
	@Resource
	private IOrderService orderService;

	// 下载文件名
	private String fileName;

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 账号数据导出Excel下载
	 */
	public InputStream getUserExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "用户名", "密码", "电子邮件", "类型", "角色" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "userName", "pwd", "email", "typeStr", "roleStr"});

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(userService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒后台用户信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 商家数据导出Excel下载
	 */
	public InputStream getMerchantExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
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
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 餐厅数据导出Excel下载
	 */
	@SuppressWarnings("unchecked")
	public InputStream getRestaurantExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		LinkedHashMap<String, List> objsMap = restaurantService.getExportData();
		List<String[]> fieldNames = new ArrayList<String[]>();
		String[] titles = new String[objsMap.size()];
		List<String[]> headNames = new ArrayList<String[]>();
		Iterator<Entry<String, List>> iterator = objsMap.entrySet().iterator();
		for(int i = 0, len = objsMap.size(); i < len; i++)
		{
			titles[i] = iterator.next().getKey() + "基本信息";
			headNames.add(new String[] { "餐厅名称", "主营类型", "联系人", "联系电话", "联系邮箱", 
					"联系QQ", "营业时间", "起送价格", "餐厅地址", "送餐说明", "餐厅Logo"});
			fieldNames.add(new String[]{"name", "shopTypeStr", "contactName", "contactPhone",
					"contactEmail", "contactQq", "businessHours", "sendUpPrice",
					"address", "sendMealsDescription", "logoUrl"});
		}
		
		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(objsMap);
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(titles);
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 登陆日志数据导出Excel下载
	 */
	public InputStream getLoginLogExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "用户名", "身份类型", "登陆IP", "登录时间" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "userName", "identifyTypeStr", "loginIp", "loginTimeStr" });

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(loginLogService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒用户登陆日志信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 加盟审核信息导出Excel下载
	 */
	public InputStream getJoinInformationExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "餐厅名称", "餐厅地址", "联系人", "联系电话", "联系邮箱", 
				"联系QQ", "送餐地点", "申请时间", "审核状态", "审核时间", "审核备注"});
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "shopName", "shopAddr", "linkMan", "linkTel", "linkEmail", 
				"linkQq", "sendPlace", "subTimeStr", "auditStatusStr", "auditTimeStr", "auditRemark"}); 

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(joinInformationService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒商家加盟审核信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 用户推荐商家信息导出Excel下载
	 */
	public InputStream getRecommendMerchantExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "餐厅名称", "餐厅电话", "餐厅地址", 
				"推荐用户", "身份类型", "推荐时间", "处理状态", "处理时间", "处理备注" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "shopName", "shopTel", "shopAddr", "identifyStr", 
				"identifyTypeStr", "subTimeStr", "handleStatusStr", "handleTimeStr", "handleRemark"}); 

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(recommendMerchantService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒用户推荐商家信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 反馈建议信息导出Excel下载
	 */
	public InputStream getFeedbackExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "反馈人", "身份类型", "联系邮箱", 
				"反馈时间", "反馈内容", "处理状态", "处理时间", "处理备注" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "identifyStr", "identifyTypeStr", "email", 
				"subTimeStr", "content", "handleStatusStr", "handleTimeStr", "handleRemark"}); 

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(feedbackService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒用户反馈建议信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 系统公告信息导出Excel下载
	 */
	public InputStream getSystemNoticeExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "公告标题", "公告内容", "公告人", "公告时间", "公告对象" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "title", "content", "userStr", "sendTimeStr", "targetStr" }); 

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(systemNoticeService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒系统公告信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 友情链接信息导出Excel下载
	 */
	public InputStream getFriendshipLinkExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "链接名称", "链接地址", "链接Logo", "排序编号", "展示首页" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "linkName", "linkUrl", "logoUrl", "sortOrder", "isDisplayStr" }); 

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(friendshipLinkService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒友情链接信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 积分兑换商品记录数据导出Excel下载
	 */
	public InputStream getConvertRecordsExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "兑换商品", "兑换顾客", "兑换数量", "消费积分", "兑换时间" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "goodsName", "customerName", "convertCount", "costScore", "convertTimeStr" }); 

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(convertRecordsService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒积分商城兑换记录信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @Description: 订单数据导出Excel下载
	 */
	public InputStream getOrdersExcel() throws 
		IllegalArgumentException, IOException, IllegalAccessException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "订单号", "下单时间", "订单状态", 
				"订单状态说明", "折扣", "总价", "送餐地址", "联系人", "联系电话", 
				"备选电话", "送餐备注", "订餐顾客", "餐厅名称", "送餐时间", "通知类型" });
		List<String[]> fieldNames = new ArrayList<String[]>();
		fieldNames.add(new String[] { "orderNum", "orderTimeStr", "orderStatus", "orderStatusDescription", 
				"orderDiscount", "orderTotalMoney", "sendAddress", "contactName", "contactPhone", "anotherPhone", 
				"sendRemark", "customerName", "restaurantName", "sendTimeStr", "notifyTypeStr" }); 

		ExportSetInfo setInfo = new ExportSetInfo();
		setInfo.setObjsMap(orderService.getExportData());
		setInfo.setFieldNames(fieldNames);
		setInfo.setTitles(new String[] { "馋八戒积分商城兑换记录信息" });
		setInfo.setHeadNames(headNames);
		setInfo.setOut(baos);
		
		// 将需要导出的数据输出到baos
		ExcelUtil.export2Excel(setInfo);
		
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