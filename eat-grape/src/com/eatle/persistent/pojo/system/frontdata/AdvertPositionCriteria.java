package com.eatle.persistent.pojo.system.frontdata;

import java.util.ArrayList;
import java.util.List;

public class AdvertPositionCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public AdvertPositionCriteria()
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

	public AdvertPositionCriteria(int pageSize, int startIndex)
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

		public Criteria andPositionNameIsNull()
		{
			addCriterion("position_name is null");
			return (Criteria) this;
		}

		public Criteria andPositionNameIsNotNull()
		{
			addCriterion("position_name is not null");
			return (Criteria) this;
		}

		public Criteria andPositionNameEqualTo(String value)
		{
			addCriterion("position_name =", value, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameNotEqualTo(String value)
		{
			addCriterion("position_name <>", value, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameGreaterThan(String value)
		{
			addCriterion("position_name >", value, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("position_name >=", value, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameLessThan(String value)
		{
			addCriterion("position_name <", value, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameLessThanOrEqualTo(String value)
		{
			addCriterion("position_name <=", value, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameLike(String value)
		{
			addCriterion("position_name like", value, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameNotLike(String value)
		{
			addCriterion("position_name not like", value, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameIn(List<String> values)
		{
			addCriterion("position_name in", values, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameNotIn(List<String> values)
		{
			addCriterion("position_name not in", values, "positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameBetween(String value1, String value2)
		{
			addCriterion("position_name between", value1, value2,
					"positionName");
			return (Criteria) this;
		}

		public Criteria andPositionNameNotBetween(String value1, String value2)
		{
			addCriterion("position_name not between", value1, value2,
					"positionName");
			return (Criteria) this;
		}

		public Criteria andPositionWidthIsNull()
		{
			addCriterion("position_width is null");
			return (Criteria) this;
		}

		public Criteria andPositionWidthIsNotNull()
		{
			addCriterion("position_width is not null");
			return (Criteria) this;
		}

		public Criteria andPositionWidthEqualTo(Short value)
		{
			addCriterion("position_width =", value, "positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthNotEqualTo(Short value)
		{
			addCriterion("position_width <>", value, "positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthGreaterThan(Short value)
		{
			addCriterion("position_width >", value, "positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthGreaterThanOrEqualTo(Short value)
		{
			addCriterion("position_width >=", value, "positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthLessThan(Short value)
		{
			addCriterion("position_width <", value, "positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthLessThanOrEqualTo(Short value)
		{
			addCriterion("position_width <=", value, "positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthIn(List<Short> values)
		{
			addCriterion("position_width in", values, "positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthNotIn(List<Short> values)
		{
			addCriterion("position_width not in", values, "positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthBetween(Short value1, Short value2)
		{
			addCriterion("position_width between", value1, value2,
					"positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionWidthNotBetween(Short value1, Short value2)
		{
			addCriterion("position_width not between", value1, value2,
					"positionWidth");
			return (Criteria) this;
		}

		public Criteria andPositionHeightIsNull()
		{
			addCriterion("position_height is null");
			return (Criteria) this;
		}

		public Criteria andPositionHeightIsNotNull()
		{
			addCriterion("position_height is not null");
			return (Criteria) this;
		}

		public Criteria andPositionHeightEqualTo(Short value)
		{
			addCriterion("position_height =", value, "positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightNotEqualTo(Short value)
		{
			addCriterion("position_height <>", value, "positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightGreaterThan(Short value)
		{
			addCriterion("position_height >", value, "positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightGreaterThanOrEqualTo(Short value)
		{
			addCriterion("position_height >=", value, "positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightLessThan(Short value)
		{
			addCriterion("position_height <", value, "positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightLessThanOrEqualTo(Short value)
		{
			addCriterion("position_height <=", value, "positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightIn(List<Short> values)
		{
			addCriterion("position_height in", values, "positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightNotIn(List<Short> values)
		{
			addCriterion("position_height not in", values, "positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightBetween(Short value1, Short value2)
		{
			addCriterion("position_height between", value1, value2,
					"positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionHeightNotBetween(Short value1, Short value2)
		{
			addCriterion("position_height not between", value1, value2,
					"positionHeight");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionIsNull()
		{
			addCriterion("position_description is null");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionIsNotNull()
		{
			addCriterion("position_description is not null");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionEqualTo(String value)
		{
			addCriterion("position_description =", value, "positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionNotEqualTo(String value)
		{
			addCriterion("position_description <>", value,
					"positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionGreaterThan(String value)
		{
			addCriterion("position_description >", value, "positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionGreaterThanOrEqualTo(String value)
		{
			addCriterion("position_description >=", value,
					"positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionLessThan(String value)
		{
			addCriterion("position_description <", value, "positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionLessThanOrEqualTo(String value)
		{
			addCriterion("position_description <=", value,
					"positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionLike(String value)
		{
			addCriterion("position_description like", value,
					"positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionNotLike(String value)
		{
			addCriterion("position_description not like", value,
					"positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionIn(List<String> values)
		{
			addCriterion("position_description in", values,
					"positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionNotIn(List<String> values)
		{
			addCriterion("position_description not in", values,
					"positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionBetween(String value1,
				String value2)
		{
			addCriterion("position_description between", value1, value2,
					"positionDescription");
			return (Criteria) this;
		}

		public Criteria andPositionDescriptionNotBetween(String value1,
				String value2)
		{
			addCriterion("position_description not between", value1, value2,
					"positionDescription");
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