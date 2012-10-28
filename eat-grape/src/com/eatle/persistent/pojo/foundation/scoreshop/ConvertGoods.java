package com.eatle.persistent.pojo.foundation.scoreshop;

public class ConvertGoods
{
	private Long id;

	private String name;

	private String describe;

	private String picUrl;

	private Integer total;

	private Integer surplus;

	private Integer score;

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

	public String getDescribe()
	{
		return describe;
	}

	public void setDescribe(String describe)
	{
		this.describe = describe;
	}

	public String getPicUrl()
	{
		return picUrl;
	}

	public void setPicUrl(String picUrl)
	{
		this.picUrl = picUrl;
	}

	public Integer getTotal()
	{
		return total;
	}

	public void setTotal(Integer total)
	{
		this.total = total;
	}

	public Integer getSurplus()
	{
		return surplus;
	}

	public void setSurplus(Integer surplus)
	{
		this.surplus = surplus;
	}

	public Integer getScore()
	{
		return score;
	}

	public void setScore(Integer score)
	{
		this.score = score;
	}
}