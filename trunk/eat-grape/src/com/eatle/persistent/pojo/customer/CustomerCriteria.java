package com.eatle.persistent.pojo.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public CustomerCriteria()
	{
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause)
	{
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause()
	{
		return orderByClause;
	}

	public void setDistinct(boolean distinct)
	{
		this.distinct = distinct;
	}

	public boolean isDistinct()
	{
		return distinct;
	}

	public List<Criteria> getOredCriteria()
	{
		return oredCriteria;
	}

	public void or(Criteria criteria)
	{
		oredCriteria.add(criteria);
	}

	public Criteria or()
	{
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria()
	{
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0)
		{
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal()
	{
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear()
	{
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	public void setStartIndex(int startIndex)
	{
		this.startIndex = startIndex;
	}

	public int getStartIndex()
	{
		return this.startIndex;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getPageSize()
	{
		return this.pageSize;
	}

	public CustomerCriteria(int pageSize, int startIndex)
	{
		this();
		this.pageSize = pageSize;
		this.startIndex = startIndex;
	}

	protected abstract static class GeneratedCriteria
	{
		protected List<Criterion> criteria;

		protected GeneratedCriteria()
		{
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid()
		{
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria()
		{
			return criteria;
		}

		public List<Criterion> getCriteria()
		{
			return criteria;
		}

		protected void addCriterion(String condition)
		{
			if (condition == null)
			{
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property)
		{
			if (value == null)
			{
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property)
		{
			if (value1 == null || value2 == null)
			{
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull()
		{
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull()
		{
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value)
		{
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value)
		{
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value)
		{
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value)
		{
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value)
		{
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values)
		{
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values)
		{
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2)
		{
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2)
		{
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andLoginEmailIsNull()
		{
			addCriterion("login_email is null");
			return (Criteria) this;
		}

		public Criteria andLoginEmailIsNotNull()
		{
			addCriterion("login_email is not null");
			return (Criteria) this;
		}

		public Criteria andLoginEmailEqualTo(String value)
		{
			addCriterion("login_email =", value, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailNotEqualTo(String value)
		{
			addCriterion("login_email <>", value, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailGreaterThan(String value)
		{
			addCriterion("login_email >", value, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailGreaterThanOrEqualTo(String value)
		{
			addCriterion("login_email >=", value, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailLessThan(String value)
		{
			addCriterion("login_email <", value, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailLessThanOrEqualTo(String value)
		{
			addCriterion("login_email <=", value, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailLike(String value)
		{
			addCriterion("login_email like", value, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailNotLike(String value)
		{
			addCriterion("login_email not like", value, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailIn(List<String> values)
		{
			addCriterion("login_email in", values, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailNotIn(List<String> values)
		{
			addCriterion("login_email not in", values, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailBetween(String value1, String value2)
		{
			addCriterion("login_email between", value1, value2, "loginEmail");
			return (Criteria) this;
		}

		public Criteria andLoginEmailNotBetween(String value1, String value2)
		{
			addCriterion("login_email not between", value1, value2,
					"loginEmail");
			return (Criteria) this;
		}

		public Criteria andNickNameIsNull()
		{
			addCriterion("nick_name is null");
			return (Criteria) this;
		}

		public Criteria andNickNameIsNotNull()
		{
			addCriterion("nick_name is not null");
			return (Criteria) this;
		}

		public Criteria andNickNameEqualTo(String value)
		{
			addCriterion("nick_name =", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotEqualTo(String value)
		{
			addCriterion("nick_name <>", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameGreaterThan(String value)
		{
			addCriterion("nick_name >", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("nick_name >=", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLessThan(String value)
		{
			addCriterion("nick_name <", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLessThanOrEqualTo(String value)
		{
			addCriterion("nick_name <=", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLike(String value)
		{
			addCriterion("nick_name like", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotLike(String value)
		{
			addCriterion("nick_name not like", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameIn(List<String> values)
		{
			addCriterion("nick_name in", values, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotIn(List<String> values)
		{
			addCriterion("nick_name not in", values, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameBetween(String value1, String value2)
		{
			addCriterion("nick_name between", value1, value2, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotBetween(String value1, String value2)
		{
			addCriterion("nick_name not between", value1, value2, "nickName");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull()
		{
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull()
		{
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value)
		{
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value)
		{
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value)
		{
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value)
		{
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value)
		{
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value)
		{
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value)
		{
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value)
		{
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values)
		{
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values)
		{
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2)
		{
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2)
		{
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andTrueNameIsNull()
		{
			addCriterion("true_name is null");
			return (Criteria) this;
		}

		public Criteria andTrueNameIsNotNull()
		{
			addCriterion("true_name is not null");
			return (Criteria) this;
		}

		public Criteria andTrueNameEqualTo(String value)
		{
			addCriterion("true_name =", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotEqualTo(String value)
		{
			addCriterion("true_name <>", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameGreaterThan(String value)
		{
			addCriterion("true_name >", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("true_name >=", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLessThan(String value)
		{
			addCriterion("true_name <", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLessThanOrEqualTo(String value)
		{
			addCriterion("true_name <=", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameLike(String value)
		{
			addCriterion("true_name like", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotLike(String value)
		{
			addCriterion("true_name not like", value, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameIn(List<String> values)
		{
			addCriterion("true_name in", values, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotIn(List<String> values)
		{
			addCriterion("true_name not in", values, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameBetween(String value1, String value2)
		{
			addCriterion("true_name between", value1, value2, "trueName");
			return (Criteria) this;
		}

		public Criteria andTrueNameNotBetween(String value1, String value2)
		{
			addCriterion("true_name not between", value1, value2, "trueName");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeIsNull()
		{
			addCriterion("register_time is null");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeIsNotNull()
		{
			addCriterion("register_time is not null");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeEqualTo(Date value)
		{
			addCriterion("register_time =", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeNotEqualTo(Date value)
		{
			addCriterion("register_time <>", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeGreaterThan(Date value)
		{
			addCriterion("register_time >", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("register_time >=", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeLessThan(Date value)
		{
			addCriterion("register_time <", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("register_time <=", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeIn(List<Date> values)
		{
			addCriterion("register_time in", values, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeNotIn(List<Date> values)
		{
			addCriterion("register_time not in", values, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeBetween(Date value1, Date value2)
		{
			addCriterion("register_time between", value1, value2,
					"registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("register_time not between", value1, value2,
					"registerTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNull()
		{
			addCriterion("last_login_time is null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNotNull()
		{
			addCriterion("last_login_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeEqualTo(Date value)
		{
			addCriterion("last_login_time =", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotEqualTo(Date value)
		{
			addCriterion("last_login_time <>", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThan(Date value)
		{
			addCriterion("last_login_time >", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("last_login_time >=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThan(Date value)
		{
			addCriterion("last_login_time <", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("last_login_time <=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIn(List<Date> values)
		{
			addCriterion("last_login_time in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotIn(List<Date> values)
		{
			addCriterion("last_login_time not in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeBetween(Date value1, Date value2)
		{
			addCriterion("last_login_time between", value1, value2,
					"lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("last_login_time not between", value1, value2,
					"lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpIsNull()
		{
			addCriterion("last_login_ip is null");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpIsNotNull()
		{
			addCriterion("last_login_ip is not null");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpEqualTo(String value)
		{
			addCriterion("last_login_ip =", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpNotEqualTo(String value)
		{
			addCriterion("last_login_ip <>", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpGreaterThan(String value)
		{
			addCriterion("last_login_ip >", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpGreaterThanOrEqualTo(String value)
		{
			addCriterion("last_login_ip >=", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpLessThan(String value)
		{
			addCriterion("last_login_ip <", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpLessThanOrEqualTo(String value)
		{
			addCriterion("last_login_ip <=", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpLike(String value)
		{
			addCriterion("last_login_ip like", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpNotLike(String value)
		{
			addCriterion("last_login_ip not like", value, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpIn(List<String> values)
		{
			addCriterion("last_login_ip in", values, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpNotIn(List<String> values)
		{
			addCriterion("last_login_ip not in", values, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpBetween(String value1, String value2)
		{
			addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andLastLoginIpNotBetween(String value1, String value2)
		{
			addCriterion("last_login_ip not between", value1, value2,
					"lastLoginIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpIsNull()
		{
			addCriterion("register_ip is null");
			return (Criteria) this;
		}

		public Criteria andRegisterIpIsNotNull()
		{
			addCriterion("register_ip is not null");
			return (Criteria) this;
		}

		public Criteria andRegisterIpEqualTo(String value)
		{
			addCriterion("register_ip =", value, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpNotEqualTo(String value)
		{
			addCriterion("register_ip <>", value, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpGreaterThan(String value)
		{
			addCriterion("register_ip >", value, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpGreaterThanOrEqualTo(String value)
		{
			addCriterion("register_ip >=", value, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpLessThan(String value)
		{
			addCriterion("register_ip <", value, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpLessThanOrEqualTo(String value)
		{
			addCriterion("register_ip <=", value, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpLike(String value)
		{
			addCriterion("register_ip like", value, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpNotLike(String value)
		{
			addCriterion("register_ip not like", value, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpIn(List<String> values)
		{
			addCriterion("register_ip in", values, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpNotIn(List<String> values)
		{
			addCriterion("register_ip not in", values, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpBetween(String value1, String value2)
		{
			addCriterion("register_ip between", value1, value2, "registerIp");
			return (Criteria) this;
		}

		public Criteria andRegisterIpNotBetween(String value1, String value2)
		{
			addCriterion("register_ip not between", value1, value2,
					"registerIp");
			return (Criteria) this;
		}

		public Criteria andScoreIsNull()
		{
			addCriterion("score is null");
			return (Criteria) this;
		}

		public Criteria andScoreIsNotNull()
		{
			addCriterion("score is not null");
			return (Criteria) this;
		}

		public Criteria andScoreEqualTo(Integer value)
		{
			addCriterion("score =", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotEqualTo(Integer value)
		{
			addCriterion("score <>", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreGreaterThan(Integer value)
		{
			addCriterion("score >", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("score >=", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreLessThan(Integer value)
		{
			addCriterion("score <", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreLessThanOrEqualTo(Integer value)
		{
			addCriterion("score <=", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreIn(List<Integer> values)
		{
			addCriterion("score in", values, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotIn(List<Integer> values)
		{
			addCriterion("score not in", values, "score");
			return (Criteria) this;
		}

		public Criteria andScoreBetween(Integer value1, Integer value2)
		{
			addCriterion("score between", value1, value2, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotBetween(Integer value1, Integer value2)
		{
			addCriterion("score not between", value1, value2, "score");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneIsNull()
		{
			addCriterion("mobile_phone is null");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneIsNotNull()
		{
			addCriterion("mobile_phone is not null");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneEqualTo(String value)
		{
			addCriterion("mobile_phone =", value, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneNotEqualTo(String value)
		{
			addCriterion("mobile_phone <>", value, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneGreaterThan(String value)
		{
			addCriterion("mobile_phone >", value, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneGreaterThanOrEqualTo(String value)
		{
			addCriterion("mobile_phone >=", value, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneLessThan(String value)
		{
			addCriterion("mobile_phone <", value, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneLessThanOrEqualTo(String value)
		{
			addCriterion("mobile_phone <=", value, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneLike(String value)
		{
			addCriterion("mobile_phone like", value, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneNotLike(String value)
		{
			addCriterion("mobile_phone not like", value, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneIn(List<String> values)
		{
			addCriterion("mobile_phone in", values, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneNotIn(List<String> values)
		{
			addCriterion("mobile_phone not in", values, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneBetween(String value1, String value2)
		{
			addCriterion("mobile_phone between", value1, value2, "mobilePhone");
			return (Criteria) this;
		}

		public Criteria andMobilePhoneNotBetween(String value1, String value2)
		{
			addCriterion("mobile_phone not between", value1, value2,
					"mobilePhone");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeIsNull()
		{
			addCriterion("customer_type is null");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeIsNotNull()
		{
			addCriterion("customer_type is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeEqualTo(Short value)
		{
			addCriterion("customer_type =", value, "customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeNotEqualTo(Short value)
		{
			addCriterion("customer_type <>", value, "customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeGreaterThan(Short value)
		{
			addCriterion("customer_type >", value, "customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeGreaterThanOrEqualTo(Short value)
		{
			addCriterion("customer_type >=", value, "customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeLessThan(Short value)
		{
			addCriterion("customer_type <", value, "customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeLessThanOrEqualTo(Short value)
		{
			addCriterion("customer_type <=", value, "customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeIn(List<Short> values)
		{
			addCriterion("customer_type in", values, "customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeNotIn(List<Short> values)
		{
			addCriterion("customer_type not in", values, "customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeBetween(Short value1, Short value2)
		{
			addCriterion("customer_type between", value1, value2,
					"customerType");
			return (Criteria) this;
		}

		public Criteria andCustomerTypeNotBetween(Short value1, Short value2)
		{
			addCriterion("customer_type not between", value1, value2,
					"customerType");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidIsNull()
		{
			addCriterion("visitor_uuid is null");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidIsNotNull()
		{
			addCriterion("visitor_uuid is not null");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidEqualTo(String value)
		{
			addCriterion("visitor_uuid =", value, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidNotEqualTo(String value)
		{
			addCriterion("visitor_uuid <>", value, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidGreaterThan(String value)
		{
			addCriterion("visitor_uuid >", value, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidGreaterThanOrEqualTo(String value)
		{
			addCriterion("visitor_uuid >=", value, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidLessThan(String value)
		{
			addCriterion("visitor_uuid <", value, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidLessThanOrEqualTo(String value)
		{
			addCriterion("visitor_uuid <=", value, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidLike(String value)
		{
			addCriterion("visitor_uuid like", value, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidNotLike(String value)
		{
			addCriterion("visitor_uuid not like", value, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidIn(List<String> values)
		{
			addCriterion("visitor_uuid in", values, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidNotIn(List<String> values)
		{
			addCriterion("visitor_uuid not in", values, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidBetween(String value1, String value2)
		{
			addCriterion("visitor_uuid between", value1, value2, "visitorUuid");
			return (Criteria) this;
		}

		public Criteria andVisitorUuidNotBetween(String value1, String value2)
		{
			addCriterion("visitor_uuid not between", value1, value2,
					"visitorUuid");
			return (Criteria) this;
		}

		public Criteria andRelativeQqIsNull()
		{
			addCriterion("relative_qq is null");
			return (Criteria) this;
		}

		public Criteria andRelativeQqIsNotNull()
		{
			addCriterion("relative_qq is not null");
			return (Criteria) this;
		}

		public Criteria andRelativeQqEqualTo(String value)
		{
			addCriterion("relative_qq =", value, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqNotEqualTo(String value)
		{
			addCriterion("relative_qq <>", value, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqGreaterThan(String value)
		{
			addCriterion("relative_qq >", value, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqGreaterThanOrEqualTo(String value)
		{
			addCriterion("relative_qq >=", value, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqLessThan(String value)
		{
			addCriterion("relative_qq <", value, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqLessThanOrEqualTo(String value)
		{
			addCriterion("relative_qq <=", value, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqLike(String value)
		{
			addCriterion("relative_qq like", value, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqNotLike(String value)
		{
			addCriterion("relative_qq not like", value, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqIn(List<String> values)
		{
			addCriterion("relative_qq in", values, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqNotIn(List<String> values)
		{
			addCriterion("relative_qq not in", values, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqBetween(String value1, String value2)
		{
			addCriterion("relative_qq between", value1, value2, "relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeQqNotBetween(String value1, String value2)
		{
			addCriterion("relative_qq not between", value1, value2,
					"relativeQq");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaIsNull()
		{
			addCriterion("relative_sina is null");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaIsNotNull()
		{
			addCriterion("relative_sina is not null");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaEqualTo(String value)
		{
			addCriterion("relative_sina =", value, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaNotEqualTo(String value)
		{
			addCriterion("relative_sina <>", value, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaGreaterThan(String value)
		{
			addCriterion("relative_sina >", value, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaGreaterThanOrEqualTo(String value)
		{
			addCriterion("relative_sina >=", value, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaLessThan(String value)
		{
			addCriterion("relative_sina <", value, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaLessThanOrEqualTo(String value)
		{
			addCriterion("relative_sina <=", value, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaLike(String value)
		{
			addCriterion("relative_sina like", value, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaNotLike(String value)
		{
			addCriterion("relative_sina not like", value, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaIn(List<String> values)
		{
			addCriterion("relative_sina in", values, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaNotIn(List<String> values)
		{
			addCriterion("relative_sina not in", values, "relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaBetween(String value1, String value2)
		{
			addCriterion("relative_sina between", value1, value2,
					"relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeSinaNotBetween(String value1, String value2)
		{
			addCriterion("relative_sina not between", value1, value2,
					"relativeSina");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwIsNull()
		{
			addCriterion("relative_rrw is null");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwIsNotNull()
		{
			addCriterion("relative_rrw is not null");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwEqualTo(String value)
		{
			addCriterion("relative_rrw =", value, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwNotEqualTo(String value)
		{
			addCriterion("relative_rrw <>", value, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwGreaterThan(String value)
		{
			addCriterion("relative_rrw >", value, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwGreaterThanOrEqualTo(String value)
		{
			addCriterion("relative_rrw >=", value, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwLessThan(String value)
		{
			addCriterion("relative_rrw <", value, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwLessThanOrEqualTo(String value)
		{
			addCriterion("relative_rrw <=", value, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwLike(String value)
		{
			addCriterion("relative_rrw like", value, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwNotLike(String value)
		{
			addCriterion("relative_rrw not like", value, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwIn(List<String> values)
		{
			addCriterion("relative_rrw in", values, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwNotIn(List<String> values)
		{
			addCriterion("relative_rrw not in", values, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwBetween(String value1, String value2)
		{
			addCriterion("relative_rrw between", value1, value2, "relativeRrw");
			return (Criteria) this;
		}

		public Criteria andRelativeRrwNotBetween(String value1, String value2)
		{
			addCriterion("relative_rrw not between", value1, value2,
					"relativeRrw");
			return (Criteria) this;
		}

		public Criteria andCommunityIdIsNull()
		{
			addCriterion("community_id is null");
			return (Criteria) this;
		}

		public Criteria andCommunityIdIsNotNull()
		{
			addCriterion("community_id is not null");
			return (Criteria) this;
		}

		public Criteria andCommunityIdEqualTo(Long value)
		{
			addCriterion("community_id =", value, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdNotEqualTo(Long value)
		{
			addCriterion("community_id <>", value, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdGreaterThan(Long value)
		{
			addCriterion("community_id >", value, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("community_id >=", value, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdLessThan(Long value)
		{
			addCriterion("community_id <", value, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdLessThanOrEqualTo(Long value)
		{
			addCriterion("community_id <=", value, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdIn(List<Long> values)
		{
			addCriterion("community_id in", values, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdNotIn(List<Long> values)
		{
			addCriterion("community_id not in", values, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdBetween(Long value1, Long value2)
		{
			addCriterion("community_id between", value1, value2, "communityId");
			return (Criteria) this;
		}

		public Criteria andCommunityIdNotBetween(Long value1, Long value2)
		{
			addCriterion("community_id not between", value1, value2,
					"communityId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdIsNull()
		{
			addCriterion("school_id is null");
			return (Criteria) this;
		}

		public Criteria andSchoolIdIsNotNull()
		{
			addCriterion("school_id is not null");
			return (Criteria) this;
		}

		public Criteria andSchoolIdEqualTo(Long value)
		{
			addCriterion("school_id =", value, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdNotEqualTo(Long value)
		{
			addCriterion("school_id <>", value, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdGreaterThan(Long value)
		{
			addCriterion("school_id >", value, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("school_id >=", value, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdLessThan(Long value)
		{
			addCriterion("school_id <", value, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdLessThanOrEqualTo(Long value)
		{
			addCriterion("school_id <=", value, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdIn(List<Long> values)
		{
			addCriterion("school_id in", values, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdNotIn(List<Long> values)
		{
			addCriterion("school_id not in", values, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdBetween(Long value1, Long value2)
		{
			addCriterion("school_id between", value1, value2, "schoolId");
			return (Criteria) this;
		}

		public Criteria andSchoolIdNotBetween(Long value1, Long value2)
		{
			addCriterion("school_id not between", value1, value2, "schoolId");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria
	{

		protected Criteria()
		{
			super();
		}
	}

	public static class Criterion
	{
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition()
		{
			return condition;
		}

		public Object getValue()
		{
			return value;
		}

		public Object getSecondValue()
		{
			return secondValue;
		}

		public boolean isNoValue()
		{
			return noValue;
		}

		public boolean isSingleValue()
		{
			return singleValue;
		}

		public boolean isBetweenValue()
		{
			return betweenValue;
		}

		public boolean isListValue()
		{
			return listValue;
		}

		public String getTypeHandler()
		{
			return typeHandler;
		}

		protected Criterion(String condition)
		{
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler)
		{
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>)
			{
				this.listValue = true;
			}
			else
			{
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value)
		{
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler)
		{
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue)
		{
			this(condition, value, secondValue, null);
		}
	}
}