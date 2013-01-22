package com.eatle.persistent.pojo.merchant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public RestaurantCriteria()
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

	public RestaurantCriteria(int pageSize, int startIndex)
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

		public Criteria andSendMealsSpeedingIsNull()
		{
			addCriterion("send_meals_speeding is null");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingIsNotNull()
		{
			addCriterion("send_meals_speeding is not null");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingEqualTo(String value)
		{
			addCriterion("send_meals_speeding =", value, "sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingNotEqualTo(String value)
		{
			addCriterion("send_meals_speeding <>", value, "sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingGreaterThan(String value)
		{
			addCriterion("send_meals_speeding >", value, "sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingGreaterThanOrEqualTo(String value)
		{
			addCriterion("send_meals_speeding >=", value, "sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingLessThan(String value)
		{
			addCriterion("send_meals_speeding <", value, "sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingLessThanOrEqualTo(String value)
		{
			addCriterion("send_meals_speeding <=", value, "sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingLike(String value)
		{
			addCriterion("send_meals_speeding like", value, "sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingNotLike(String value)
		{
			addCriterion("send_meals_speeding not like", value,
					"sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingIn(List<String> values)
		{
			addCriterion("send_meals_speeding in", values, "sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingNotIn(List<String> values)
		{
			addCriterion("send_meals_speeding not in", values,
					"sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingBetween(String value1, String value2)
		{
			addCriterion("send_meals_speeding between", value1, value2,
					"sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendMealsSpeedingNotBetween(String value1,
				String value2)
		{
			addCriterion("send_meals_speeding not between", value1, value2,
					"sendMealsSpeeding");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceIsNull()
		{
			addCriterion("send_up_price is null");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceIsNotNull()
		{
			addCriterion("send_up_price is not null");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceEqualTo(String value)
		{
			addCriterion("send_up_price =", value, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceNotEqualTo(String value)
		{
			addCriterion("send_up_price <>", value, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceGreaterThan(String value)
		{
			addCriterion("send_up_price >", value, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceGreaterThanOrEqualTo(String value)
		{
			addCriterion("send_up_price >=", value, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceLessThan(String value)
		{
			addCriterion("send_up_price <", value, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceLessThanOrEqualTo(String value)
		{
			addCriterion("send_up_price <=", value, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceLike(String value)
		{
			addCriterion("send_up_price like", value, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceNotLike(String value)
		{
			addCriterion("send_up_price not like", value, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceIn(List<String> values)
		{
			addCriterion("send_up_price in", values, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceNotIn(List<String> values)
		{
			addCriterion("send_up_price not in", values, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceBetween(String value1, String value2)
		{
			addCriterion("send_up_price between", value1, value2, "sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendUpPriceNotBetween(String value1, String value2)
		{
			addCriterion("send_up_price not between", value1, value2,
					"sendUpPrice");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionIsNull()
		{
			addCriterion("send_meals_description is null");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionIsNotNull()
		{
			addCriterion("send_meals_description is not null");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionEqualTo(String value)
		{
			addCriterion("send_meals_description =", value,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionNotEqualTo(String value)
		{
			addCriterion("send_meals_description <>", value,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionGreaterThan(String value)
		{
			addCriterion("send_meals_description >", value,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionGreaterThanOrEqualTo(String value)
		{
			addCriterion("send_meals_description >=", value,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionLessThan(String value)
		{
			addCriterion("send_meals_description <", value,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionLessThanOrEqualTo(String value)
		{
			addCriterion("send_meals_description <=", value,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionLike(String value)
		{
			addCriterion("send_meals_description like", value,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionNotLike(String value)
		{
			addCriterion("send_meals_description not like", value,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionIn(List<String> values)
		{
			addCriterion("send_meals_description in", values,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionNotIn(List<String> values)
		{
			addCriterion("send_meals_description not in", values,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionBetween(String value1,
				String value2)
		{
			addCriterion("send_meals_description between", value1, value2,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsDescriptionNotBetween(String value1,
				String value2)
		{
			addCriterion("send_meals_description not between", value1, value2,
					"sendMealsDescription");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusIsNull()
		{
			addCriterion("send_meals_status is null");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusIsNotNull()
		{
			addCriterion("send_meals_status is not null");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusEqualTo(Short value)
		{
			addCriterion("send_meals_status =", value, "sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusNotEqualTo(Short value)
		{
			addCriterion("send_meals_status <>", value, "sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusGreaterThan(Short value)
		{
			addCriterion("send_meals_status >", value, "sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusGreaterThanOrEqualTo(Short value)
		{
			addCriterion("send_meals_status >=", value, "sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusLessThan(Short value)
		{
			addCriterion("send_meals_status <", value, "sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusLessThanOrEqualTo(Short value)
		{
			addCriterion("send_meals_status <=", value, "sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusIn(List<Short> values)
		{
			addCriterion("send_meals_status in", values, "sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusNotIn(List<Short> values)
		{
			addCriterion("send_meals_status not in", values, "sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusBetween(Short value1, Short value2)
		{
			addCriterion("send_meals_status between", value1, value2,
					"sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andSendMealsStatusNotBetween(Short value1, Short value2)
		{
			addCriterion("send_meals_status not between", value1, value2,
					"sendMealsStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursIsNull()
		{
			addCriterion("business_hours is null");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursIsNotNull()
		{
			addCriterion("business_hours is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursEqualTo(String value)
		{
			addCriterion("business_hours =", value, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursNotEqualTo(String value)
		{
			addCriterion("business_hours <>", value, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursGreaterThan(String value)
		{
			addCriterion("business_hours >", value, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursGreaterThanOrEqualTo(String value)
		{
			addCriterion("business_hours >=", value, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursLessThan(String value)
		{
			addCriterion("business_hours <", value, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursLessThanOrEqualTo(String value)
		{
			addCriterion("business_hours <=", value, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursLike(String value)
		{
			addCriterion("business_hours like", value, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursNotLike(String value)
		{
			addCriterion("business_hours not like", value, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursIn(List<String> values)
		{
			addCriterion("business_hours in", values, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursNotIn(List<String> values)
		{
			addCriterion("business_hours not in", values, "businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursBetween(String value1, String value2)
		{
			addCriterion("business_hours between", value1, value2,
					"businessHours");
			return (Criteria) this;
		}

		public Criteria andBusinessHoursNotBetween(String value1, String value2)
		{
			addCriterion("business_hours not between", value1, value2,
					"businessHours");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull()
		{
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull()
		{
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value)
		{
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value)
		{
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value)
		{
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value)
		{
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value)
		{
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value)
		{
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value)
		{
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value)
		{
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values)
		{
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values)
		{
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2)
		{
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2)
		{
			addCriterion("address not between", value1, value2, "address");
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

		public Criteria andContactEmailIsNull()
		{
			addCriterion("contact_email is null");
			return (Criteria) this;
		}

		public Criteria andContactEmailIsNotNull()
		{
			addCriterion("contact_email is not null");
			return (Criteria) this;
		}

		public Criteria andContactEmailEqualTo(String value)
		{
			addCriterion("contact_email =", value, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailNotEqualTo(String value)
		{
			addCriterion("contact_email <>", value, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailGreaterThan(String value)
		{
			addCriterion("contact_email >", value, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailGreaterThanOrEqualTo(String value)
		{
			addCriterion("contact_email >=", value, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailLessThan(String value)
		{
			addCriterion("contact_email <", value, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailLessThanOrEqualTo(String value)
		{
			addCriterion("contact_email <=", value, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailLike(String value)
		{
			addCriterion("contact_email like", value, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailNotLike(String value)
		{
			addCriterion("contact_email not like", value, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailIn(List<String> values)
		{
			addCriterion("contact_email in", values, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailNotIn(List<String> values)
		{
			addCriterion("contact_email not in", values, "contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailBetween(String value1, String value2)
		{
			addCriterion("contact_email between", value1, value2,
					"contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactEmailNotBetween(String value1, String value2)
		{
			addCriterion("contact_email not between", value1, value2,
					"contactEmail");
			return (Criteria) this;
		}

		public Criteria andContactQqIsNull()
		{
			addCriterion("contact_qq is null");
			return (Criteria) this;
		}

		public Criteria andContactQqIsNotNull()
		{
			addCriterion("contact_qq is not null");
			return (Criteria) this;
		}

		public Criteria andContactQqEqualTo(String value)
		{
			addCriterion("contact_qq =", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqNotEqualTo(String value)
		{
			addCriterion("contact_qq <>", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqGreaterThan(String value)
		{
			addCriterion("contact_qq >", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqGreaterThanOrEqualTo(String value)
		{
			addCriterion("contact_qq >=", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqLessThan(String value)
		{
			addCriterion("contact_qq <", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqLessThanOrEqualTo(String value)
		{
			addCriterion("contact_qq <=", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqLike(String value)
		{
			addCriterion("contact_qq like", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqNotLike(String value)
		{
			addCriterion("contact_qq not like", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqIn(List<String> values)
		{
			addCriterion("contact_qq in", values, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqNotIn(List<String> values)
		{
			addCriterion("contact_qq not in", values, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqBetween(String value1, String value2)
		{
			addCriterion("contact_qq between", value1, value2, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqNotBetween(String value1, String value2)
		{
			addCriterion("contact_qq not between", value1, value2, "contactQq");
			return (Criteria) this;
		}

		public Criteria andShopTypeIsNull()
		{
			addCriterion("shop_type is null");
			return (Criteria) this;
		}

		public Criteria andShopTypeIsNotNull()
		{
			addCriterion("shop_type is not null");
			return (Criteria) this;
		}

		public Criteria andShopTypeEqualTo(String value)
		{
			addCriterion("shop_type =", value, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeNotEqualTo(String value)
		{
			addCriterion("shop_type <>", value, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeGreaterThan(String value)
		{
			addCriterion("shop_type >", value, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeGreaterThanOrEqualTo(String value)
		{
			addCriterion("shop_type >=", value, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeLessThan(String value)
		{
			addCriterion("shop_type <", value, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeLessThanOrEqualTo(String value)
		{
			addCriterion("shop_type <=", value, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeLike(String value)
		{
			addCriterion("shop_type like", value, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeNotLike(String value)
		{
			addCriterion("shop_type not like", value, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeIn(List<String> values)
		{
			addCriterion("shop_type in", values, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeNotIn(List<String> values)
		{
			addCriterion("shop_type not in", values, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeBetween(String value1, String value2)
		{
			addCriterion("shop_type between", value1, value2, "shopType");
			return (Criteria) this;
		}

		public Criteria andShopTypeNotBetween(String value1, String value2)
		{
			addCriterion("shop_type not between", value1, value2, "shopType");
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