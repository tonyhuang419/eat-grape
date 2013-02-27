package com.eatle.persistent.pojo.merchant;

import java.util.ArrayList;
import java.util.List;

public class UserMerchantCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public UserMerchantCriteria()
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

	public UserMerchantCriteria(int pageSize, int startIndex)
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

		public Criteria andUserIdIsNull()
		{
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull()
		{
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value)
		{
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value)
		{
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value)
		{
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value)
		{
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value)
		{
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values)
		{
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values)
		{
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2)
		{
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2)
		{
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdIsNull()
		{
			addCriterion("merchant_id is null");
			return (Criteria) this;
		}

		public Criteria andMerchantIdIsNotNull()
		{
			addCriterion("merchant_id is not null");
			return (Criteria) this;
		}

		public Criteria andMerchantIdEqualTo(Long value)
		{
			addCriterion("merchant_id =", value, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdNotEqualTo(Long value)
		{
			addCriterion("merchant_id <>", value, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdGreaterThan(Long value)
		{
			addCriterion("merchant_id >", value, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("merchant_id >=", value, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdLessThan(Long value)
		{
			addCriterion("merchant_id <", value, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdLessThanOrEqualTo(Long value)
		{
			addCriterion("merchant_id <=", value, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdIn(List<Long> values)
		{
			addCriterion("merchant_id in", values, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdNotIn(List<Long> values)
		{
			addCriterion("merchant_id not in", values, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdBetween(Long value1, Long value2)
		{
			addCriterion("merchant_id between", value1, value2, "merchantId");
			return (Criteria) this;
		}

		public Criteria andMerchantIdNotBetween(Long value1, Long value2)
		{
			addCriterion("merchant_id not between", value1, value2,
					"merchantId");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListIsNull()
		{
			addCriterion("manage_restaurant_list is null");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListIsNotNull()
		{
			addCriterion("manage_restaurant_list is not null");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListEqualTo(String value)
		{
			addCriterion("manage_restaurant_list =", value,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListNotEqualTo(String value)
		{
			addCriterion("manage_restaurant_list <>", value,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListGreaterThan(String value)
		{
			addCriterion("manage_restaurant_list >", value,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListGreaterThanOrEqualTo(String value)
		{
			addCriterion("manage_restaurant_list >=", value,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListLessThan(String value)
		{
			addCriterion("manage_restaurant_list <", value,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListLessThanOrEqualTo(String value)
		{
			addCriterion("manage_restaurant_list <=", value,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListLike(String value)
		{
			addCriterion("manage_restaurant_list like", value,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListNotLike(String value)
		{
			addCriterion("manage_restaurant_list not like", value,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListIn(List<String> values)
		{
			addCriterion("manage_restaurant_list in", values,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListNotIn(List<String> values)
		{
			addCriterion("manage_restaurant_list not in", values,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListBetween(String value1,
				String value2)
		{
			addCriterion("manage_restaurant_list between", value1, value2,
					"manageRestaurantList");
			return (Criteria) this;
		}

		public Criteria andManageRestaurantListNotBetween(String value1,
				String value2)
		{
			addCriterion("manage_restaurant_list not between", value1, value2,
					"manageRestaurantList");
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