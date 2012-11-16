package com.eatle.persistent.pojo.system.frontdata;

import java.util.Date;

public class Advert
{
	private Long id;

	private Short advertType;

	private String advertName;

	private String advertLink;

	private Short advertEnabled;

	private Date startTime;

	private Date endTime;

	private Integer clickCount;

	private String linkMan;

	private String linkEmail;

	private String linkPhone;

	private Date issueTime;

	private Long advertPositionId;

	private String advertCode;

	// 临时属性（广告类型字符串）
	private String advertTypeStr;

	// 临时属性（广告状态字符串）
	private String advertEnabledStr;

	// 临时属性（开始时间字符串）
	private String startTimeStr;

	// 临时属性（结束时间字符串）
	private String endTimeStr;

	// 临时属性（发布时间字符串）
	private String issueTimeStr;

	// 临时属性（广告位）
	private AdvertPosition advertPosition;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Short getAdvertType()
	{
		return advertType;
	}

	public void setAdvertType(Short advertType)
	{
		this.advertType = advertType;
	}

	public String getAdvertName()
	{
		return advertName;
	}

	public void setAdvertName(String advertName)
	{
		this.advertName = advertName;
	}

	public String getAdvertLink()
	{
		return advertLink;
	}

	public void setAdvertLink(String advertLink)
	{
		this.advertLink = advertLink;
	}

	public Short getAdvertEnabled()
	{
		return advertEnabled;
	}

	public void setAdvertEnabled(Short advertEnabled)
	{
		this.advertEnabled = advertEnabled;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public Integer getClickCount()
	{
		return clickCount;
	}

	public void setClickCount(Integer clickCount)
	{
		this.clickCount = clickCount;
	}

	public String getLinkMan()
	{
		return linkMan;
	}

	public void setLinkMan(String linkMan)
	{
		this.linkMan = linkMan;
	}

	public String getLinkEmail()
	{
		return linkEmail;
	}

	public void setLinkEmail(String linkEmail)
	{
		this.linkEmail = linkEmail;
	}

	public String getLinkPhone()
	{
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone)
	{
		this.linkPhone = linkPhone;
	}

	public Date getIssueTime()
	{
		return issueTime;
	}

	public void setIssueTime(Date issueTime)
	{
		this.issueTime = issueTime;
	}

	public Long getAdvertPositionId()
	{
		return advertPositionId;
	}

	public void setAdvertPositionId(Long advertPositionId)
	{
		this.advertPositionId = advertPositionId;
	}

	public String getAdvertCode()
	{
		return advertCode;
	}

	public void setAdvertCode(String advertCode)
	{
		this.advertCode = advertCode;
	}

	public String getAdvertTypeStr()
	{
		return advertTypeStr;
	}

	public void setAdvertTypeStr(String advertTypeStr)
	{
		this.advertTypeStr = advertTypeStr;
	}

	public String getStartTimeStr()
	{
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr)
	{
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr()
	{
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr)
	{
		this.endTimeStr = endTimeStr;
	}

	public String getIssueTimeStr()
	{
		return issueTimeStr;
	}

	public void setIssueTimeStr(String issueTimeStr)
	{
		this.issueTimeStr = issueTimeStr;
	}

	public String getAdvertEnabledStr()
	{
		return advertEnabledStr;
	}

	public void setAdvertEnabledStr(String advertEnabledStr)
	{
		this.advertEnabledStr = advertEnabledStr;
	}

	public AdvertPosition getAdvertPosition()
	{
		return advertPosition;
	}

	public void setAdvertPosition(AdvertPosition advertPosition)
	{
		this.advertPosition = advertPosition;
	}
}