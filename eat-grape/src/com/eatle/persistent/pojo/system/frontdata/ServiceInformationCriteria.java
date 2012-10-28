package com.eatle.persistent.pojo.system.frontdata;

import java.util.ArrayList;
import java.util.List;

public class ServiceInformationCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public ServiceInformationCriteria()
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

	public ServiceInformationCriteria(int pageSize, int startIndex)
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

		public Criteria andServeMobileIsNull()
		{
			addCriterion("serve_mobile is null");
			return (Criteria) this;
		}

		public Criteria andServeMobileIsNotNull()
		{
			addCriterion("serve_mobile is not null");
			return (Criteria) this;
		}

		public Criteria andServeMobileEqualTo(String value)
		{
			addCriterion("serve_mobile =", value, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileNotEqualTo(String value)
		{
			addCriterion("serve_mobile <>", value, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileGreaterThan(String value)
		{
			addCriterion("serve_mobile >", value, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileGreaterThanOrEqualTo(String value)
		{
			addCriterion("serve_mobile >=", value, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileLessThan(String value)
		{
			addCriterion("serve_mobile <", value, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileLessThanOrEqualTo(String value)
		{
			addCriterion("serve_mobile <=", value, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileLike(String value)
		{
			addCriterion("serve_mobile like", value, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileNotLike(String value)
		{
			addCriterion("serve_mobile not like", value, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileIn(List<String> values)
		{
			addCriterion("serve_mobile in", values, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileNotIn(List<String> values)
		{
			addCriterion("serve_mobile not in", values, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileBetween(String value1, String value2)
		{
			addCriterion("serve_mobile between", value1, value2, "serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeMobileNotBetween(String value1, String value2)
		{
			addCriterion("serve_mobile not between", value1, value2,
					"serveMobile");
			return (Criteria) this;
		}

		public Criteria andServeTelIsNull()
		{
			addCriterion("serve_tel is null");
			return (Criteria) this;
		}

		public Criteria andServeTelIsNotNull()
		{
			addCriterion("serve_tel is not null");
			return (Criteria) this;
		}

		public Criteria andServeTelEqualTo(String value)
		{
			addCriterion("serve_tel =", value, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelNotEqualTo(String value)
		{
			addCriterion("serve_tel <>", value, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelGreaterThan(String value)
		{
			addCriterion("serve_tel >", value, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelGreaterThanOrEqualTo(String value)
		{
			addCriterion("serve_tel >=", value, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelLessThan(String value)
		{
			addCriterion("serve_tel <", value, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelLessThanOrEqualTo(String value)
		{
			addCriterion("serve_tel <=", value, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelLike(String value)
		{
			addCriterion("serve_tel like", value, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelNotLike(String value)
		{
			addCriterion("serve_tel not like", value, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelIn(List<String> values)
		{
			addCriterion("serve_tel in", values, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelNotIn(List<String> values)
		{
			addCriterion("serve_tel not in", values, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelBetween(String value1, String value2)
		{
			addCriterion("serve_tel between", value1, value2, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeTelNotBetween(String value1, String value2)
		{
			addCriterion("serve_tel not between", value1, value2, "serveTel");
			return (Criteria) this;
		}

		public Criteria andServeQqIsNull()
		{
			addCriterion("serve_qq is null");
			return (Criteria) this;
		}

		public Criteria andServeQqIsNotNull()
		{
			addCriterion("serve_qq is not null");
			return (Criteria) this;
		}

		public Criteria andServeQqEqualTo(String value)
		{
			addCriterion("serve_qq =", value, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqNotEqualTo(String value)
		{
			addCriterion("serve_qq <>", value, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqGreaterThan(String value)
		{
			addCriterion("serve_qq >", value, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqGreaterThanOrEqualTo(String value)
		{
			addCriterion("serve_qq >=", value, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqLessThan(String value)
		{
			addCriterion("serve_qq <", value, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqLessThanOrEqualTo(String value)
		{
			addCriterion("serve_qq <=", value, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqLike(String value)
		{
			addCriterion("serve_qq like", value, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqNotLike(String value)
		{
			addCriterion("serve_qq not like", value, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqIn(List<String> values)
		{
			addCriterion("serve_qq in", values, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqNotIn(List<String> values)
		{
			addCriterion("serve_qq not in", values, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqBetween(String value1, String value2)
		{
			addCriterion("serve_qq between", value1, value2, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeQqNotBetween(String value1, String value2)
		{
			addCriterion("serve_qq not between", value1, value2, "serveQq");
			return (Criteria) this;
		}

		public Criteria andServeEmailIsNull()
		{
			addCriterion("serve_email is null");
			return (Criteria) this;
		}

		public Criteria andServeEmailIsNotNull()
		{
			addCriterion("serve_email is not null");
			return (Criteria) this;
		}

		public Criteria andServeEmailEqualTo(String value)
		{
			addCriterion("serve_email =", value, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailNotEqualTo(String value)
		{
			addCriterion("serve_email <>", value, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailGreaterThan(String value)
		{
			addCriterion("serve_email >", value, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailGreaterThanOrEqualTo(String value)
		{
			addCriterion("serve_email >=", value, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailLessThan(String value)
		{
			addCriterion("serve_email <", value, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailLessThanOrEqualTo(String value)
		{
			addCriterion("serve_email <=", value, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailLike(String value)
		{
			addCriterion("serve_email like", value, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailNotLike(String value)
		{
			addCriterion("serve_email not like", value, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailIn(List<String> values)
		{
			addCriterion("serve_email in", values, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailNotIn(List<String> values)
		{
			addCriterion("serve_email not in", values, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailBetween(String value1, String value2)
		{
			addCriterion("serve_email between", value1, value2, "serveEmail");
			return (Criteria) this;
		}

		public Criteria andServeEmailNotBetween(String value1, String value2)
		{
			addCriterion("serve_email not between", value1, value2,
					"serveEmail");
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