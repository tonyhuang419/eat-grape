package com.eatle.persistent.pojo.foundation.business;

import java.util.Date;

public class JoinInformation
{
	private Long id;

	private String shopName;

	private String shopAddr;

	private String linkMan;

	private String linkTel;

	private String linkEmail;

	private String linkQq;

	private Date subTime;

	private Short auditStatus;

	private String auditRemark;

	private String sendPlace;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getShopName()
	{
		return shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
	}

	public String getShopAddr()
	{
		return shopAddr;
	}

	public void setShopAddr(String shopAddr)
	{
		this.shopAddr = shopAddr;
	}

	public String getLinkMan()
	{
		return linkMan;
	}

	public void setLinkMan(String linkMan)
	{
		this.linkMan = linkMan;
	}

	public String getLinkTel()
	{
		return linkTel;
	}

	public void setLinkTel(String linkTel)
	{
		this.linkTel = linkTel;
	}

	public String getLinkEmail()
	{
		return linkEmail;
	}

	public void setLinkEmail(String linkEmail)
	{
		this.linkEmail = linkEmail;
	}

	public String getLinkQq()
	{
		return linkQq;
	}

	public void setLinkQq(String linkQq)
	{
		this.linkQq = linkQq;
	}

	public Date getSubTime()
	{
		return subTime;
	}

	public void setSubTime(Date subTime)
	{
		this.subTime = subTime;
	}

	public Short getAuditStatus()
	{
		return auditStatus;
	}

	public void setAuditStatus(Short auditStatus)
	{
		this.auditStatus = auditStatus;
	}

	public String getAuditRemark()
	{
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark)
	{
		this.auditRemark = auditRemark;
	}

	public String getSendPlace()
	{
		return sendPlace;
	}

	public void setSendPlace(String sendPlace)
	{
		this.sendPlace = sendPlace;
	}
}