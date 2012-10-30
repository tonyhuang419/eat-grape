package com.eatle.persistent.pojo.foundation.business;

import java.util.Date;

public class Feedback
{
	private Long id;

	private String email;

	private Short identifyType;

	private Long identifyId;

	private Date subTime;

	private Short handleStatus;

	private String handleRemark;

	private String content;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
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

	public Date getSubTime()
	{
		return subTime;
	}

	public void setSubTime(Date subTime)
	{
		this.subTime = subTime;
	}

	public Short getHandleStatus()
	{
		return handleStatus;
	}

	public void setHandleStatus(Short handleStatus)
	{
		this.handleStatus = handleStatus;
	}

	public String getHandleRemark()
	{
		return handleRemark;
	}

	public void setHandleRemark(String handleRemark)
	{
		this.handleRemark = handleRemark;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}