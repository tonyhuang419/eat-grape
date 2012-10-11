package com.eatle.persistent.pojo.merchant;

import java.sql.Date;

public class Merchant
{
	private Long id;

	private String merchantName;

	private String merchantPhone;

	private String merchantEmail;

	private String merchantAddress;

	private Date merchantJoinTime;

	private String merchantLogoUrl;

	private String legalName;

	private String legalIdCard;

	private String legalPhone;

	private String legalHomeAddress;

	private String legalAddress;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLegalName()
	{
		return legalName;
	}

	public void setLegalName(String legalName)
	{
		this.legalName = legalName;
	}

	public String getLegalIdCard()
	{
		return legalIdCard;
	}

	public void setLegalIdCard(String legalIdCard)
	{
		this.legalIdCard = legalIdCard;
	}

	public String getLegalHomeAddress()
	{
		return legalHomeAddress;
	}

	public void setLegalHomeAddress(String legalHomeAddress)
	{
		this.legalHomeAddress = legalHomeAddress;
	}

	public String getLegalAddress()
	{
		return legalAddress;
	}

	public void setLegalAddress(String legalAddress)
	{
		this.legalAddress = legalAddress;
	}

	public String getLegalPhone()
	{
		return legalPhone;
	}

	public void setLegalPhone(String legalPhone)
	{
		this.legalPhone = legalPhone;
	}

	public Date getMerchantJoinTime()
	{
		return merchantJoinTime;
	}

	public void setMerchantJoinTime(Date merchantJoinTime)
	{
		this.merchantJoinTime = merchantJoinTime;
	}

	public String getMerchantLogoUrl()
	{
		return merchantLogoUrl;
	}

	public void setMerchantLogoUrl(String merchantLogoUrl)
	{
		this.merchantLogoUrl = merchantLogoUrl;
	}

	public String getMerchantName()
	{
		return merchantName;
	}

	public void setMerchantName(String merchantName)
	{
		this.merchantName = merchantName;
	}

	public String getMerchantPhone()
	{
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone)
	{
		this.merchantPhone = merchantPhone;
	}

	public String getMerchantAddress()
	{
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress)
	{
		this.merchantAddress = merchantAddress;
	}

	public String getMerchantEmail()
	{
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail)
	{
		this.merchantEmail = merchantEmail;
	}
}