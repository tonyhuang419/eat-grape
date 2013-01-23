package com.eatle.persistent.pojo.foundation.scoreshop;

import java.util.Date;

import com.eatle.persistent.pojo.customer.Customer;

public class ConvertRecords
{
	private Long id;

	private Long goodsId;

	private Integer convertCount;

	private Date convertTime;

	private Integer costScore;

	private Long customerId;

	// 临时属性（兑换时间字符串）
	private String convertTimeStr;

	// 临时属性（兑换物品名称字符串）
	private String goodsName;

	// 临时属性（兑换顾客登录名字符串）
	private String customerName;

	// 临时属性（兑换商品）
	private ConvertGoods convertGoods;

	// 临时属性（兑换顾客）
	private Customer customer;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(Long goodsId)
	{
		this.goodsId = goodsId;
	}

	public Integer getConvertCount()
	{
		return convertCount;
	}

	public void setConvertCount(Integer convertCount)
	{
		this.convertCount = convertCount;
	}

	public Date getConvertTime()
	{
		return convertTime;
	}

	public void setConvertTime(Date convertTime)
	{
		this.convertTime = convertTime;
	}

	public Integer getCostScore()
	{
		return costScore;
	}

	public void setCostScore(Integer costScore)
	{
		this.costScore = costScore;
	}

	public Long getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Long customerId)
	{
		this.customerId = customerId;
	}

	public String getConvertTimeStr()
	{
		return convertTimeStr;
	}

	public void setConvertTimeStr(String convertTimeStr)
	{
		this.convertTimeStr = convertTimeStr;
	}

	public ConvertGoods getConvertGoods()
	{
		return convertGoods;
	}

	public void setConvertGoods(ConvertGoods convertGoods)
	{
		this.convertGoods = convertGoods;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public String getGoodsName()
	{
		return goodsName;
	}

	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
}