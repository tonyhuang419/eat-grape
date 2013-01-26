package com.eatle.common;

import com.eatle.utils.ConfigurationRead;

/**
 * @Title: 通用常量类
 * @Description:
 * @Author:xt
 * @Since:2012-6-19
 * @Version:1.1.0
 */
public class Constants
{
	public static final ConfigurationRead config = ConfigurationRead.getInstance();
	
	public static final String COLOR_LEVEL_1 = config.getConfigItem("color.level.1");
	public static final String COLOR_LEVEL_2 = config.getConfigItem("color.level.2");
	public static final String COLOR_LEVEL_3 = config.getConfigItem("color.level.3");
	public static final String COLOR_LEVEL_4 = config.getConfigItem("color.level.4");
	public static final String COLOR_LEVEL_5 = config.getConfigItem("color.level.5");
	public static final String COLOR_LEVEL_6 = config.getConfigItem("color.level.6");
	
	/**
	 * @Description: 基础常量
	 * @Author: 谭又中
	 * @Since: 2012-6-19
	 */
	public static class Base
	{
		public static final int SUCCESS = 0;		// 成功
		public static final int FAIL = 1;			// 失败
		public static final int ERROR = 2;			// 错误
		public static final int REPEAT = 3;			// 重复
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
		 * @Description: 待审核
		 */
		public static final short STATUS_WAIT_AUDIT = 0;
		
		/**
		 * @Description: 待处理
		 */
		public static final short STATUS_WAIT_HANDLE = 0;

		/**
		 * @Description: 已查看
		 */
		public static final short STATUS_VIEWED = 1;
		
		/**
		 * @Description: 已审核
		 */
		public static final short STATUS_AUDITED = 2;
		
		/**
		 * @Description: 已处理
		 */
		public static final short STATUS_HANDLED = 2;
	}
}
