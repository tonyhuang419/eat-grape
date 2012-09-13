package com.eatle.web.action; 

import java.util.List;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.system.useradmin.RolePrivilege;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilegeCriteria;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilegeCriteria.Criteria;
import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.service.system.useradmin.IRoleService;
import com.eatle.service.system.useradmin.IUserService;

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

	private User user;

	private String verifycode_c;

    /**
     * 
     * @Description: 获取登陆页面
     * @return
     */
	@Override
	public String execute() throws Exception
	{
		return INPUT;
	}

    /**
     * 
     * @Description: 登录验证
     * @return
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
					// 存入登录信息
					session.put("user", user);
					// 存入权限集合
					session.put("allPrivs", 
							rolePrivilegeService.findPrivsByRoleId(user.getRoleId()));
					
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
     * 
     * @Description: 退出系统
     * @return
     */
	public String loginOut()
	{
		session.remove("user");
		session.remove("allPrivs");
		
		return INPUT;
	}

    
	public IUserService getUserService()
	{
		return userService;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

    public IRolePrivilegeService getRolePrivilegeService()
	{
		return rolePrivilegeService;
	}

	public void setRolePrivilegeService(IRolePrivilegeService rolePrivilegeService)
	{
		this.rolePrivilegeService = rolePrivilegeService;
	}
	
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
}
 