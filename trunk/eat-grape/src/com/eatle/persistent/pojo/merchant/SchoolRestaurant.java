package com.eatle.persistent.pojo.merchant;

public class SchoolRestaurant
{
	private Long id;

	private Long schoolId;

	private Long restaurantId;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getSchoolId()
	{
		return schoolId;
	}

	public void setSchoolId(Long schoolId)
	{
		this.schoolId = schoolId;
	}

	public Long getRestaurantId()
	{
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId)
	{
		this.restaurantId = restaurantId;
	}
}