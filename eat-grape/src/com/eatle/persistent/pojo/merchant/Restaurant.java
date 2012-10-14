package com.eatle.persistent.pojo.merchant;

public class Restaurant
{
	private Long id;

	private String name;

	private String sendMealsSpeeding;

	private String sendUpPrice;

	private String sendMealsDescription;

	private Short sendMealsStatus;

	private String businessHours;

	private String address;

	private String logoUrl;

	private String contactName;

	private String contactPhone;

	private String contactEmail;

	private String contactQq;

	private Long merchantId;
	
	// 所属商家名称（临时字段）
	private String merchantName;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSendMealsSpeeding()
	{
		return sendMealsSpeeding;
	}

	public void setSendMealsSpeeding(String sendMealsSpeeding)
	{
		this.sendMealsSpeeding = sendMealsSpeeding;
	}

	public String getSendUpPrice()
	{
		return sendUpPrice;
	}

	public void setSendUpPrice(String sendUpPrice)
	{
		this.sendUpPrice = sendUpPrice;
	}

	public String getSendMealsDescription()
	{
		return sendMealsDescription;
	}

	public void setSendMealsDescription(String sendMealsDescription)
	{
		this.sendMealsDescription = sendMealsDescription;
	}

	public Short getSendMealsStatus()
	{
		return sendMealsStatus;
	}

	public void setSendMealsStatus(Short sendMealsStatus)
	{
		this.sendMealsStatus = sendMealsStatus;
	}

	public String getBusinessHours()
	{
		return businessHours;
	}

	public void setBusinessHours(String businessHours)
	{
		this.businessHours = businessHours;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getLogoUrl()
	{
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl)
	{
		this.logoUrl = logoUrl;
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

	public String getContactEmail()
	{
		return contactEmail;
	}

	public void setContactEmail(String contactEmail)
	{
		this.contactEmail = contactEmail;
	}

	public String getContactQq()
	{
		return contactQq;
	}

	public void setContactQq(String contactQq)
	{
		this.contactQq = contactQq;
	}

	public Long getMerchantId()
	{
		return merchantId;
	}

	public void setMerchantId(Long merchantId)
	{
		this.merchantId = merchantId;
	}

	public String getMerchantName()
	{
		return merchantName;
	}

	public void setMerchantName(String merchantName)
	{
		this.merchantName = merchantName;
	}
}