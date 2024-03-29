package com.eatle.persistent.pojo.foundation.dictionary;

import java.util.ArrayList;
import java.util.List;

public class MenuFeatureCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public MenuFeatureCriteria()
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

	public MenuFeatureCriteria(int pageSize, int startIndex)
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

		public Criteria andFeatureIsNull()
		{
			addCriterion("feature is null");
			return (Criteria) this;
		}

		public Criteria andFeatureIsNotNull()
		{
			addCriterion("feature is not null");
			return (Criteria) this;
		}

		public Criteria andFeatureEqualTo(String value)
		{
			addCriterion("feature =", value, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureNotEqualTo(String value)
		{
			addCriterion("feature <>", value, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureGreaterThan(String value)
		{
			addCriterion("feature >", value, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureGreaterThanOrEqualTo(String value)
		{
			addCriterion("feature >=", value, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureLessThan(String value)
		{
			addCriterion("feature <", value, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureLessThanOrEqualTo(String value)
		{
			addCriterion("feature <=", value, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureLike(String value)
		{
			addCriterion("feature like", value, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureNotLike(String value)
		{
			addCriterion("feature not like", value, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureIn(List<String> values)
		{
			addCriterion("feature in", values, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureNotIn(List<String> values)
		{
			addCriterion("feature not in", values, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureBetween(String value1, String value2)
		{
			addCriterion("feature between", value1, value2, "feature");
			return (Criteria) this;
		}

		public Criteria andFeatureNotBetween(String value1, String value2)
		{
			addCriterion("feature not between", value1, value2, "feature");
			return (Criteria) this;
		}

		public Criteria andImageUrlIsNull()
		{
			addCriterion("image_url is null");
			return (Criteria) this;
		}

		public Criteria andImageUrlIsNotNull()
		{
			addCriterion("image_url is not null");
			return (Criteria) this;
		}

		public Criteria andImageUrlEqualTo(String value)
		{
			addCriterion("image_url =", value, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlNotEqualTo(String value)
		{
			addCriterion("image_url <>", value, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlGreaterThan(String value)
		{
			addCriterion("image_url >", value, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlGreaterThanOrEqualTo(String value)
		{
			addCriterion("image_url >=", value, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlLessThan(String value)
		{
			addCriterion("image_url <", value, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlLessThanOrEqualTo(String value)
		{
			addCriterion("image_url <=", value, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlLike(String value)
		{
			addCriterion("image_url like", value, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlNotLike(String value)
		{
			addCriterion("image_url not like", value, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlIn(List<String> values)
		{
			addCriterion("image_url in", values, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlNotIn(List<String> values)
		{
			addCriterion("image_url not in", values, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlBetween(String value1, String value2)
		{
			addCriterion("image_url between", value1, value2, "imageUrl");
			return (Criteria) this;
		}

		public Criteria andImageUrlNotBetween(String value1, String value2)
		{
			addCriterion("image_url not between", value1, value2, "imageUrl");
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