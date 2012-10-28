package com.eatle.persistent.pojo.system.frontdata;

import java.util.Date;

public class Advert
{
	private Long id;

	private String picUrl;

	private Short picWidth;

	private Short picHeight;

	private String showText;

	private String linkUrl;

	private Date issueTime;

	private String altText;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getPicUrl()
	{
		return picUrl;
	}

	public void setPicUrl(String picUrl)
	{
		this.picUrl = picUrl;
	}

	public Short getPicWidth()
	{
		return picWidth;
	}

	public void setPicWidth(Short picWidth)
	{
		this.picWidth = picWidth;
	}

	public Short getPicHeight()
	{
		return picHeight;
	}

	public void setPicHeight(Short picHeight)
	{
		this.picHeight = picHeight;
	}

	public String getShowText()
	{
		return showText;
	}

	public void setShowText(String showText)
	{
		this.showText = showText;
	}

	public String getLinkUrl()
	{
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl)
	{
		this.linkUrl = linkUrl;
	}

	public Date getIssueTime()
	{
		return issueTime;
	}

	public void setIssueTime(Date issueTime)
	{
		this.issueTime = issueTime;
	}

	public String getAltText()
	{
		return altText;
	}

	public void setAltText(String altText)
	{
		this.altText = altText;
	}
}