package com.eatle.web.action.backend.merchant;

import com.eatle.web.action.BaseAction;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：餐厅送餐地点管理
 * @version 日期：2012-10-17 下午10:42:49
 */
public class SendPlaceAction extends BaseAction
{
	private static final long serialVersionUID = 4352897890873020136L;

	/**
	 * @Description: 显示送餐地点设置
	 */
	public String showIndex()
	{
		return "showIndex";
	}

	/**
	 * @Description: 显示送餐学校Tab页签管理
	 */
	public String showSchoolTab()
	{
		return "showSchoolTab";
	}

	/**
	 * @Description: 显示送餐社区/楼宇Tab页签管理
	 */
	public String showCommunityTab()
	{
		return "showCommunityTab";
	}
}
