package com.eatle.web.action.backend.base;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.web.action.BaseAction;

/** 
 * @corpor: sxit
 * @author: tanyouzhong
 * @Description: 修改登录密码（商家功能）
 * @date: 2013-7-28 下午09:26:16
 */
public class ModifyPwdAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	IUserService userService;

	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	/**
	 * @Description: 修改页面展示
	 */
	public String showIndex()
	{
		

		return "showIndex";
	}

	/**
	 * @Description: 获取旧密码
	 */
	public void queryOldPwd() throws IOException
	{
		User user = (User) session.get("user");
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		if(user != null)
		{
			json.put("oldPwd", user.getPwd());
		}
		super.writeMap(json);
	}
	
	/**
	 * @throws IOException 
	 * @Description: 执行修改密码
	 */
	public void modify() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (user == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			// 重新构造一个User，防止用户构造注入其他属性值更新
			User newUser = new User();
			newUser.setId(user.getId());
			newUser.setPwd(user.getPwd());
			if(userService.update(newUser) == Constants.Base.FAIL)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
			}
			else
			{
				// 更新Session
				user = (User) session.get("user");
				user.setPwd(newUser.getPwd());
				session.put("user", user);
			}
		}
		super.writeMap(json);
	}
}