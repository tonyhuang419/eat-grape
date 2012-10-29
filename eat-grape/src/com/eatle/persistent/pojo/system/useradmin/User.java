package com.eatle.persistent.pojo.system.useradmin;

import java.io.Serializable;
import java.util.Map;

public class User implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String userName;

	private String pwd;

	private String email;

	private Short type;

	private Long roleId;
	
	// 拥有的权限集合
	private Map<String, Priv> allPrivs;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Short getType()
	{
		return type;
	}

	public void setType(Short type)
	{
		this.type = type;
	}

	public Long getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}

	public Map<String, Priv> getAllPrivs()
	{
		return allPrivs;
	}

	public void setAllPrivs(Map<String, Priv> allPrivs)
	{
		this.allPrivs = allPrivs;
	}

	@Override
	public boolean equals(Object that)
	{
		if (this == that)
		{
			return true;
		}
		if (that == null)
		{
			return false;
		}
		if (getClass() != that.getClass())
		{
			return false;
		}
		User other = (User) that;
		return (this.getId() == null ? other.getId() == null : this.getId()
				.equals(other.getId()))
				&& (this.getUserName() == null ? other.getUserName() == null
						: this.getUserName().equals(other.getUserName()))
				&& (this.getPwd() == null ? other.getPwd() == null : this
						.getPwd().equals(other.getPwd()))
				&& (this.getEmail() == null ? other.getEmail() == null : this
						.getEmail().equals(other.getEmail()))
				&& (this.getType() == null ? other.getType() == null : this
						.getType().equals(other.getType()))
				&& (this.getRoleId() == null ? other.getRoleId() == null : this
						.getRoleId().equals(other.getRoleId()));
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result
				+ ((getUserName() == null) ? 0 : getUserName().hashCode());
		result = prime * result
				+ ((getPwd() == null) ? 0 : getPwd().hashCode());
		result = prime * result
				+ ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result
				+ ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result
				+ ((getRoleId() == null) ? 0 : getRoleId().hashCode());
		return result;
	}
}