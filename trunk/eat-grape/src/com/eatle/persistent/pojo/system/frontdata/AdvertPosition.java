package com.eatle.persistent.pojo.system.frontdata;

public class AdvertPosition
{
	private Long id;

	private String positionName;

	private Short positionWidth;

	private Short positionHeight;

	private String positionDescription;

	private String positionStyle;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getPositionName()
	{
		return positionName;
	}

	public void setPositionName(String positionName)
	{
		this.positionName = positionName;
	}

	public Short getPositionWidth()
	{
		return positionWidth;
	}

	public void setPositionWidth(Short positionWidth)
	{
		this.positionWidth = positionWidth;
	}

	public Short getPositionHeight()
	{
		return positionHeight;
	}

	public void setPositionHeight(Short positionHeight)
	{
		this.positionHeight = positionHeight;
	}

	public String getPositionDescription()
	{
		return positionDescription;
	}

	public void setPositionDescription(String positionDescription)
	{
		this.positionDescription = positionDescription;
	}

	public String getPositionStyle()
	{
		return positionStyle;
	}

	public void setPositionStyle(String positionStyle)
	{
		this.positionStyle = positionStyle;
	}
}