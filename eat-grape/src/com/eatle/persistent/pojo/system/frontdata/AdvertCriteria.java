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

		public Criteria andAdvertTypeIsNull()
		{
			addCriterion("advert_type is null");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeIsNotNull()
		{
			addCriterion("advert_type is not null");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeEqualTo(Short value)
		{
			addCriterion("advert_type =", value, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeNotEqualTo(Short value)
		{
			addCriterion("advert_type <>", value, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeGreaterThan(Short value)
		{
			addCriterion("advert_type >", value, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeGreaterThanOrEqualTo(Short value)
		{
			addCriterion("advert_type >=", value, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeLessThan(Short value)
		{
			addCriterion("advert_type <", value, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeLessThanOrEqualTo(Short value)
		{
			addCriterion("advert_type <=", value, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeIn(List<Short> values)
		{
			addCriterion("advert_type in", values, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeNotIn(List<Short> values)
		{
			addCriterion("advert_type not in", values, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeBetween(Short value1, Short value2)
		{
			addCriterion("advert_type between", value1, value2, "advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertTypeNotBetween(Short value1, Short value2)
		{
			addCriterion("advert_type not between", value1, value2,
					"advertType");
			return (Criteria) this;
		}

		public Criteria andAdvertNameIsNull()
		{
			addCriterion("advert_name is null");
			return (Criteria) this;
		}

		public Criteria andAdvertNameIsNotNull()
		{
			addCriterion("advert_name is not null");
			return (Criteria) this;
		}

		public Criteria andAdvertNameEqualTo(String value)
		{
			addCriterion("advert_name =", value, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameNotEqualTo(String value)
		{
			addCriterion("advert_name <>", value, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameGreaterThan(String value)
		{
			addCriterion("advert_name >", value, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("advert_name >=", value, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameLessThan(String value)
		{
			addCriterion("advert_name <", value, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameLessThanOrEqualTo(String value)
		{
			addCriterion("advert_name <=", value, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameLike(String value)
		{
			addCriterion("advert_name like", value, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameNotLike(String value)
		{
			addCriterion("advert_name not like", value, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameIn(List<String> values)
		{
			addCriterion("advert_name in", values, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameNotIn(List<String> values)
		{
			addCriterion("advert_name not in", values, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameBetween(String value1, String value2)
		{
			addCriterion("advert_name between", value1, value2, "advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertNameNotBetween(String value1, String value2)
		{
			addCriterion("advert_name not between", value1, value2,
					"advertName");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkIsNull()
		{
			addCriterion("advert_link is null");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkIsNotNull()
		{
			addCriterion("advert_link is not null");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkEqualTo(String value)
		{
			addCriterion("advert_link =", value, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkNotEqualTo(String value)
		{
			addCriterion("advert_link <>", value, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkGreaterThan(String value)
		{
			addCriterion("advert_link >", value, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkGreaterThanOrEqualTo(String value)
		{
			addCriterion("advert_link >=", value, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkLessThan(String value)
		{
			addCriterion("advert_link <", value, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkLessThanOrEqualTo(String value)
		{
			addCriterion("advert_link <=", value, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkLike(String value)
		{
			addCriterion("advert_link like", value, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkNotLike(String value)
		{
			addCriterion("advert_link not like", value, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkIn(List<String> values)
		{
			addCriterion("advert_link in", values, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkNotIn(List<String> values)
		{
			addCriterion("advert_link not in", values, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkBetween(String value1, String value2)
		{
			addCriterion("advert_link between", value1, value2, "advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertLinkNotBetween(String value1, String value2)
		{
			addCriterion("advert_link not between", value1, value2,
					"advertLink");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledIsNull()
		{
			addCriterion("advert_enabled is null");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledIsNotNull()
		{
			addCriterion("advert_enabled is not null");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledEqualTo(Short value)
		{
			addCriterion("advert_enabled =", value, "advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledNotEqualTo(Short value)
		{
			addCriterion("advert_enabled <>", value, "advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledGreaterThan(Short value)
		{
			addCriterion("advert_enabled >", value, "advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledGreaterThanOrEqualTo(Short value)
		{
			addCriterion("advert_enabled >=", value, "advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledLessThan(Short value)
		{
			addCriterion("advert_enabled <", value, "advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledLessThanOrEqualTo(Short value)
		{
			addCriterion("advert_enabled <=", value, "advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledIn(List<Short> values)
		{
			addCriterion("advert_enabled in", values, "advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledNotIn(List<Short> values)
		{
			addCriterion("advert_enabled not in", values, "advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledBetween(Short value1, Short value2)
		{
			addCriterion("advert_enabled between", value1, value2,
					"advertEnabled");
			return (Criteria) this;
		}

		public Criteria andAdvertEnabledNotBetween(Short value1, Short value2)
		{
			addCriterion("advert_enabled not between", value1, value2,
					"advertEnabled");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNull()
		{
			addCriterion("start_time is null");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNotNull()
		{
			addCriterion("start_time is not null");
			return (Criteria) this;
		}

		public Criteria andStartTimeEqualTo(Date value)
		{
			addCriterion("start_time =", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotEqualTo(Date value)
		{
			addCriterion("start_time <>", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThan(Date value)
		{
			addCriterion("start_time >", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("start_time >=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThan(Date value)
		{
			addCriterion("start_time <", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("start_time <=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeIn(List<Date> values)
		{
			addCriterion("start_time in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotIn(List<Date> values)
		{
			addCriterion("start_time not in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeBetween(Date value1, Date value2)
		{
			addCriterion("start_time between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("start_time not between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull()
		{
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull()
		{
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value)
		{
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value)
		{
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value)
		{
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value)
		{
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values)
		{
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values)
		{
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2)
		{
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andClickCountIsNull()
		{
			addCriterion("click_count is null");
			return (Criteria) this;
		}

		public Criteria andClickCountIsNotNull()
		{
			addCriterion("click_count is not null");
			return (Criteria) this;
		}

		public Criteria andClickCountEqualTo(Integer value)
		{
			addCriterion("click_count =", value, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountNotEqualTo(Integer value)
		{
			addCriterion("click_count <>", value, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountGreaterThan(Integer value)
		{
			addCriterion("click_count >", value, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountGreaterThanOrEqualTo(Integer value)
		{
			addCriterion("click_count >=", value, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountLessThan(Integer value)
		{
			addCriterion("click_count <", value, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountLessThanOrEqualTo(Integer value)
		{
			addCriterion("click_count <=", value, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountIn(List<Integer> values)
		{
			addCriterion("click_count in", values, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountNotIn(List<Integer> values)
		{
			addCriterion("click_count not in", values, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountBetween(Integer value1, Integer value2)
		{
			addCriterion("click_count between", value1, value2, "clickCount");
			return (Criteria) this;
		}

		public Criteria andClickCountNotBetween(Integer value1, Integer value2)
		{
			addCriterion("click_count not between", value1, value2,
					"clickCount");
			return (Criteria) this;
		}

		public Criteria andLinkManIsNull()
		{
			addCriterion("link_man is null");
			return (Criteria) this;
		}

		public Criteria andLinkManIsNotNull()
		{
			addCriterion("link_man is not null");
			return (Criteria) this;
		}

		public Criteria andLinkManEqualTo(String value)
		{
			addCriterion("link_man =", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManNotEqualTo(String value)
		{
			addCriterion("link_man <>", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManGreaterThan(String value)
		{
			addCriterion("link_man >", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManGreaterThanOrEqualTo(String value)
		{
			addCriterion("link_man >=", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManLessThan(String value)
		{
			addCriterion("link_man <", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManLessThanOrEqualTo(String value)
		{
			addCriterion("link_man <=", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManLike(String value)
		{
			addCriterion("link_man like", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManNotLike(String value)
		{
			addCriterion("link_man not like", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManIn(List<String> values)
		{
			addCriterion("link_man in", values, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManNotIn(List<String> values)
		{
			addCriterion("link_man not in", values, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManBetween(String value1, String value2)
		{
			addCriterion("link_man between", value1, value2, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManNotBetween(String value1, String value2)
		{
			addCriterion("link_man not between", value1, value2, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkEmailIsNull()
		{
			addCriterion("link_email is null");
			return (Criteria) this;
		}

		public Criteria andLinkEmailIsNotNull()
		{
			addCriterion("link_email is not null");
			return (Criteria) this;
		}

		public Criteria andLinkEmailEqualTo(String value)
		{
			addCriterion("link_email =", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailNotEqualTo(String value)
		{
			addCriterion("link_email <>", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailGreaterThan(String value)
		{
			addCriterion("link_email >", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailGreaterThanOrEqualTo(String value)
		{
			addCriterion("link_email >=", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailLessThan(String value)
		{
			addCriterion("link_email <", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailLessThanOrEqualTo(String value)
		{
			addCriterion("link_email <=", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailLike(String value)
		{
			addCriterion("link_email like", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailNotLike(String value)
		{
			addCriterion("link_email not like", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailIn(List<String> values)
		{
			addCriterion("link_email in", values, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailNotIn(List<String> values)
		{
			addCriterion("link_email not in", values, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailBetween(String value1, String value2)
		{
			addCriterion("link_email between", value1, value2, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailNotBetween(String value1, String value2)
		{
			addCriterion("link_email not between", value1, value2, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneIsNull()
		{
			addCriterion("link_phone is null");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneIsNotNull()
		{
			addCriterion("link_phone is not null");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneEqualTo(String value)
		{
			addCriterion("link_phone =", value, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneNotEqualTo(String value)
		{
			addCriterion("link_phone <>", value, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneGreaterThan(String value)
		{
			addCriterion("link_phone >", value, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneGreaterThanOrEqualTo(String value)
		{
			addCriterion("link_phone >=", value, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneLessThan(String value)
		{
			addCriterion("link_phone <", value, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneLessThanOrEqualTo(String value)
		{
			addCriterion("link_phone <=", value, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneLike(String value)
		{
			addCriterion("link_phone like", value, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneNotLike(String value)
		{
			addCriterion("link_phone not like", value, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneIn(List<String> values)
		{
			addCriterion("link_phone in", values, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneNotIn(List<String> values)
		{
			addCriterion("link_phone not in", values, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneBetween(String value1, String value2)
		{
			addCriterion("link_phone between", value1, value2, "linkPhone");
			return (Criteria) this;
		}

		public Criteria andLinkPhoneNotBetween(String value1, String value2)
		{
			addCriterion("link_phone not between", value1, value2, "linkPhone");
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

		public Criteria andAdvertPositionIdIsNull()
		{
			addCriterion("advert_position_id is null");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdIsNotNull()
		{
			addCriterion("advert_position_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdEqualTo(Long value)
		{
			addCriterion("advert_position_id =", value, "advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdNotEqualTo(Long value)
		{
			addCriterion("advert_position_id <>", value, "advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdGreaterThan(Long value)
		{
			addCriterion("advert_position_id >", value, "advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdGreaterThanOrEqualTo(Long value)
		{
			addCriterion("advert_position_id >=", value, "advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdLessThan(Long value)
		{
			addCriterion("advert_position_id <", value, "advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdLessThanOrEqualTo(Long value)
		{
			addCriterion("advert_position_id <=", value, "advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdIn(List<Long> values)
		{
			addCriterion("advert_position_id in", values, "advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdNotIn(List<Long> values)
		{
			addCriterion("advert_position_id not in", values,
					"advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdBetween(Long value1, Long value2)
		{
			addCriterion("advert_position_id between", value1, value2,
					"advertPositionId");
			return (Criteria) this;
		}

		public Criteria andAdvertPositionIdNotBetween(Long value1, Long value2)
		{
			addCriterion("advert_position_id not between", value1, value2,
					"advertPositionId");
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