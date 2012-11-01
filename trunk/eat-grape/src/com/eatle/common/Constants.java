package com.eatle.common;

/**
 * @Title: 通用常量类
 * @Description:
 * @Author:xt
 * @Since:2012-6-19
 * @Version:1.1.0
 */
public class Constants
{

	/**
	 * @Title: 通用类
	 * @Description:
	 * @Author:asus
	 * @Since:2012-6-19
	 * @Version:1.1.0
	 */
	public static class Base
	{

	}

	/**
	 * @Description: 用户类型标识
	 * @Author: 谭又中
	 * @Since: 2012-10-30
	 */
	public static class UserType
	{
		/**
		 * @Description: 管理员用户类型标识
		 */
		public static final short USERTYPE_ADMINISTRATOR = 0;
		public static final String USERTYPE_ADMINISTRATOR_STR = "管理员";
		public static final String USERTYPE_ADMINISTRATOR_HTML = "<font color='#E13CD8'>管理员</font>";
		
		/**
		 * @Description: 个人用户类型标识
		 */
		public static final short USERTYPE_PERSONAL = 1;
		public static final String USERTYPE_PERSONAL_STR = "个人";
		public static final String USERTYPE_PERSONAL_HTML = "<font color='#48A8E2'>个人</font>";
		
		/**
		 * @Description: 公司用户类型标识
		 */
		public static final short USERTYPE_COMPANY = 2;
		public static final String USERTYPE_COMPANY_STR = "公司";
		public static final String USERTYPE_COMPANY_HTML = "<font color='#1979E0'>公司</font>";
	}
	
	/**
	 * @Description: 身份标识
	 * @Author: 谭又中
	 * @Since: 2012-10-30
	 */
	public static class Identity
	{
		/**
		 * @Description: 管理员身份标识
		 */
		public static final short IDENTITY_ADMINISTRATOR = 0;
		public static final String IDENTITY_ADMINISTRATOR_STR = "管理员";
		public static final String IDENTITY_ADMINISTRATOR_HTML = "<font color='#E13CD8'>管理员</font>";

		/**
		 * @Description: 商家身份标识
		 */
		public static final short IDENTITY_MERCHANT = 1;
		public static final String IDENTITY_MERCHANT_STR = "商家";
		public static final String IDENTITY_MERCHANT_HTML = "<font color='#1979E0'>商家</font>";
		
		/**
		 * @Description: 顾客身份标识
		 */
		public static final short IDENTITY_CUSTOMER = 2;
		public static final String IDENTITY_CUSTOMER_STR = "顾客";
		public static final String IDENTITY_CUSTOMER_HTML = "<font color='#48A8E2'>顾客</font>";
	}
	
	/**
	 * @Description: 业务操作状态
	 * @Author: 谭又中
	 * @Since: 2012-10-30
	 */
	public static class Status
	{
		/**
		 * @Description: 待审核
		 */
		public static final short STATUS_WAIT_AUDIT = 0;
		public static final String STATUS_WAIT_AUDIT_STR = "待审核";
		public static final String STATUS_WAIT_AUDIT_HTML = "<font color='#E13CD8'>待审核</font>";
		
		/**
		 * @Description: 待处理
		 */
		public static final short STATUS_WAIT_HANDLE = 0;
		public static final String STATUS_WAIT_HANDLE_STR = "待处理";
		public static final String STATUS_WAIT_HANDLE_HTML = "<font color='#E13CD8'>待处理</font>";

		/**
		 * @Description: 已查看
		 */
		public static final short STATUS_VIEWED = 1;
		public static final String STATUS_VIEWED_STR = "已查看";
		public static final String STATUS_VIEWED_HTML = "<font color='#48A8E2'>已查看</font>";
		
		/**
		 * @Description: 已审核
		 */
		public static final short STATUS_AUDITED = 2;
		public static final String STATUS_AUDITED_STR = "已审核";
		public static final String STATUS_AUDITED_HTML = "<font color='#1979E0'>已审核</font>";
		
		/**
		 * @Description: 已处理
		 */
		public static final short STATUS_HANDLED = 2;
		public static final String STATUS_HANDLED_STR = "已处理";
		public static final String STATUS_HANDLED_HTML = "<font color='#1979E0'>已处理</font>";
	}
}
