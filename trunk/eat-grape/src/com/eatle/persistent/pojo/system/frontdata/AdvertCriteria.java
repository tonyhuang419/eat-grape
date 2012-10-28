package com.eatle.persistent.pojo.system.frontdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvertCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public AdvertCriteria()
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

	public AdvertCriteria(int pageSize, int startIndex)
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

		public Criteria andPicWidthIsNull()
		{
			addCriterion("pic_width is null");
			return (Criteria) this;
		}

		public Criteria andPicWidthIsNotNull()
		{
			addCriterion("pic_width is not null");
			return (Criteria) this;
		}

		public Criteria andPicWidthEqualTo(Short value)
		{
			addCriterion("pic_width =", value, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthNotEqualTo(Short value)
		{
			addCriterion("pic_width <>", value, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthGreaterThan(Short value)
		{
			addCriterion("pic_width >", value, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthGreaterThanOrEqualTo(Short value)
		{
			addCriterion("pic_width >=", value, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthLessThan(Short value)
		{
			addCriterion("pic_width <", value, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthLessThanOrEqualTo(Short value)
		{
			addCriterion("pic_width <=", value, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthIn(List<Short> values)
		{
			addCriterion("pic_width in", values, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthNotIn(List<Short> values)
		{
			addCriterion("pic_width not in", values, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthBetween(Short value1, Short value2)
		{
			addCriterion("pic_width between", value1, value2, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicWidthNotBetween(Short value1, Short value2)
		{
			addCriterion("pic_width not between", value1, value2, "picWidth");
			return (Criteria) this;
		}

		public Criteria andPicHeightIsNull()
		{
			addCriterion("pic_height is null");
			return (Criteria) this;
		}

		public Criteria andPicHeightIsNotNull()
		{
			addCriterion("pic_height is not null");
			return (Criteria) this;
		}

		public Criteria andPicHeightEqualTo(Short value)
		{
			addCriterion("pic_height =", value, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightNotEqualTo(Short value)
		{
			addCriterion("pic_height <>", value, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightGreaterThan(Short value)
		{
			addCriterion("pic_height >", value, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightGreaterThanOrEqualTo(Short value)
		{
			addCriterion("pic_height >=", value, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightLessThan(Short value)
		{
			addCriterion("pic_height <", value, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightLessThanOrEqualTo(Short value)
		{
			addCriterion("pic_height <=", value, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightIn(List<Short> values)
		{
			addCriterion("pic_height in", values, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightNotIn(List<Short> values)
		{
			addCriterion("pic_height not in", values, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightBetween(Short value1, Short value2)
		{
			addCriterion("pic_height between", value1, value2, "picHeight");
			return (Criteria) this;
		}

		public Criteria andPicHeightNotBetween(Short value1, Short value2)
		{
			addCriterion("pic_height not between", value1, value2, "picHeight");
			return (Criteria) this;
		}

		public Criteria andShowTextIsNull()
		{
			addCriterion("show_text is null");
			return (Criteria) this;
		}

		public Criteria andShowTextIsNotNull()
		{
			addCriterion("show_text is not null");
			return (Criteria) this;
		}

		public Criteria andShowTextEqualTo(String value)
		{
			addCriterion("show_text =", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextNotEqualTo(String value)
		{
			addCriterion("show_text <>", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextGreaterThan(String value)
		{
			addCriterion("show_text >", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextGreaterThanOrEqualTo(String value)
		{
			addCriterion("show_text >=", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextLessThan(String value)
		{
			addCriterion("show_text <", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextLessThanOrEqualTo(String value)
		{
			addCriterion("show_text <=", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextLike(String value)
		{
			addCriterion("show_text like", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextNotLike(String value)
		{
			addCriterion("show_text not like", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextIn(List<String> values)
		{
			addCriterion("show_text in", values, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextNotIn(List<String> values)
		{
			addCriterion("show_text not in", values, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextBetween(String value1, String value2)
		{
			addCriterion("show_text between", value1, value2, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextNotBetween(String value1, String value2)
		{
			addCriterion("show_text not between", value1, value2, "showText");
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

		public Criteria andIssueTimeIsNull()
		{
			addCriterion("issue_time is null");
			return (Criteria) this;
		}

		public Criteria andIssueTimeIsNotNull()
		{
			addCriterion("issue_time is not null");
			return (Criteria) this;
		}

		public Criteria andIssueTimeEqualTo(Date value)
		{
			addCriterion("issue_time =", value, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeNotEqualTo(Date value)
		{
			addCriterion("issue_time <>", value, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeGreaterThan(Date value)
		{
			addCriterion("issue_time >", value, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("issue_time >=", value, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeLessThan(Date value)
		{
			addCriterion("issue_time <", value, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("issue_time <=", value, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeIn(List<Date> values)
		{
			addCriterion("issue_time in", values, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeNotIn(List<Date> values)
		{
			addCriterion("issue_time not in", values, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeBetween(Date value1, Date value2)
		{
			addCriterion("issue_time between", value1, value2, "issueTime");
			return (Criteria) this;
		}

		public Criteria andIssueTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("issue_time not between", value1, value2, "issueTime");
			return (Criteria) this;
		}

		public Criteria andAltTextIsNull()
		{
			addCriterion("alt_text is null");
			return (Criteria) this;
		}

		public Criteria andAltTextIsNotNull()
		{
			addCriterion("alt_text is not null");
			return (Criteria) this;
		}

		public Criteria andAltTextEqualTo(String value)
		{
			addCriterion("alt_text =", value, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextNotEqualTo(String value)
		{
			addCriterion("alt_text <>", value, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextGreaterThan(String value)
		{
			addCriterion("alt_text >", value, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextGreaterThanOrEqualTo(String value)
		{
			addCriterion("alt_text >=", value, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextLessThan(String value)
		{
			addCriterion("alt_text <", value, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextLessThanOrEqualTo(String value)
		{
			addCriterion("alt_text <=", value, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextLike(String value)
		{
			addCriterion("alt_text like", value, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextNotLike(String value)
		{
			addCriterion("alt_text not like", value, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextIn(List<String> values)
		{
			addCriterion("alt_text in", values, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextNotIn(List<String> values)
		{
			addCriterion("alt_text not in", values, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextBetween(String value1, String value2)
		{
			addCriterion("alt_text between", value1, value2, "altText");
			return (Criteria) this;
		}

		public Criteria andAltTextNotBetween(String value1, String value2)
		{
			addCriterion("alt_text not between", value1, value2, "altText");
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