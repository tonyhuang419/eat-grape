package com.eatle.persistent.pojo.merchant;

public class UserMerchant
{
	private Long id;

	private Long userId;

	private Long merchantId;

	private String manageRestaurantList;

	// 临时属性（账号名称）
	private String userName;

	// 临时属性（商家名称）
	private String merchantName;

	// 临时属性（可管理餐厅的名称）
	private String manageRestaurantListStr;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getMerchantId()
	{
		return merchantId;
	}

	public void setMerchantId(Long merchantId)
	{
		this.merchantId = merchantId;
	}

	public String getManageRestaurantList()
	{
		return manageRestaurantList;
	}

	public void setManageRestaurantList(String manageRestaurantList)
	{
		this.manageRestaurantList = manageRestaurantList;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getMerchantName()
	{
		return merchantName;
	}

	public void setMerchantName(String merchantName)
	{
		this.merchantName = merchantName;
	}

	public String getManageRestaurantListStr()
	{
		return manageRestaurantListStr;
	}

	public void setManageRestaurantListStr(String manageRestaurantListStr)
	{
		this.manageRestaurantListStr = manageRestaurantListStr;
	}
}