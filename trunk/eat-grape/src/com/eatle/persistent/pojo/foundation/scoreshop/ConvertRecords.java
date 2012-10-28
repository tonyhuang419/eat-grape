package com.eatle.persistent.pojo.foundation.scoreshop;

import java.util.Date;

public class ConvertRecords
{
	private Long id;

	private Long goodsId;

	private Integer convertCount;

	private Date convertTime;

	private Integer costScore;

	private Long customerId;

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
}