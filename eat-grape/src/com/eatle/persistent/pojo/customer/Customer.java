package com.eatle.persistent.pojo.customer;

import java.util.Date;

public class Customer
{
	private Long id;

	private String loginEmail;

	private String nickName;

	private String password;

	private String trueName;

	private String headPicUrl;

	private Date registerTime;

	private Date lastLoginTime;

	private String lastLoginIp;

	private String registerIp;

	private Integer score;

	private String mobilePhone;

	private Short customerType;

	private Short isEnabled;

	private String visitorUuid;

	private String relativeQq;

	private String relativeSina;

	private String relativeRrw;

	private Long communityId;

	private Long schoolId;

	// 临时属性（注册时间字符串）
	private String registerTimeStr;

	// 临时属性（最后登陆时间字符串）
	private String lastLoginTimeStr;

	// 临时属性（顾客类型字符串）
	private String customerTypeStr;

	// 临时属性（是否可用字符串）
	private String isEnabledStr;

	// 临时属性（所属社区名称）
	private String communityName;

	// 临时属性（所属学校名称）
	private String schoolName;

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

	public String getHeadPicUrl()
	{
		return headPicUrl;
	}

	public void setHeadPicUrl(String headPicUrl)
	{
		this.headPicUrl = headPicUrl;
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

	public Short getIsEnabled()
	{
		return isEnabled;
	}

	public void setIsEnabled(Short isEnabled)
	{
		this.isEnabled = isEnabled;
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

	public String getRegisterTimeStr()
	{
		return registerTimeStr;
	}

	public void setRegisterTimeStr(String registerTimeStr)
	{
		this.registerTimeStr = registerTimeStr;
	}

	public String getLastLoginTimeStr()
	{
		return lastLoginTimeStr;
	}

	public void setLastLoginTimeStr(String lastLoginTimeStr)
	{
		this.lastLoginTimeStr = lastLoginTimeStr;
	}

	public String getCustomerTypeStr()
	{
		return customerTypeStr;
	}

	public void setCustomerTypeStr(String customerTypeStr)
	{
		this.customerTypeStr = customerTypeStr;
	}

	public String getIsEnabledStr()
	{
		return isEnabledStr;
	}

	public void setIsEnabledStr(String isEnabledStr)
	{
		this.isEnabledStr = isEnabledStr;
	}

	public String getCommunityName()
	{
		return communityName;
	}

	public void setCommunityName(String communityName)
	{
		this.communityName = communityName;
	}

	public String getSchoolName()
	{
		return schoolName;
	}

	public void setSchoolName(String schoolName)
	{
		this.schoolName = schoolName;
	}
}