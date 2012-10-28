package com.eatle.persistent.pojo.system.systemdata;

import java.util.Date;

public class LoginLog
{
	private Long id;

	private Short identifyType;

	private Integer identifyId;

	private String loginIp;

	private Date loginTime;

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

	public Integer getIdentifyId()
	{
		return identifyId;
	}

	public void setIdentifyId(Integer identifyId)
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
}