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
		public static final String USERTYPE_ADMINISTRATOR_STR = "管理员";
		public static final String USERTYPE_ADMINISTRATOR_HTML = "<font color='" + COLOR_LEVEL_1 + "'>管理员</font>";
		
		/**
		 * @Description: 个人用户类型标识
		 */
		public static final short USERTYPE_PERSONAL = 1;
		public static final String USERTYPE_PERSONAL_STR = "个人";
		public static final String USERTYPE_PERSONAL_HTML = "<font color='" + COLOR_LEVEL_3 + "'>个人</font>";
		
		/**
		 * @Description: 公司用户类型标识
		 */
		public static final short USERTYPE_COMPANY = 2;
		public static final String USERTYPE_COMPANY_STR = "公司";
		public static final String USERTYPE_COMPANY_HTML = "<font color='" + COLOR_LEVEL_2 + "'>公司</font>";
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
		public static final String IDENTITY_ADMINISTRATOR_HTML = "<font color='" + COLOR_LEVEL_1 + "'>管理员</font>";

		/**
		 * @Description: 商家身份标识
		 */
		public static final short IDENTITY_MERCHANT = 1;
		public static final String IDENTITY_MERCHANT_STR = "商家";
		public static final String IDENTITY_MERCHANT_HTML = "<font color='" + COLOR_LEVEL_2 + "'>商家</font>";
		
		/**
		 * @Description: 顾客身份标识
		 */
		public static final short IDENTITY_CUSTOMER = 2;
		public static final String IDENTITY_CUSTOMER_STR = "顾客";
		public static final String IDENTITY_CUSTOMER_HTML = "<font color='" + COLOR_LEVEL_3 + "'>顾客</font>";
	}
	
	/**
	 * @Description: 前/后台用户标识
	 * @Author: 谭又中
	 * @Since: 2012-11-13
	 */
	public static class UserIdentity
	{
		/**
		 * @Description: 后台商家标识
		 */
		public static final short USERIDENTITY_MERCHANT = 0;
		public static final String USERIDENTITY_MERCHANT_STR = "后台商家";
		public static final String USERIDENTITY_MERCHANT_HTML = "<font color='" + COLOR_LEVEL_2 + "'>后台商家</font>";
		
		/**
		 * @Description: 前台顾客标识
		 */
		public static final short USERIDENTITY_CUSTOMER = 1;
		public static final String USERIDENTITY_CUSTOMER_STR = "前台顾客";
		public static final String USERIDENTITY_CUSTOMER_HTML = "<font color='" + COLOR_LEVEL_3 + "'>前台顾客</font>";
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
		public static final String STATUS_WAIT_AUDIT_HTML = "<font color='" + COLOR_LEVEL_1 + "'>待审核</font>";
		
		/**
		 * @Description: 待处理
		 */
		public static final short STATUS_WAIT_HANDLE = 0;
		public static final String STATUS_WAIT_HANDLE_STR = "待处理";
		public static final String STATUS_WAIT_HANDLE_HTML = "<font color='" + COLOR_LEVEL_1 + "'>待处理</font>";

		/**
		 * @Description: 已查看
		 */
		public static final short STATUS_VIEWED = 1;
		public static final String STATUS_VIEWED_STR = "已查看";
		public static final String STATUS_VIEWED_HTML = "<font color='" + COLOR_LEVEL_3 + "'>已查看</font>";
		
		/**
		 * @Description: 已审核
		 */
		public static final short STATUS_AUDITED = 2;
		public static final String STATUS_AUDITED_STR = "已审核";
		public static final String STATUS_AUDITED_HTML = "<font color='" + COLOR_LEVEL_2 + "'>已审核</font>";
		
		/**
		 * @Description: 已处理
		 */
		public static final short STATUS_HANDLED = 2;
		public static final String STATUS_HANDLED_STR = "已处理";
		public static final String STATUS_HANDLED_HTML = "<font color='" + COLOR_LEVEL_2 + "'>已处理</font>";
	}

	/**
	 * @Description: 友情链接是否在首页显示
	 * @Author: 谭又中
	 * @Since: 2012-11-14
	 */
	public static class FriendLink
	{
		/**
		 * @Description: 显示
		 */
		public static final short FRIENDLINK_YES = 0;
		public static final String FRIENDLINK_YES_STR = "是";
		public static final String FRIENDLINK_YES_HTML = "<font color='" + COLOR_LEVEL_2 + "'>是</font>";
		
		/**
		 * @Description: 不显示
		 */
		public static final short FRIENDLINK_NO = 1;
		public static final String FRIENDLINK_NO_STR = "否";
		public static final String FRIENDLINK_NO_HTML = "<font color='" + COLOR_LEVEL_3 + "'>否</font>";
	}

	/**
	 * @Description: 广告类型标识
	 * @Author: 谭又中
	 * @Since: 2012-11-16
	 */
	public static class AdvertType
	{
		/**
		 * @Description: 图片广告
		 */
		public static final short ADVERT_TYPE_PIC = 0;
		public static final String ADVERT_TYPE_PIC_STR = "图片";
		public static final String ADVERT_TYPE_PIC_HTML = "<font color='" + COLOR_LEVEL_1 + "'>图片</font>";
		
		/**
		 * @Description: Flash广告
		 */
		public static final short ADVERT_TYPE_FLASH = 1;
		public static final String ADVERT_TYPE_FLASH_STR = "Flash";
		public static final String ADVERT_TYPE_FLASH_HTML = "<font color='" + COLOR_LEVEL_2 + "'>Flash</font>";
		
		/**
		 * @Description: 代码广告
		 */
		public static final short ADVERT_TYPE_CODE = 2;
		public static final String ADVERT_TYPE_CODE_STR = "代码";
		public static final String ADVERT_TYPE_CODE_HTML = "<font color='" + COLOR_LEVEL_3 + "'>代码</font>";
		
		/**
		 * @Description: 文字广告
		 */
		public static final short ADVERT_TYPE_TEXT = 3;
		public static final String ADVERT_TYPE_TEXT_STR = "文字";
		public static final String ADVERT_TYPE_TEXT_HTML = "<font color='" + COLOR_LEVEL_4 + "'>文字</font>";
	}

	/**
	 * @Description: 广告状态标识
	 * @Author: 谭又中
	 * @Since: 2012-11-16
	 */
	public static class AdvertEnabled
	{
		/**
		 * @Description: 开启
		 */
		public static final short ADVERT_ENABLED_OPEN = 0;
		public static final String ADVERT_ENABLED_OPEN_STR = "开启";
		public static final String ADVERT_ENABLED_OPEN_HTML = "<font color='" + COLOR_LEVEL_1 + "'>开启</font>";
		
		/**
		 * @Description: 关闭
		 */
		public static final short ADVERT_ENABLED_CLOSE = 1;
		public static final String ADVERT_ENABLED_CLOSE_STR = "关闭";
		public static final String ADVERT_ENABLED_CLOSE_HTML = "<font color='" + COLOR_LEVEL_2 + "'>关闭</font>";
	}

	/**
	 * @Description: 订单状态标识
	 * @Author: 谭又中
	 * @Since: 2013-01-23
	 */
	public static class OrderStatus
	{
		/**
		 * @Description: 待确认
		 */
		public static final short ORDER_STATUS_WAITCONFIRM = 0;
		public static final String ORDER_STATUS_WAITCONFIRM_STR = "待确认";
		public static final String ORDER_STATUS_WAITCONFIRM_HTML = "<font color='" + COLOR_LEVEL_1 + "'>待确认</font>";
		
		/**
		 * @Description: 已确认，正在处理
		 */
		public static final short ORDER_STATUS_CONFIRMED = 1;
		public static final String ORDER_STATUS_CONFIRMED_STR = "已确认";
		public static final String ORDER_STATUS_CONFIRMED_HTML = "<font color='" + COLOR_LEVEL_2 + "'>已确认</font>";
		
		/**
		 * @Description: 正在派送
		 */
		public static final short ORDER_STATUS_SENDING = 2;
		public static final String ORDER_STATUS_SENDING_STR = "正在派送";
		public static final String ORDER_STATUS_SENDING_HTML = "<font color='" + COLOR_LEVEL_3 + "'>正在派送</font>";
		
		/**
		 * @Description: 派送成功，交易完成
		 */
		public static final short ORDER_STATUS_SENDOK = 3;
		public static final String ORDER_STATUS_SENDOK_STR = "派送成功";
		public static final String ORDER_STATUS_SENDOK_HTML = "<font color='" + COLOR_LEVEL_4 + "'>派送成功</font>";
		
		/**
		 * @Description: 派送失败，交易失败
		 */
		public static final short ORDER_STATUS_SENDFAIL = 4;
		public static final String ORDER_STATUS_SENDFAIL_STR = "派送失败";
		public static final String ORDER_STATUS_SENDFAIL_HTML = "<font color='" + COLOR_LEVEL_5 + "'>派送失败</font>";
		
		/**
		 * @Description: 订单关闭（取消）
		 */
		public static final short ORDER_STATUS_CANCEL = 5;
		public static final String ORDER_STATUS_CANCEL_STR = "已取消";
		public static final String ORDER_STATUS_CANCEL_HTML = "<font color='" + COLOR_LEVEL_6 + "'>已取消</font>";
	}
	
	/**
	 * @Description: 送餐通知类型标识
	 * @Author: 谭又中
	 * @Since: 2013-01-23
	 */
	public static class NotifyType
	{
		/**
		 * @Description: 不通知（顾客自己通过电脑查看订单状态）
		 */
		public static final short NOTIFY_TYPE_NONE = 0;
		public static final String NOTIFY_TYPE_NONE_STR = "不通知";
		public static final String NOTIFY_TYPE_NONE_HTML = "<font color='" + COLOR_LEVEL_1 + "'>不通知</font>";
		
		/**
		 * @Description: 短信
		 */
		public static final short NOTIFY_TYPE_SMS = 1;
		public static final String NOTIFY_TYPE_SMS_STR = "短信";
		public static final String NOTIFY_TYPE_SMS_HTML = "<font color='" + COLOR_LEVEL_2 + "'>短信</font>";
		
		/**
		 * @Description: 电话
		 */
		public static final short NOTIFY_TYPE_TEL = 2;
		public static final String NOTIFY_TYPE_TEL_STR = "电话";
		public static final String NOTIFY_TYPE_TEL_HTML = "<font color='" + COLOR_LEVEL_3 + "'>电话</font>";
	}
}
