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
}