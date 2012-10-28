package com.eatle.persistent.pojo.system.frontdata;

public class FriendshipLink
{
	private Long id;

	private String linkName;

	private String linkUrl;

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
}