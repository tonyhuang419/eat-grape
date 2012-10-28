package com.eatle.persistent.pojo.foundation.scoreshop;

import java.util.ArrayList;
import java.util.List;

public class ConvertGoodsCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public ConvertGoodsCriteria()
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

	public ConvertGoodsCriteria(int pageSize, int startIndex)
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

		public Criteria andNameIsNull()
		{
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull()
		{
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value)
		{
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value)
		{
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value)
		{
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value)
		{
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value)
		{
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value)
		{
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value)
		{
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values)
		{
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values)
		{
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2)
		{
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2)
		{
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andDescribeIsNull()
		{
			addCriterion("describe is null");
			return (Criteria) this;
		}

		public Criteria andDescribeIsNotNull()
		{
			addCriterion("describe is not null");
			return (Criteria) this;
		}

		public Criteria andDescribeEqualTo(String value)
		{
			addCriterion("describe =", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeNotEqualTo(String value)
		{
			addCriterion("describe <>", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeGreaterThan(String value)
		{
			addCriterion("describe >", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeGreaterThanOrEqualTo(String value)
		{
			addCriterion("describe >=", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeLessThan(String value)
		{
			addCriterion("describe <", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeLessThanOrEqualTo(String value)
		{
			addCriterion("describe <=", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeLike(String value)
		{
			addCriterion("describe like", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeNotLike(String value)
		{
			addCriterion("describe not like", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeIn(List<String> values)
		{
			addCriterion("describe in", values, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeNotIn(List<String> values)
		{
			addCriterion("describe not in", values, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeBetween(String value1, String value2)
		{
			addCriterion("describe between", value1, value2, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeNotBetween(String value1, String value2)
		{
			addCriterion("describe not between", value1, value2, "describe");
			return (Criteria) this;
		}

		public Criteria andPicUrlIsNull()
		{
			addCriterion("pic_url is null");
			return (Criteria) this;
		}

		public Criteria andPicUrlIsNotNull()
		{
			addCriterion("pic_url is not null");
			return (Criteria) this;
		}

		public Criteria andPicUrlEqualTo(String value)
		{
			addCriterion("pic_url =", value, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlNotEqualTo(String value)
		{
			addCriterion("pic_url <>", value, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlGreaterThan(String value)
		{
			addCriterion("pic_url >", value, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlGreaterThanOrEqualTo(String value)
		{
			addCriterion("pic_url >=", value, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlLessThan(String value)
		{
			addCriterion("pic_url <", value, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlLessThanOrEqualTo(String value)
		{
			addCriterion("pic_url <=", value, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlLike(String value)
		{
			addCriterion("pic_url like", value, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlNotLike(String value)
		{
			addCriterion("pic_url not like", value, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlIn(List<String> values)
		{
			addCriterion("pic_url in", values, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlNotIn(List<String> values)
		{
			addCriterion("pic_url not in", values, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlBetween(String value1, String value2)
		{
			addCriterion("pic_url between", value1, value2, "picUrl");
			return (Criteria) this;
		}

		public Criteria andPicUrlNotBetween(String value1, String value2)
		{
			addCriterion("pic_url not between", value1, value2, "picUrl");
			return (Criteria) this;
		}

		public Criteria andTotalIsNull()
		{
			addCriterion("total is null");
			return (Criteria) this;
		}

		public Criteria andTotalIsNotNull()
		{
			addCriterion("total is not null");
			return (Criteria) this;
		}

		public Criteria andTotalEqualTo(Integer value)
		{
			addCriterion("total =", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotEqualTo(Integer value)
		{
			addCriterion("total <>", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThan(Integer value)
		{
			addCriterion("total >", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("total >=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThan(Integer value)
		{
			addCriterion("total <", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThanOrEqualTo(Integer value)
		{
			addCriterion("total <=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalIn(List<Integer> values)
		{
			addCriterion("total in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotIn(List<Integer> values)
		{
			addCriterion("total not in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalBetween(Integer value1, Integer value2)
		{
			addCriterion("total between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotBetween(Integer value1, Integer value2)
		{
			addCriterion("total not between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andSurplusIsNull()
		{
			addCriterion("surplus is null");
			return (Criteria) this;
		}

		public Criteria andSurplusIsNotNull()
		{
			addCriterion("surplus is not null");
			return (Criteria) this;
		}

		public Criteria andSurplusEqualTo(Integer value)
		{
			addCriterion("surplus =", value, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusNotEqualTo(Integer value)
		{
			addCriterion("surplus <>", value, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusGreaterThan(Integer value)
		{
			addCriterion("surplus >", value, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("surplus >=", value, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusLessThan(Integer value)
		{
			addCriterion("surplus <", value, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusLessThanOrEqualTo(Integer value)
		{
			addCriterion("surplus <=", value, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusIn(List<Integer> values)
		{
			addCriterion("surplus in", values, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusNotIn(List<Integer> values)
		{
			addCriterion("surplus not in", values, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusBetween(Integer value1, Integer value2)
		{
			addCriterion("surplus between", value1, value2, "surplus");
			return (Criteria) this;
		}

		public Criteria andSurplusNotBetween(Integer value1, Integer value2)
		{
			addCriterion("surplus not between", value1, value2, "surplus");
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