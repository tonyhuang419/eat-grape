package com.eatle.persistent.pojo.system.frontdata;

import java.util.Date;

public class SystemNotice
{
	private Long id;

	private String title;

	private String content;

	private Long userId;

	private Date sendTime;

	private Short target;

	// 临时属性（公告人字符串）
	private String userStr;

	// 临时属性（处理时间字符串）
	private String sendTimeStr;

	// 临时属性（公告对象字符串）
	private String targetStr;

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

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
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

	public String getSendTimeStr()
	{
		return sendTimeStr;
	}

	public void setSendTimeStr(String sendTimeStr)
	{
		this.sendTimeStr = sendTimeStr;
	}

	public String getTargetStr()
	{
		return targetStr;
	}

	public void setTargetStr(String targetStr)
	{
		this.targetStr = targetStr;
	}

	public String getUserStr()
	{
		return userStr;
	}

	public void setUserStr(String userStr)
	{
		this.userStr = userStr;
	}
}