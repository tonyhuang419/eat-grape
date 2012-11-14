package com.eatle.persistent.pojo.system.frontdata;

public class FriendshipLink
{
	private Long id;

	private String linkName;

	private String linkUrl;

	private String logoUrl;

	private Short sortOrder;

	private Short isDisplay;

	// 临时属性（是否首页显示字符串）
	private String isDisplayStr;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLinkName()
	{
		return linkName;
	}

	public void setLinkName(String linkName)
	{
		this.linkName = linkName;
	}

	public String getLinkUrl()
	{
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl)
	{
		this.linkUrl = linkUrl;
	}

	public String getLogoUrl()
	{
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl)
	{
		this.logoUrl = logoUrl;
	}

	public Short getSortOrder()
	{
		return sortOrder;
	}

	public void setSortOrder(Short sortOrder)
	{
		this.sortOrder = sortOrder;
	}

	public Short getIsDisplay()
	{
		return isDisplay;
	}

	public void setIsDisplay(Short isDisplay)
	{
		this.isDisplay = isDisplay;
	}

	public String getIsDisplayStr()
	{
		return isDisplayStr;
	}

	public void setIsDisplayStr(String isDisplayStr)
	{
		this.isDisplayStr = isDisplayStr;
	}
}