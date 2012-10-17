package com.eatle.persistent.pojo.foundation.place;

import java.util.List;

import com.eatle.persistent.pojo.merchant.Restaurant;

public class School
{
	private Long id;

	private String name;

	private String englishName;

	private Integer hot;

	private Long districtId;

	private String districtName;			// 临时属性(完整区域名称)
	
	private List<Restaurant> restaurants;	// 临时属性（餐厅集合）

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

	public String getEnglishName()
	{
		return englishName;
	}

	public void setEnglishName(String englishName)
	{
		this.englishName = englishName;
	}

	public Integer getHot()
	{
		return hot;
	}

	public void setHot(Integer hot)
	{
		this.hot = hot;
	}

	public Long getDistrictId()
	{
		return districtId;
	}

	public void setDistrictId(Long districtId)
	{
		this.districtId = districtId;
	}

	public String getDistrictName()
	{
		return districtName;
	}

	public void setDistrictName(String districtName)
	{
		this.districtName = districtName;
	}

	public List<Restaurant> getRestaurants()
	{
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants)
	{
		this.restaurants = restaurants;
	}
}