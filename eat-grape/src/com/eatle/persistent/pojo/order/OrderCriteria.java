package com.eatle.persistent.pojo.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public OrderCriteria()
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

	public OrderCriteria(int pageSize, int startIndex)
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

		protected void addCriterionForJDBCTime(String condition, Date value,
				String property)
		{
			if (value == null)
			{
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value.getTime()),
					property);
		}

		protected void addCriterionForJDBCTime(String condition,
				List<Date> values, String property)
		{
			if (values == null || values.size() == 0)
			{
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext())
			{
				timeList.add(new java.sql.Time(iter.next().getTime()));
			}
			addCriterion(condition, timeList, property);
		}

		protected void addCriterionForJDBCTime(String condition, Date value1,
				Date value2, String property)
		{
			if (value1 == null || value2 == null)
			{
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value1.getTime()),
					new java.sql.Time(value2.getTime()), property);
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

		public Criteria andOrderNumIsNull()
		{
			addCriterion("order_num is null");
			return (Criteria) this;
		}

		public Criteria andOrderNumIsNotNull()
		{
			addCriterion("order_num is not null");
			return (Criteria) this;
		}

		public Criteria andOrderNumEqualTo(String value)
		{
			addCriterion("order_num =", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumNotEqualTo(String value)
		{
			addCriterion("order_num <>", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumGreaterThan(String value)
		{
			addCriterion("order_num >", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumGreaterThanOrEqualTo(String value)
		{
			addCriterion("order_num >=", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumLessThan(String value)
		{
			addCriterion("order_num <", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumLessThanOrEqualTo(String value)
		{
			addCriterion("order_num <=", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumLike(String value)
		{
			addCriterion("order_num like", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumNotLike(String value)
		{
			addCriterion("order_num not like", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumIn(List<String> values)
		{
			addCriterion("order_num in", values, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumNotIn(List<String> values)
		{
			addCriterion("order_num not in", values, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumBetween(String value1, String value2)
		{
			addCriterion("order_num between", value1, value2, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumNotBetween(String value1, String value2)
		{
			addCriterion("order_num not between", value1, value2, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderTimeIsNull()
		{
			addCriterion("order_time is null");
			return (Criteria) this;
		}

		public Criteria andOrderTimeIsNotNull()
		{
			addCriterion("order_time is not null");
			return (Criteria) this;
		}

		public Criteria andOrderTimeEqualTo(Date value)
		{
			addCriterion("order_time =", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeNotEqualTo(Date value)
		{
			addCriterion("order_time <>", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeGreaterThan(Date value)
		{
			addCriterion("order_time >", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("order_time >=", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeLessThan(Date value)
		{
			addCriterion("order_time <", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("order_time <=", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeIn(List<Date> values)
		{
			addCriterion("order_time in", values, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeNotIn(List<Date> values)
		{
			addCriterion("order_time not in", values, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeBetween(Date value1, Date value2)
		{
			addCriterion("order_time between", value1, value2, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("order_time not between", value1, value2, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIsNull()
		{
			addCriterion("order_status is null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIsNotNull()
		{
			addCriterion("order_status is not null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusEqualTo(Integer value)
		{
			addCriterion("order_status =", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotEqualTo(Integer value)
		{
			addCriterion("order_status <>", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusGreaterThan(Integer value)
		{
			addCriterion("order_status >", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("order_status >=", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusLessThan(Integer value)
		{
			addCriterion("order_status <", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusLessThanOrEqualTo(Integer value)
		{
			addCriterion("order_status <=", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIn(List<Integer> values)
		{
			addCriterion("order_status in", values, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotIn(List<Integer> values)
		{
			addCriterion("order_status not in", values, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusBetween(Integer value1, Integer value2)
		{
			addCriterion("order_status between", value1, value2, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotBetween(Integer value1, Integer value2)
		{
			addCriterion("order_status not between", value1, value2,
					"orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionIsNull()
		{
			addCriterion("order_status_description is null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionIsNotNull()
		{
			addCriterion("order_status_description is not null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionEqualTo(String value)
		{
			addCriterion("order_status_description =", value,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionNotEqualTo(String value)
		{
			addCriterion("order_status_description <>", value,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionGreaterThan(String value)
		{
			addCriterion("order_status_description >", value,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionGreaterThanOrEqualTo(
				String value)
		{
			addCriterion("order_status_description >=", value,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionLessThan(String value)
		{
			addCriterion("order_status_description <", value,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionLessThanOrEqualTo(String value)
		{
			addCriterion("order_status_description <=", value,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionLike(String value)
		{
			addCriterion("order_status_description like", value,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionNotLike(String value)
		{
			addCriterion("order_status_description not like", value,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionIn(List<String> values)
		{
			addCriterion("order_status_description in", values,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionNotIn(List<String> values)
		{
			addCriterion("order_status_description not in", values,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionBetween(String value1,
				String value2)
		{
			addCriterion("order_status_description between", value1, value2,
					"orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderStatusDescriptionNotBetween(String value1,
				String value2)
		{
			addCriterion("order_status_description not between", value1,
					value2, "orderStatusDescription");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountIsNull()
		{
			addCriterion("order_discount is null");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountIsNotNull()
		{
			addCriterion("order_discount is not null");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountEqualTo(Float value)
		{
			addCriterion("order_discount =", value, "orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountNotEqualTo(Float value)
		{
			addCriterion("order_discount <>", value, "orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountGreaterThan(Float value)
		{
			addCriterion("order_discount >", value, "orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountGreaterThanOrEqualTo(Float value)
		{
			addCriterion("order_discount >=", value, "orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountLessThan(Float value)
		{
			addCriterion("order_discount <", value, "orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountLessThanOrEqualTo(Float value)
		{
			addCriterion("order_discount <=", value, "orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountIn(List<Float> values)
		{
			addCriterion("order_discount in", values, "orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountNotIn(List<Float> values)
		{
			addCriterion("order_discount not in", values, "orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountBetween(Float value1, Float value2)
		{
			addCriterion("order_discount between", value1, value2,
					"orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderDiscountNotBetween(Float value1, Float value2)
		{
			addCriterion("order_discount not between", value1, value2,
					"orderDiscount");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyIsNull()
		{
			addCriterion("order_total_money is null");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyIsNotNull()
		{
			addCriterion("order_total_money is not null");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyEqualTo(Float value)
		{
			addCriterion("order_total_money =", value, "orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyNotEqualTo(Float value)
		{
			addCriterion("order_total_money <>", value, "orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyGreaterThan(Float value)
		{
			addCriterion("order_total_money >", value, "orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyGreaterThanOrEqualTo(Float value)
		{
			addCriterion("order_total_money >=", value, "orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyLessThan(Float value)
		{
			addCriterion("order_total_money <", value, "orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyLessThanOrEqualTo(Float value)
		{
			addCriterion("order_total_money <=", value, "orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyIn(List<Float> values)
		{
			addCriterion("order_total_money in", values, "orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyNotIn(List<Float> values)
		{
			addCriterion("order_total_money not in", values, "orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyBetween(Float value1, Float value2)
		{
			addCriterion("order_total_money between", value1, value2,
					"orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andOrderTotalMoneyNotBetween(Float value1, Float value2)
		{
			addCriterion("order_total_money not between", value1, value2,
					"orderTotalMoney");
			return (Criteria) this;
		}

		public Criteria andSendAddressIsNull()
		{
			addCriterion("send_address is null");
			return (Criteria) this;
		}

		public Criteria andSendAddressIsNotNull()
		{
			addCriterion("send_address is not null");
			return (Criteria) this;
		}

		public Criteria andSendAddressEqualTo(String value)
		{
			addCriterion("send_address =", value, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressNotEqualTo(String value)
		{
			addCriterion("send_address <>", value, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressGreaterThan(String value)
		{
			addCriterion("send_address >", value, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressGreaterThanOrEqualTo(String value)
		{
			addCriterion("send_address >=", value, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressLessThan(String value)
		{
			addCriterion("send_address <", value, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressLessThanOrEqualTo(String value)
		{
			addCriterion("send_address <=", value, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressLike(String value)
		{
			addCriterion("send_address like", value, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressNotLike(String value)
		{
			addCriterion("send_address not like", value, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressIn(List<String> values)
		{
			addCriterion("send_address in", values, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressNotIn(List<String> values)
		{
			addCriterion("send_address not in", values, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressBetween(String value1, String value2)
		{
			addCriterion("send_address between", value1, value2, "sendAddress");
			return (Criteria) this;
		}

		public Criteria andSendAddressNotBetween(String value1, String value2)
		{
			addCriterion("send_address not between", value1, value2,
					"sendAddress");
			return (Criteria) this;
		}

		public Criteria andContactNameIsNull()
		{
			addCriterion("contact_name is null");
			return (Criteria) this;
		}

		public Criteria andContactNameIsNotNull()
		{
			addCriterion("contact_name is not null");
			return (Criteria) this;
		}

		public Criteria andContactNameEqualTo(String value)
		{
			addCriterion("contact_name =", value, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameNotEqualTo(String value)
		{
			addCriterion("contact_name <>", value, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameGreaterThan(String value)
		{
			addCriterion("contact_name >", value, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("contact_name >=", value, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameLessThan(String value)
		{
			addCriterion("contact_name <", value, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameLessThanOrEqualTo(String value)
		{
			addCriterion("contact_name <=", value, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameLike(String value)
		{
			addCriterion("contact_name like", value, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameNotLike(String value)
		{
			addCriterion("contact_name not like", value, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameIn(List<String> values)
		{
			addCriterion("contact_name in", values, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameNotIn(List<String> values)
		{
			addCriterion("contact_name not in", values, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameBetween(String value1, String value2)
		{
			addCriterion("contact_name between", value1, value2, "contactName");
			return (Criteria) this;
		}

		public Criteria andContactNameNotBetween(String value1, String value2)
		{
			addCriterion("contact_name not between", value1, value2,
					"contactName");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIsNull()
		{
			addCriterion("contact_phone is null");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIsNotNull()
		{
			addCriterion("contact_phone is not null");
			return (Criteria) this;
		}

		public Criteria andContactPhoneEqualTo(String value)
		{
			addCriterion("contact_phone =", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotEqualTo(String value)
		{
			addCriterion("contact_phone <>", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneGreaterThan(String value)
		{
			addCriterion("contact_phone >", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneGreaterThanOrEqualTo(String value)
		{
			addCriterion("contact_phone >=", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLessThan(String value)
		{
			addCriterion("contact_phone <", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLessThanOrEqualTo(String value)
		{
			addCriterion("contact_phone <=", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLike(String value)
		{
			addCriterion("contact_phone like", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotLike(String value)
		{
			addCriterion("contact_phone not like", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIn(List<String> values)
		{
			addCriterion("contact_phone in", values, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotIn(List<String> values)
		{
			addCriterion("contact_phone not in", values, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneBetween(String value1, String value2)
		{
			addCriterion("contact_phone between", value1, value2,
					"contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotBetween(String value1, String value2)
		{
			addCriterion("contact_phone not between", value1, value2,
					"contactPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneIsNull()
		{
			addCriterion("another_phone is null");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneIsNotNull()
		{
			addCriterion("another_phone is not null");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneEqualTo(String value)
		{
			addCriterion("another_phone =", value, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneNotEqualTo(String value)
		{
			addCriterion("another_phone <>", value, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneGreaterThan(String value)
		{
			addCriterion("another_phone >", value, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneGreaterThanOrEqualTo(String value)
		{
			addCriterion("another_phone >=", value, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneLessThan(String value)
		{
			addCriterion("another_phone <", value, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneLessThanOrEqualTo(String value)
		{
			addCriterion("another_phone <=", value, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneLike(String value)
		{
			addCriterion("another_phone like", value, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneNotLike(String value)
		{
			addCriterion("another_phone not like", value, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneIn(List<String> values)
		{
			addCriterion("another_phone in", values, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneNotIn(List<String> values)
		{
			addCriterion("another_phone not in", values, "anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneBetween(String value1, String value2)
		{
			addCriterion("another_phone between", value1, value2,
					"anotherPhone");
			return (Criteria) this;
		}

		public Criteria andAnotherPhoneNotBetween(String value1, String value2)
		{
			addCriterion("another_phone not between", value1, value2,
					"anotherPhone");
			return (Criteria) this;
		}

		public Criteria andSendRemarkIsNull()
		{
			addCriterion("send_remark is null");
			return (Criteria) this;
		}

		public Criteria andSendRemarkIsNotNull()
		{
			addCriterion("send_remark is not null");
			return (Criteria) this;
		}

		public Criteria andSendRemarkEqualTo(String value)
		{
			addCriterion("send_remark =", value, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkNotEqualTo(String value)
		{
			addCriterion("send_remark <>", value, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkGreaterThan(String value)
		{
			addCriterion("send_remark >", value, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkGreaterThanOrEqualTo(String value)
		{
			addCriterion("send_remark >=", value, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkLessThan(String value)
		{
			addCriterion("send_remark <", value, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkLessThanOrEqualTo(String value)
		{
			addCriterion("send_remark <=", value, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkLike(String value)
		{
			addCriterion("send_remark like", value, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkNotLike(String value)
		{
			addCriterion("send_remark not like", value, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkIn(List<String> values)
		{
			addCriterion("send_remark in", values, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkNotIn(List<String> values)
		{
			addCriterion("send_remark not in", values, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkBetween(String value1, String value2)
		{
			addCriterion("send_remark between", value1, value2, "sendRemark");
			return (Criteria) this;
		}

		public Criteria andSendRemarkNotBetween(String value1, String value2)
		{
			addCriterion("send_remark not between", value1, value2,
					"sendRemark");
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

		public Criteria andRestaurantIdIsNull()
		{
			addCriterion("restaurant_id is null");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdIsNotNull()
		{
			addCriterion("restaurant_id is not null");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdEqualTo(Long value)
		{
			addCriterion("restaurant_id =", value, "restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdNotEqualTo(Long value)
		{
			addCriterion("restaurant_id <>", value, "restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdGreaterThan(Long value)
		{
			addCriterion("restaurant_id >", value, "restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("restaurant_id >=", value, "restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdLessThan(Long value)
		{
			addCriterion("restaurant_id <", value, "restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdLessThanOrEqualTo(Long value)
		{
			addCriterion("restaurant_id <=", value, "restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdIn(List<Long> values)
		{
			addCriterion("restaurant_id in", values, "restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdNotIn(List<Long> values)
		{
			addCriterion("restaurant_id not in", values, "restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdBetween(Long value1, Long value2)
		{
			addCriterion("restaurant_id between", value1, value2,
					"restaurantId");
			return (Criteria) this;
		}

		public Criteria andRestaurantIdNotBetween(Long value1, Long value2)
		{
			addCriterion("restaurant_id not between", value1, value2,
					"restaurantId");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNull()
		{
			addCriterion("send_time is null");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNotNull()
		{
			addCriterion("send_time is not null");
			return (Criteria) this;
		}

		public Criteria andSendTimeEqualTo(Date value)
		{
			addCriterionForJDBCTime("send_time =", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotEqualTo(Date value)
		{
			addCriterionForJDBCTime("send_time <>", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThan(Date value)
		{
			addCriterionForJDBCTime("send_time >", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterionForJDBCTime("send_time >=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThan(Date value)
		{
			addCriterionForJDBCTime("send_time <", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThanOrEqualTo(Date value)
		{
			addCriterionForJDBCTime("send_time <=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeIn(List<Date> values)
		{
			addCriterionForJDBCTime("send_time in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotIn(List<Date> values)
		{
			addCriterionForJDBCTime("send_time not in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeBetween(Date value1, Date value2)
		{
			addCriterionForJDBCTime("send_time between", value1, value2,
					"sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotBetween(Date value1, Date value2)
		{
			addCriterionForJDBCTime("send_time not between", value1, value2,
					"sendTime");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeIsNull()
		{
			addCriterion("notify_type is null");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeIsNotNull()
		{
			addCriterion("notify_type is not null");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeEqualTo(Short value)
		{
			addCriterion("notify_type =", value, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeNotEqualTo(Short value)
		{
			addCriterion("notify_type <>", value, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeGreaterThan(Short value)
		{
			addCriterion("notify_type >", value, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeGreaterThanOrEqualTo(Short value)
		{
			addCriterion("notify_type >=", value, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeLessThan(Short value)
		{
			addCriterion("notify_type <", value, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeLessThanOrEqualTo(Short value)
		{
			addCriterion("notify_type <=", value, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeIn(List<Short> values)
		{
			addCriterion("notify_type in", values, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeNotIn(List<Short> values)
		{
			addCriterion("notify_type not in", values, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeBetween(Short value1, Short value2)
		{
			addCriterion("notify_type between", value1, value2, "notifyType");
			return (Criteria) this;
		}

		public Criteria andNotifyTypeNotBetween(Short value1, Short value2)
		{
			addCriterion("notify_type not between", value1, value2,
					"notifyType");
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