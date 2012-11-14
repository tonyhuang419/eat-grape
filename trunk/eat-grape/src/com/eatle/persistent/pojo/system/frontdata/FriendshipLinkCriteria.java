package com.eatle.persistent.pojo.system.frontdata;

import java.util.ArrayList;
import java.util.List;

public class FriendshipLinkCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public FriendshipLinkCriteria()
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

	public FriendshipLinkCriteria(int pageSize, int startIndex)
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

		public Criteria andLinkNameIsNull()
		{
			addCriterion("link_name is null");
			return (Criteria) this;
		}

		public Criteria andLinkNameIsNotNull()
		{
			addCriterion("link_name is not null");
			return (Criteria) this;
		}

		public Criteria andLinkNameEqualTo(String value)
		{
			addCriterion("link_name =", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameNotEqualTo(String value)
		{
			addCriterion("link_name <>", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameGreaterThan(String value)
		{
			addCriterion("link_name >", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("link_name >=", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameLessThan(String value)
		{
			addCriterion("link_name <", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameLessThanOrEqualTo(String value)
		{
			addCriterion("link_name <=", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameLike(String value)
		{
			addCriterion("link_name like", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameNotLike(String value)
		{
			addCriterion("link_name not like", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameIn(List<String> values)
		{
			addCriterion("link_name in", values, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameNotIn(List<String> values)
		{
			addCriterion("link_name not in", values, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameBetween(String value1, String value2)
		{
			addCriterion("link_name between", value1, value2, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameNotBetween(String value1, String value2)
		{
			addCriterion("link_name not between", value1, value2, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIsNull()
		{
			addCriterion("link_url is null");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIsNotNull()
		{
			addCriterion("link_url is not null");
			return (Criteria) this;
		}

		public Criteria andLinkUrlEqualTo(String value)
		{
			addCriterion("link_url =", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotEqualTo(String value)
		{
			addCriterion("link_url <>", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlGreaterThan(String value)
		{
			addCriterion("link_url >", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlGreaterThanOrEqualTo(String value)
		{
			addCriterion("link_url >=", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLessThan(String value)
		{
			addCriterion("link_url <", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLessThanOrEqualTo(String value)
		{
			addCriterion("link_url <=", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLike(String value)
		{
			addCriterion("link_url like", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotLike(String value)
		{
			addCriterion("link_url not like", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIn(List<String> values)
		{
			addCriterion("link_url in", values, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotIn(List<String> values)
		{
			addCriterion("link_url not in", values, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlBetween(String value1, String value2)
		{
			addCriterion("link_url between", value1, value2, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotBetween(String value1, String value2)
		{
			addCriterion("link_url not between", value1, value2, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlIsNull()
		{
			addCriterion("logo_url is null");
			return (Criteria) this;
		}

		public Criteria andLogoUrlIsNotNull()
		{
			addCriterion("logo_url is not null");
			return (Criteria) this;
		}

		public Criteria andLogoUrlEqualTo(String value)
		{
			addCriterion("logo_url =", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlNotEqualTo(String value)
		{
			addCriterion("logo_url <>", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlGreaterThan(String value)
		{
			addCriterion("logo_url >", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlGreaterThanOrEqualTo(String value)
		{
			addCriterion("logo_url >=", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlLessThan(String value)
		{
			addCriterion("logo_url <", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlLessThanOrEqualTo(String value)
		{
			addCriterion("logo_url <=", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlLike(String value)
		{
			addCriterion("logo_url like", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlNotLike(String value)
		{
			addCriterion("logo_url not like", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlIn(List<String> values)
		{
			addCriterion("logo_url in", values, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlNotIn(List<String> values)
		{
			addCriterion("logo_url not in", values, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlBetween(String value1, String value2)
		{
			addCriterion("logo_url between", value1, value2, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlNotBetween(String value1, String value2)
		{
			addCriterion("logo_url not between", value1, value2, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andSortOrderIsNull()
		{
			addCriterion("sort_order is null");
			return (Criteria) this;
		}

		public Criteria andSortOrderIsNotNull()
		{
			addCriterion("sort_order is not null");
			return (Criteria) this;
		}

		public Criteria andSortOrderEqualTo(Short value)
		{
			addCriterion("sort_order =", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotEqualTo(Short value)
		{
			addCriterion("sort_order <>", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderGreaterThan(Short value)
		{
			addCriterion("sort_order >", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderGreaterThanOrEqualTo(Short value)
		{
			addCriterion("sort_order >=", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderLessThan(Short value)
		{
			addCriterion("sort_order <", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderLessThanOrEqualTo(Short value)
		{
			addCriterion("sort_order <=", value, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderIn(List<Short> values)
		{
			addCriterion("sort_order in", values, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotIn(List<Short> values)
		{
			addCriterion("sort_order not in", values, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderBetween(Short value1, Short value2)
		{
			addCriterion("sort_order between", value1, value2, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andSortOrderNotBetween(Short value1, Short value2)
		{
			addCriterion("sort_order not between", value1, value2, "sortOrder");
			return (Criteria) this;
		}

		public Criteria andIsDisplayIsNull()
		{
			addCriterion("is_display is null");
			return (Criteria) this;
		}

		public Criteria andIsDisplayIsNotNull()
		{
			addCriterion("is_display is not null");
			return (Criteria) this;
		}

		public Criteria andIsDisplayEqualTo(Short value)
		{
			addCriterion("is_display =", value, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayNotEqualTo(Short value)
		{
			addCriterion("is_display <>", value, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayGreaterThan(Short value)
		{
			addCriterion("is_display >", value, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayGreaterThanOrEqualTo(Short value)
		{
			addCriterion("is_display >=", value, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayLessThan(Short value)
		{
			addCriterion("is_display <", value, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayLessThanOrEqualTo(Short value)
		{
			addCriterion("is_display <=", value, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayIn(List<Short> values)
		{
			addCriterion("is_display in", values, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayNotIn(List<Short> values)
		{
			addCriterion("is_display not in", values, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayBetween(Short value1, Short value2)
		{
			addCriterion("is_display between", value1, value2, "isDisplay");
			return (Criteria) this;
		}

		public Criteria andIsDisplayNotBetween(Short value1, Short value2)
		{
			addCriterion("is_display not between", value1, value2, "isDisplay");
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