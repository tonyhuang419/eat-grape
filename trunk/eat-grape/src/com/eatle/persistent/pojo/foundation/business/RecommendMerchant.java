package com.eatle.persistent.pojo.foundation.business;

import java.util.Date;

public class RecommendMerchant
{
	private Long id;

	private String shopName;

	private String shopTel;

	private String shopAddr;

	private Date subTime;

	private Long customerId;

	private Short handleStatus;

	private Date handleTime;

	private String handleRemark;

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

	public String getShopTel()
	{
		return shopTel;
	}

	public void setShopTel(String shopTel)
	{
		this.shopTel = shopTel;
	}

	public String getShopAddr()
	{
		return shopAddr;
	}

	public void setShopAddr(String shopAddr)
	{
		this.shopAddr = shopAddr;
	}

	public Date getSubTime()
	{
		return subTime;
	}

	public void setSubTime(Date subTime)
	{
		this.subTime = subTime;
	}

	public Long getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Long customerId)
	{
		this.customerId = customerId;
	}

	public Short getHandleStatus()
	{
		return handleStatus;
	}

	public void setHandleStatus(Short handleStatus)
	{
		this.handleStatus = handleStatus;
	}

	public Date getHandleTime()
	{
		return handleTime;
	}

	public void setHandleTime(Date handleTime)
	{
		this.handleTime = handleTime;
	}

	public String getHandleRemark()
	{
		return handleRemark;
	}

	public void setHandleRemark(String handleRemark)
	{
		this.handleRemark = handleRemark;
	}
}