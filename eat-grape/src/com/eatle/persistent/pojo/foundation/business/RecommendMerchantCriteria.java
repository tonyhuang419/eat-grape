package com.eatle.persistent.pojo.foundation.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecommendMerchantCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public RecommendMerchantCriteria()
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

	public RecommendMerchantCriteria(int pageSize, int startIndex)
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

		public Criteria andShopNameIsNull()
		{
			addCriterion("shop_name is null");
			return (Criteria) this;
		}

		public Criteria andShopNameIsNotNull()
		{
			addCriterion("shop_name is not null");
			return (Criteria) this;
		}

		public Criteria andShopNameEqualTo(String value)
		{
			addCriterion("shop_name =", value, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameNotEqualTo(String value)
		{
			addCriterion("shop_name <>", value, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameGreaterThan(String value)
		{
			addCriterion("shop_name >", value, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("shop_name >=", value, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameLessThan(String value)
		{
			addCriterion("shop_name <", value, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameLessThanOrEqualTo(String value)
		{
			addCriterion("shop_name <=", value, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameLike(String value)
		{
			addCriterion("shop_name like", value, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameNotLike(String value)
		{
			addCriterion("shop_name not like", value, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameIn(List<String> values)
		{
			addCriterion("shop_name in", values, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameNotIn(List<String> values)
		{
			addCriterion("shop_name not in", values, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameBetween(String value1, String value2)
		{
			addCriterion("shop_name between", value1, value2, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopNameNotBetween(String value1, String value2)
		{
			addCriterion("shop_name not between", value1, value2, "shopName");
			return (Criteria) this;
		}

		public Criteria andShopTelIsNull()
		{
			addCriterion("shop_tel is null");
			return (Criteria) this;
		}

		public Criteria andShopTelIsNotNull()
		{
			addCriterion("shop_tel is not null");
			return (Criteria) this;
		}

		public Criteria andShopTelEqualTo(String value)
		{
			addCriterion("shop_tel =", value, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelNotEqualTo(String value)
		{
			addCriterion("shop_tel <>", value, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelGreaterThan(String value)
		{
			addCriterion("shop_tel >", value, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelGreaterThanOrEqualTo(String value)
		{
			addCriterion("shop_tel >=", value, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelLessThan(String value)
		{
			addCriterion("shop_tel <", value, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelLessThanOrEqualTo(String value)
		{
			addCriterion("shop_tel <=", value, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelLike(String value)
		{
			addCriterion("shop_tel like", value, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelNotLike(String value)
		{
			addCriterion("shop_tel not like", value, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelIn(List<String> values)
		{
			addCriterion("shop_tel in", values, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelNotIn(List<String> values)
		{
			addCriterion("shop_tel not in", values, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelBetween(String value1, String value2)
		{
			addCriterion("shop_tel between", value1, value2, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopTelNotBetween(String value1, String value2)
		{
			addCriterion("shop_tel not between", value1, value2, "shopTel");
			return (Criteria) this;
		}

		public Criteria andShopAddrIsNull()
		{
			addCriterion("shop_addr is null");
			return (Criteria) this;
		}

		public Criteria andShopAddrIsNotNull()
		{
			addCriterion("shop_addr is not null");
			return (Criteria) this;
		}

		public Criteria andShopAddrEqualTo(String value)
		{
			addCriterion("shop_addr =", value, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrNotEqualTo(String value)
		{
			addCriterion("shop_addr <>", value, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrGreaterThan(String value)
		{
			addCriterion("shop_addr >", value, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrGreaterThanOrEqualTo(String value)
		{
			addCriterion("shop_addr >=", value, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrLessThan(String value)
		{
			addCriterion("shop_addr <", value, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrLessThanOrEqualTo(String value)
		{
			addCriterion("shop_addr <=", value, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrLike(String value)
		{
			addCriterion("shop_addr like", value, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrNotLike(String value)
		{
			addCriterion("shop_addr not like", value, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrIn(List<String> values)
		{
			addCriterion("shop_addr in", values, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrNotIn(List<String> values)
		{
			addCriterion("shop_addr not in", values, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrBetween(String value1, String value2)
		{
			addCriterion("shop_addr between", value1, value2, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andShopAddrNotBetween(String value1, String value2)
		{
			addCriterion("shop_addr not between", value1, value2, "shopAddr");
			return (Criteria) this;
		}

		public Criteria andSubTimeIsNull()
		{
			addCriterion("sub_time is null");
			return (Criteria) this;
		}

		public Criteria andSubTimeIsNotNull()
		{
			addCriterion("sub_time is not null");
			return (Criteria) this;
		}

		public Criteria andSubTimeEqualTo(Date value)
		{
			addCriterion("sub_time =", value, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeNotEqualTo(Date value)
		{
			addCriterion("sub_time <>", value, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeGreaterThan(Date value)
		{
			addCriterion("sub_time >", value, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("sub_time >=", value, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeLessThan(Date value)
		{
			addCriterion("sub_time <", value, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("sub_time <=", value, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeIn(List<Date> values)
		{
			addCriterion("sub_time in", values, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeNotIn(List<Date> values)
		{
			addCriterion("sub_time not in", values, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeBetween(Date value1, Date value2)
		{
			addCriterion("sub_time between", value1, value2, "subTime");
			return (Criteria) this;
		}

		public Criteria andSubTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("sub_time not between", value1, value2, "subTime");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNull()
		{
			addCriterion("customer_id is null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNotNull()
		{
			addCriterion("customer_id is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdEqualTo(Long value)
		{
			addCriterion("customer_id =", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotEqualTo(Long value)
		{
			addCriterion("customer_id <>", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThan(Long value)
		{
			addCriterion("customer_id >", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("customer_id >=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThan(Long value)
		{
			addCriterion("customer_id <", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThanOrEqualTo(Long value)
		{
			addCriterion("customer_id <=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIn(List<Long> values)
		{
			addCriterion("customer_id in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotIn(List<Long> values)
		{
			addCriterion("customer_id not in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdBetween(Long value1, Long value2)
		{
			addCriterion("customer_id between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotBetween(Long value1, Long value2)
		{
			addCriterion("customer_id not between", value1, value2,
					"customerId");
			return (Criteria) this;
		}

		public Criteria andHandleStatusIsNull()
		{
			addCriterion("handle_status is null");
			return (Criteria) this;
		}

		public Criteria andHandleStatusIsNotNull()
		{
			addCriterion("handle_status is not null");
			return (Criteria) this;
		}

		public Criteria andHandleStatusEqualTo(Short value)
		{
			addCriterion("handle_status =", value, "handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusNotEqualTo(Short value)
		{
			addCriterion("handle_status <>", value, "handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusGreaterThan(Short value)
		{
			addCriterion("handle_status >", value, "handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusGreaterThanOrEqualTo(Short value)
		{
			addCriterion("handle_status >=", value, "handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusLessThan(Short value)
		{
			addCriterion("handle_status <", value, "handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusLessThanOrEqualTo(Short value)
		{
			addCriterion("handle_status <=", value, "handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusIn(List<Short> values)
		{
			addCriterion("handle_status in", values, "handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusNotIn(List<Short> values)
		{
			addCriterion("handle_status not in", values, "handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusBetween(Short value1, Short value2)
		{
			addCriterion("handle_status between", value1, value2,
					"handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleStatusNotBetween(Short value1, Short value2)
		{
			addCriterion("handle_status not between", value1, value2,
					"handleStatus");
			return (Criteria) this;
		}

		public Criteria andHandleTimeIsNull()
		{
			addCriterion("handle_time is null");
			return (Criteria) this;
		}

		public Criteria andHandleTimeIsNotNull()
		{
			addCriterion("handle_time is not null");
			return (Criteria) this;
		}

		public Criteria andHandleTimeEqualTo(Date value)
		{
			addCriterion("handle_time =", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeNotEqualTo(Date value)
		{
			addCriterion("handle_time <>", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeGreaterThan(Date value)
		{
			addCriterion("handle_time >", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("handle_time >=", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeLessThan(Date value)
		{
			addCriterion("handle_time <", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("handle_time <=", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeIn(List<Date> values)
		{
			addCriterion("handle_time in", values, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeNotIn(List<Date> values)
		{
			addCriterion("handle_time not in", values, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeBetween(Date value1, Date value2)
		{
			addCriterion("handle_time between", value1, value2, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("handle_time not between", value1, value2,
					"handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkIsNull()
		{
			addCriterion("handle_remark is null");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkIsNotNull()
		{
			addCriterion("handle_remark is not null");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkEqualTo(String value)
		{
			addCriterion("handle_remark =", value, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkNotEqualTo(String value)
		{
			addCriterion("handle_remark <>", value, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkGreaterThan(String value)
		{
			addCriterion("handle_remark >", value, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkGreaterThanOrEqualTo(String value)
		{
			addCriterion("handle_remark >=", value, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkLessThan(String value)
		{
			addCriterion("handle_remark <", value, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkLessThanOrEqualTo(String value)
		{
			addCriterion("handle_remark <=", value, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkLike(String value)
		{
			addCriterion("handle_remark like", value, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkNotLike(String value)
		{
			addCriterion("handle_remark not like", value, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkIn(List<String> values)
		{
			addCriterion("handle_remark in", values, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkNotIn(List<String> values)
		{
			addCriterion("handle_remark not in", values, "handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkBetween(String value1, String value2)
		{
			addCriterion("handle_remark between", value1, value2,
					"handleRemark");
			return (Criteria) this;
		}

		public Criteria andHandleRemarkNotBetween(String value1, String value2)
		{
			addCriterion("handle_remark not between", value1, value2,
					"handleRemark");
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