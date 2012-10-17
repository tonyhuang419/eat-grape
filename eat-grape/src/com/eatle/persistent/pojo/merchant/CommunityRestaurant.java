package com.eatle.persistent.pojo.merchant;

public class CommunityRestaurant
{
	private Long id;

	private Long communityId;

	private Long restaurantId;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getCommunityId()
	{
		return communityId;
	}

	public void setCommunityId(Long communityId)
	{
		this.communityId = communityId;
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