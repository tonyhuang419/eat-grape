package com.eatle.persistent.pojo.system.systemdata;

import java.util.Date;

public class LoginLog
{
	private Long id;

	private Short identifyType;

	private Long identifyId;

	private String loginIp;

	private Date loginTime;

	// 临时属性(登陆的用户名)
	private String userName;

	// 临时属性(登陆的身份类型字符串)
	private String identifyTypeStr;

	// 临时属性(登陆的时间字符串)
	private String loginTimeStr;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Short getIdentifyType()
	{
		return identifyType;
	}

	public void setIdentifyType(Short identifyType)
	{
		this.identifyType = identifyType;
	}

	public Long getIdentifyId()
	{
		return identifyId;
	}

	public void setIdentifyId(Long identifyId)
	{
		this.identifyId = identifyId;
	}

	public String getLoginIp()
	{
		return loginIp;
	}

	public void setLoginIp(String loginIp)
	{
		this.loginIp = loginIp;
	}

	public Date getLoginTime()
	{
		return loginTime;
	}

	public void setLoginTime(Date loginTime)
	{
		this.loginTime = loginTime;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getIdentifyTypeStr()
	{
		return identifyTypeStr;
	}

	public void setIdentifyTypeStr(String identifyTypeStr)
	{
		this.identifyTypeStr = identifyTypeStr;
	}

	public String getLoginTimeStr()
	{
		return loginTimeStr;
	}

	public void setLoginTimeStr(String loginTimeStr)
	{
		this.loginTimeStr = loginTimeStr;
	}
}