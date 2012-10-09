package com.eatle.persistent.pojo.foundation.place;

public class School
{
	private Long id;

	private String name;

	private String englishName;

	private Integer hot;

	private Long districtId;

	// 临时字段(完整区域名称)
	private String districtName;

	public String getDistrictName()
	{
		return districtName;
	}

	public void setDistrictName(String districtName)
	{
		this.districtName = districtName;
	}

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
}