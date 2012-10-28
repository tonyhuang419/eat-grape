package com.eatle.persistent.pojo.foundation.business;

import java.util.Date;

public class Feedback
{
	private Long id;

	private String email;

	private Short identifyType;

	private Integer identifyId;

	private Date subTime;

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

	public Integer getIdentifyId()
	{
		return identifyId;
	}

	public void setIdentifyId(Integer identifyId)
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

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}