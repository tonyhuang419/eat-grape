package com.eatle.persistent.pojo.foundation.scoreshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConvertRecordsCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public ConvertRecordsCriteria()
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

	public ConvertRecordsCriteria(int pageSize, int startIndex)
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

		public Criteria andGoodsIdIsNull()
		{
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNotNull()
		{
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdEqualTo(Long value)
		{
			addCriterion("goods_id =", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotEqualTo(Long value)
		{
			addCriterion("goods_id <>", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThan(Long value)
		{
			addCriterion("goods_id >", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("goods_id >=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThan(Long value)
		{
			addCriterion("goods_id <", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThanOrEqualTo(Long value)
		{
			addCriterion("goods_id <=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIn(List<Long> values)
		{
			addCriterion("goods_id in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotIn(List<Long> values)
		{
			addCriterion("goods_id not in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdBetween(Long value1, Long value2)
		{
			addCriterion("goods_id between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotBetween(Long value1, Long value2)
		{
			addCriterion("goods_id not between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andConvertCountIsNull()
		{
			addCriterion("convert_count is null");
			return (Criteria) this;
		}

		public Criteria andConvertCountIsNotNull()
		{
			addCriterion("convert_count is not null");
			return (Criteria) this;
		}

		public Criteria andConvertCountEqualTo(Integer value)
		{
			addCriterion("convert_count =", value, "convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountNotEqualTo(Integer value)
		{
			addCriterion("convert_count <>", value, "convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountGreaterThan(Integer value)
		{
			addCriterion("convert_count >", value, "convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("convert_count >=", value, "convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountLessThan(Integer value)
		{
			addCriterion("convert_count <", value, "convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountLessThanOrEqualTo(Integer value)
		{
			addCriterion("convert_count <=", value, "convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountIn(List<Integer> values)
		{
			addCriterion("convert_count in", values, "convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountNotIn(List<Integer> values)
		{
			addCriterion("convert_count not in", values, "convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountBetween(Integer value1, Integer value2)
		{
			addCriterion("convert_count between", value1, value2,
					"convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertCountNotBetween(Integer value1, Integer value2)
		{
			addCriterion("convert_count not between", value1, value2,
					"convertCount");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIsNull()
		{
			addCriterion("convert_time is null");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIsNotNull()
		{
			addCriterion("convert_time is not null");
			return (Criteria) this;
		}

		public Criteria andConvertTimeEqualTo(Date value)
		{
			addCriterion("convert_time =", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotEqualTo(Date value)
		{
			addCriterion("convert_time <>", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeGreaterThan(Date value)
		{
			addCriterion("convert_time >", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("convert_time >=", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeLessThan(Date value)
		{
			addCriterion("convert_time <", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("convert_time <=", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIn(List<Date> values)
		{
			addCriterion("convert_time in", values, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotIn(List<Date> values)
		{
			addCriterion("convert_time not in", values, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeBetween(Date value1, Date value2)
		{
			addCriterion("convert_time between", value1, value2, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("convert_time not between", value1, value2,
					"convertTime");
			return (Criteria) this;
		}

		public Criteria andCostScoreIsNull()
		{
			addCriterion("cost_score is null");
			return (Criteria) this;
		}

		public Criteria andCostScoreIsNotNull()
		{
			addCriterion("cost_score is not null");
			return (Criteria) this;
		}

		public Criteria andCostScoreEqualTo(Integer value)
		{
			addCriterion("cost_score =", value, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreNotEqualTo(Integer value)
		{
			addCriterion("cost_score <>", value, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreGreaterThan(Integer value)
		{
			addCriterion("cost_score >", value, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("cost_score >=", value, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreLessThan(Integer value)
		{
			addCriterion("cost_score <", value, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreLessThanOrEqualTo(Integer value)
		{
			addCriterion("cost_score <=", value, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreIn(List<Integer> values)
		{
			addCriterion("cost_score in", values, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreNotIn(List<Integer> values)
		{
			addCriterion("cost_score not in", values, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreBetween(Integer value1, Integer value2)
		{
			addCriterion("cost_score between", value1, value2, "costScore");
			return (Criteria) this;
		}

		public Criteria andCostScoreNotBetween(Integer value1, Integer value2)
		{
			addCriterion("cost_score not between", value1, value2, "costScore");
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