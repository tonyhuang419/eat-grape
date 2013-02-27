package com.eatle.persistent.pojo.merchant;

import java.util.List;

import com.eatle.persistent.pojo.foundation.place.Community;
import com.eatle.persistent.pojo.foundation.place.School;

public class Restaurant
{
	private Long id;

	private String name;

	private String contactName;

	private String contactPhone;

	private String contactEmail;

	private String contactQq;

	private String businessHours;

	private String sendUpPrice;

	private String address;

	private String logoUrl;

	private String sendMealsDescription;

	private String sendMealsSpeeding;

	private Short sendMealsStatus;

	private String shopType;

	private Long merchantId;

	private String shopTypeStr; // 临时属性（餐厅主营类型名称）

	private String merchantName; // 临时属性（所属商家名）

	private List<School> schools; // 临时属性（学校集合）

	private List<Community> community; // 临时属性（社区/楼宇集合）

	private Boolean isManaged; // 临时属性（用户、商家关联修改时会使用）

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

	public String getBusinessHours()
	{
		return businessHours;
	}

	public void setBusinessHours(String businessHours)
	{
		this.businessHours = businessHours;
	}

	public String getSendUpPrice()
	{
		return sendUpPrice;
	}

	public void setSendUpPrice(String sendUpPrice)
	{
		this.sendUpPrice = sendUpPrice;
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

	public String getSendMealsDescription()
	{
		return sendMealsDescription;
	}

	public void setSendMealsDescription(String sendMealsDescription)
	{
		this.sendMealsDescription = sendMealsDescription;
	}

	public String getSendMealsSpeeding()
	{
		return sendMealsSpeeding;
	}

	public void setSendMealsSpeeding(String sendMealsSpeeding)
	{
		this.sendMealsSpeeding = sendMealsSpeeding;
	}

	public Short getSendMealsStatus()
	{
		return sendMealsStatus;
	}

	public void setSendMealsStatus(Short sendMealsStatus)
	{
		this.sendMealsStatus = sendMealsStatus;
	}

	public String getShopType()
	{
		return shopType;
	}

	public void setShopType(String shopType)
	{
		this.shopType = shopType;
	}

	public Long getMerchantId()
	{
		return merchantId;
	}

	public void setMerchantId(Long merchantId)
	{
		this.merchantId = merchantId;
	}

	public String getShopTypeStr()
	{
		return shopTypeStr;
	}

	public void setShopTypeStr(String shopTypeStr)
	{
		this.shopTypeStr = shopTypeStr;
	}

	public String getMerchantName()
	{
		return merchantName;
	}

	public void setMerchantName(String merchantName)
	{
		this.merchantName = merchantName;
	}

	public List<School> getSchools()
	{
		return schools;
	}

	public void setSchools(List<School> schools)
	{
		this.schools = schools;
	}

	public List<Community> getCommunity()
	{
		return community;
	}

	public void setCommunity(List<Community> community)
	{
		this.community = community;
	}

	public Boolean getIsManaged()
	{
		return isManaged;
	}

	public void setIsManaged(Boolean isManaged)
	{
		this.isManaged = isManaged;
	}
}