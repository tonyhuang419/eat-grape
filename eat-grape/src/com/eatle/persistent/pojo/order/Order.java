package com.eatle.persistent.pojo.order;

import java.util.Date;

public class Order
{
	private Long id;

	private String orderNum;

	private Date orderTime;

	private Integer orderStatus;

	private String orderStatusDescription;

	private Float orderDiscount;

	private Float orderTotalMoney;

	private String sendAddress;

	private String contactName;

	private String contactPhone;

	private String anotherPhone;

	private String sendRemark;

	private Long customerId;

	private Long restaurantId;

	private Date sendTime;

	private Short notifyType;

	// 临时属性（下单时间字符串）
	private String orderTimeStr;

	// 临时属性（订单状态字符串）
	private String orderStatusStr;

	// 临时属性（顾客名称[登录邮箱]）
	private String customerName;

	// 临时属性（餐厅名称）
	private String restaurantName;

	// 临时属性（送餐时间字符串）
	private String sendTimeStr;

	// 临时属性（通知类型字符串）
	private String notifyTypeStr;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getOrderNum()
	{
		return orderNum;
	}

	public void setOrderNum(String orderNum)
	{
		this.orderNum = orderNum;
	}

	public Date getOrderTime()
	{
		return orderTime;
	}

	public void setOrderTime(Date orderTime)
	{
		this.orderTime = orderTime;
	}

	public Integer getOrderStatus()
	{
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus)
	{
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusDescription()
	{
		return orderStatusDescription;
	}

	public void setOrderStatusDescription(String orderStatusDescription)
	{
		this.orderStatusDescription = orderStatusDescription;
	}

	public Float getOrderDiscount()
	{
		return orderDiscount;
	}

	public void setOrderDiscount(Float orderDiscount)
	{
		this.orderDiscount = orderDiscount;
	}

	public Float getOrderTotalMoney()
	{
		return orderTotalMoney;
	}

	public void setOrderTotalMoney(Float orderTotalMoney)
	{
		this.orderTotalMoney = orderTotalMoney;
	}

	public String getSendAddress()
	{
		return sendAddress;
	}

	public void setSendAddress(String sendAddress)
	{
		this.sendAddress = sendAddress;
	}

	public String getContactName()
	{
		return contactName;
	}

	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}

	public String getContactPhone()
	{
		return contactPhone;
	}

	public void setContactPhone(String contactPhone)
	{
		this.contactPhone = contactPhone;
	}

	public String getAnotherPhone()
	{
		return anotherPhone;
	}

	public void setAnotherPhone(String anotherPhone)
	{
		this.anotherPhone = anotherPhone;
	}

	public String getSendRemark()
	{
		return sendRemark;
	}

	public void setSendRemark(String sendRemark)
	{
		this.sendRemark = sendRemark;
	}

	public Long getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Long customerId)
	{
		this.customerId = customerId;
	}

	public Long getRestaurantId()
	{
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId)
	{
		this.restaurantId = restaurantId;
	}

	public Date getSendTime()
	{
		return sendTime;
	}

	public void setSendTime(Date sendTime)
	{
		this.sendTime = sendTime;
	}

	public Short getNotifyType()
	{
		return notifyType;
	}

	public void setNotifyType(Short notifyType)
	{
		this.notifyType = notifyType;
	}

	public String getOrderTimeStr()
	{
		return orderTimeStr;
	}

	public void setOrderTimeStr(String orderTimeStr)
	{
		this.orderTimeStr = orderTimeStr;
	}

	public String getOrderStatusStr()
	{
		return orderStatusStr;
	}

	public void setOrderStatusStr(String orderStatusStr)
	{
		this.orderStatusStr = orderStatusStr;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getRestaurantName()
	{
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName)
	{
		this.restaurantName = restaurantName;
	}

	public String getSendTimeStr()
	{
		return sendTimeStr;
	}

	public void setSendTimeStr(String sendTimeStr)
	{
		this.sendTimeStr = sendTimeStr;
	}

	public String getNotifyTypeStr()
	{
		return notifyTypeStr;
	}

	public void setNotifyTypeStr(String notifyTypeStr)
	{
		this.notifyTypeStr = notifyTypeStr;
	}
}