package com.eatle.persistent.pojo.customer;

import java.util.Date;

public class Customer
{
	private Long id;

	private String loginEmail;

	private String nickName;

	private String password;

	private String trueName;

	private Date registerTime;

	private Date lastLoginTime;

	private String lastLoginIp;

	private String registerIp;

	private Integer score;

	private String mobilePhone;

	private Short customerType;

	private String visitorUuid;

	private String relativeQq;

	private String relativeSina;

	private String relativeRrw;

	private Long communityId;

	private Long schoolId;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLoginEmail()
	{
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail)
	{
		this.loginEmail = loginEmail;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getTrueName()
	{
		return trueName;
	}

	public void setTrueName(String trueName)
	{
		this.trueName = trueName;
	}

	public Date getRegisterTime()
	{
		return registerTime;
	}

	public void setRegisterTime(Date registerTime)
	{
		this.registerTime = registerTime;
	}

	public Date getLastLoginTime()
	{
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp()
	{
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp)
	{
		this.lastLoginIp = lastLoginIp;
	}

	public String getRegisterIp()
	{
		return registerIp;
	}

	public void setRegisterIp(String registerIp)
	{
		this.registerIp = registerIp;
	}

	public Integer getScore()
	{
		return score;
	}

	public void setScore(Integer score)
	{
		this.score = score;
	}

	public String getMobilePhone()
	{
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}

	public Short getCustomerType()
	{
		return customerType;
	}

	public void setCustomerType(Short customerType)
	{
		this.customerType = customerType;
	}

	public String getVisitorUuid()
	{
		return visitorUuid;
	}

	public void setVisitorUuid(String visitorUuid)
	{
		this.visitorUuid = visitorUuid;
	}

	public String getRelativeQq()
	{
		return relativeQq;
	}

	public void setRelativeQq(String relativeQq)
	{
		this.relativeQq = relativeQq;
	}

	public String getRelativeSina()
	{
		return relativeSina;
	}

	public void setRelativeSina(String relativeSina)
	{
		this.relativeSina = relativeSina;
	}

	public String getRelativeRrw()
	{
		return relativeRrw;
	}

	public void setRelativeRrw(String relativeRrw)
	{
		this.relativeRrw = relativeRrw;
	}

	public Long getCommunityId()
	{
		return communityId;
	}

	public void setCommunityId(Long communityId)
	{
		this.communityId = communityId;
	}

	public Long getSchoolId()
	{
		return schoolId;
	}

	public void setSchoolId(Long schoolId)
	{
		this.schoolId = schoolId;
	}
}