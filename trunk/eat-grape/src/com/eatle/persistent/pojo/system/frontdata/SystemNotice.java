package com.eatle.persistent.pojo.system.frontdata;

import java.util.Date;

public class SystemNotice
{
	private Long id;

	private String title;

	private Long userId;

	private Date sendTime;

	private Short target;

	private String content;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Date getSendTime()
	{
		return sendTime;
	}

	public void setSendTime(Date sendTime)
	{
		this.sendTime = sendTime;
	}

	public Short getTarget()
	{
		return target;
	}

	public void setTarget(Short target)
	{
		this.target = target;
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