package com.eatle.web.action.backend; 

import java.util.Date;

import javax.annotation.Resource;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.system.systemdata.LoginLog;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.systemdata.ILoginLogService;
import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.web.action.BaseAction;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：登陆验证
 *  @version 日期：2012-8-31 下午02:50:00 
 */
public class LoginAction extends BaseAction
{
	private static final long serialVersionUID = -3476081020367772493L;

    @Resource
    private IUserService userService;

    @Resource
    private IRolePrivilegeService rolePrivilegeService;
    
    @Resource
    private ILoginLogService loginLogService;

	private User user;

	private String verifycode_c;
	
	private String loginPageNum;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
	public String getVerifycode_c()
	{
		return verifycode_c;
	}

	public void setVerifycode_c(String verifycodeC)
	{
		verifycode_c = verifycodeC;
	}

    public String getLoginPageNum()
	{
		return loginPageNum;
	}

	public void setLoginPageNum(String loginPageNum)
	{
		this.loginPageNum = loginPageNum;
	}

	/**
     * @Description: 获取登陆页面
     */
	@Override
	public String execute() throws Exception
	{
//		loginPageNum = "" + "123".charAt(new Random().nextInt(3));
		loginPageNum = "3";
		return INPUT;
	}

    /**
     * @Description: 登录验证
     */
	public String login()
	{
		String verifycode_s = (String) session.get("verifyCode_s");
		if(verifycode_c.equals(verifycode_s))
		{
			User user = userService.find(this.user);
			if(user == null)
			{
				resultMap.put("res", "0");
			}
			else
			{
				if(user.getPwd().equals(this.user.getPwd()))
				{
					// 移除验证码
					session.remove("verifyCode_s");
					// 设置权限，存入登录信息
					user.setAllPrivs(rolePrivilegeService
							.findPrivsByRoleId(user.getRoleId()));
					session.put("user", user);
					// 登陆日志
					writeLoginLog(user);
					// 验证结果
					resultMap.put("res", "1");
				}
				else
				{
					resultMap.put("res", "2");
				}
			}
		}
		else
		{
			resultMap.put("res", "3");
		}
		
		return SUCCESS;
	}

    /**
     * @Description: 退出系统
     */
	public String loginOut()
	{
		// 移除User
		session.remove("user");
		// 移除当前管理餐厅id（防止有餐厅管理权限的人退出后，另外的人用没有权限的号在其session还未过期的机器上盗取session以获得餐厅管理权限）
		session.remove("currMgrRestaurantId");
		// 移除当前管理餐厅Name
		session.remove("currMgrRestaurantName");
		
		return INPUT;
	}

    /**
     * @Description: 写入登陆日志
     */
	private void writeLoginLog(User user)
	{
		LoginLog loginLog = new LoginLog();
		
		if(Constants.UserType.USERTYPE_ADMINISTRATOR == user.getType())
			loginLog.setIdentifyType(Constants.Identity.IDENTITY_ADMINISTRATOR);
		else
			loginLog.setIdentifyType(Constants.Identity.IDENTITY_MERCHANT);
		loginLog.setIdentifyId(user.getId());
		loginLog.setLoginIp(request.getRemoteAddr());
		loginLog.setLoginTime(new Date());
		
		loginLogService.add(loginLog);
	}
}
 