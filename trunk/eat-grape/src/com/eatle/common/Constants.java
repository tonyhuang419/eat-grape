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
		
		/**
		 * @Description: 个人用户类型标识
		 */
		public static final short USERTYPE_PERSONAL = 1;
		
		/**
		 * @Description: 公司用户类型标识
		 */
		public static final short USERTYPE_COMPANY = 2;
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

		/**
		 * @Description: 商家身份标识
		 */
		public static final short IDENTITY_MERCHANT = 1;
		
		/**
		 * @Description: 顾客身份标识
		 */
		public static final short IDENTITY_CUSTOMER = 2;
	}
	
	/**
	 * @Description: 业务操作状态
	 * @Author: 谭又中
	 * @Since: 2012-10-30
	 */
	public static class Status
	{
		/**
		 * @Description: 待操作
		 */
		public static final short STATUS_WAIT = 0;

		/**
		 * @Description: 已查看
		 */
		public static final short STATUS_VIEWED = 1;
		
		/**
		 * @Description: 已完成
		 */
		public static final short STATUS_COMPLETED = 2;
	}
}
