package com.eatle.persistent.pojo.foundation.business;

import java.util.Date;

public class RecommendMerchant
{
	private Long id;

	private String shopName;

	private String shopTel;

	private String shopAddr;

	private Date subTime;

	private Short identifyType;

	private Long identifyId;

	private Short handleStatus;

	private Date handleTime;

	private String handleRemark;

	// 临时属性（推荐人身份类型）
	private String identifyTypeStr;

	// 临时属性（反馈建议人）
	private String identifyStr;

	// 临时属性（申请时间字符串）
	private String subTimeStr;

	// 临时属性（处理状态字符串）
	private String handleStatusStr;

	// 临时属性（处理时间字符串）
	private String handleTimeStr;

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

	public Short getIdentifyType()
	{
		return identifyType;
	}

	public void setIdentifyType(Short identifyType)
	{
		this.identifyType = identifyType;
	}

	public Long getIdentifyId()
	{
		return identifyId;
	}

	public void setIdentifyId(Long identifyId)
	{
		this.identifyId = identifyId;
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

	public String getIdentifyTypeStr()
	{
		return identifyTypeStr;
	}

	public void setIdentifyTypeStr(String identifyTypeStr)
	{
		this.identifyTypeStr = identifyTypeStr;
	}

	public String getSubTimeStr()
	{
		return subTimeStr;
	}

	public void setSubTimeStr(String subTimeStr)
	{
		this.subTimeStr = subTimeStr;
	}

	public String getHandleStatusStr()
	{
		return handleStatusStr;
	}

	public void setHandleStatusStr(String handleStatusStr)
	{
		this.handleStatusStr = handleStatusStr;
	}

	public String getHandleTimeStr()
	{
		return handleTimeStr;
	}

	public void setHandleTimeStr(String handleTimeStr)
	{
		this.handleTimeStr = handleTimeStr;
	}

	public String getIdentifyStr()
	{
		return identifyStr;
	}

	public void setIdentifyStr(String identifyStr)
	{
		this.identifyStr = identifyStr;
	}
}