package com.eatle.persistent.pojo.system.systemdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginLogCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public LoginLogCriteria()
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

	public LoginLogCriteria(int pageSize, int startIndex)
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

		public Criteria andIdentifyTypeIsNull()
		{
			addCriterion("identify_type is null");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeIsNotNull()
		{
			addCriterion("identify_type is not null");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeEqualTo(Short value)
		{
			addCriterion("identify_type =", value, "identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeNotEqualTo(Short value)
		{
			addCriterion("identify_type <>", value, "identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeGreaterThan(Short value)
		{
			addCriterion("identify_type >", value, "identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeGreaterThanOrEqualTo(Short value)
		{
			addCriterion("identify_type >=", value, "identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeLessThan(Short value)
		{
			addCriterion("identify_type <", value, "identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeLessThanOrEqualTo(Short value)
		{
			addCriterion("identify_type <=", value, "identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeIn(List<Short> values)
		{
			addCriterion("identify_type in", values, "identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeNotIn(List<Short> values)
		{
			addCriterion("identify_type not in", values, "identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeBetween(Short value1, Short value2)
		{
			addCriterion("identify_type between", value1, value2,
					"identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyTypeNotBetween(Short value1, Short value2)
		{
			addCriterion("identify_type not between", value1, value2,
					"identifyType");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdIsNull()
		{
			addCriterion("identify_id is null");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdIsNotNull()
		{
			addCriterion("identify_id is not null");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdEqualTo(Long value)
		{
			addCriterion("identify_id =", value, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdNotEqualTo(Long value)
		{
			addCriterion("identify_id <>", value, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdGreaterThan(Long value)
		{
			addCriterion("identify_id >", value, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("identify_id >=", value, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdLessThan(Long value)
		{
			addCriterion("identify_id <", value, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdLessThanOrEqualTo(Long value)
		{
			addCriterion("identify_id <=", value, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdIn(List<Long> values)
		{
			addCriterion("identify_id in", values, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdNotIn(List<Long> values)
		{
			addCriterion("identify_id not in", values, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdBetween(Long value1, Long value2)
		{
			addCriterion("identify_id between", value1, value2, "identifyId");
			return (Criteria) this;
		}

		public Criteria andIdentifyIdNotBetween(Long value1, Long value2)
		{
			addCriterion("identify_id not between", value1, value2,
					"identifyId");
			return (Criteria) this;
		}

		public Criteria andLoginIpIsNull()
		{
			addCriterion("login_ip is null");
			return (Criteria) this;
		}

		public Criteria andLoginIpIsNotNull()
		{
			addCriterion("login_ip is not null");
			return (Criteria) this;
		}

		public Criteria andLoginIpEqualTo(String value)
		{
			addCriterion("login_ip =", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpNotEqualTo(String value)
		{
			addCriterion("login_ip <>", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpGreaterThan(String value)
		{
			addCriterion("login_ip >", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpGreaterThanOrEqualTo(String value)
		{
			addCriterion("login_ip >=", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpLessThan(String value)
		{
			addCriterion("login_ip <", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpLessThanOrEqualTo(String value)
		{
			addCriterion("login_ip <=", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpLike(String value)
		{
			addCriterion("login_ip like", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpNotLike(String value)
		{
			addCriterion("login_ip not like", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpIn(List<String> values)
		{
			addCriterion("login_ip in", values, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpNotIn(List<String> values)
		{
			addCriterion("login_ip not in", values, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpBetween(String value1, String value2)
		{
			addCriterion("login_ip between", value1, value2, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpNotBetween(String value1, String value2)
		{
			addCriterion("login_ip not between", value1, value2, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIsNull()
		{
			addCriterion("login_time is null");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIsNotNull()
		{
			addCriterion("login_time is not null");
			return (Criteria) this;
		}

		public Criteria andLoginTimeEqualTo(Date value)
		{
			addCriterion("login_time =", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotEqualTo(Date value)
		{
			addCriterion("login_time <>", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeGreaterThan(Date value)
		{
			addCriterion("login_time >", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("login_time >=", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeLessThan(Date value)
		{
			addCriterion("login_time <", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("login_time <=", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIn(List<Date> values)
		{
			addCriterion("login_time in", values, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotIn(List<Date> values)
		{
			addCriterion("login_time not in", values, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeBetween(Date value1, Date value2)
		{
			addCriterion("login_time between", value1, value2, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("login_time not between", value1, value2, "loginTime");
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