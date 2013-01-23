package com.eatle.persistent.pojo.order;

public class OrderItem
{
	private Long id;

	private String itemName;

	private Float unitPrice;

	private Integer count;

	private Float discount;

	private String description;

	private Long orderId;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public Float getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	public Float getDiscount()
	{
		return discount;
	}

	public void setDiscount(Float discount)
	{
		this.discount = discount;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(Long orderId)
	{
		this.orderId = orderId;
	}
}