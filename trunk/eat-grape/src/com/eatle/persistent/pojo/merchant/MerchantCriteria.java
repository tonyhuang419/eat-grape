package com.eatle.persistent.pojo.merchant;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class MerchantCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public MerchantCriteria()
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

	public MerchantCriteria(int pageSize, int startIndex)
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
				throw new RuntimeException("Between values for " + property + " cannot be null");
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

		public Criteria andLegalNameIsNull()
		{
			addCriterion("legal_name is null");
			return (Criteria) this;
		}

		public Criteria andLegalNameIsNotNull()
		{
			addCriterion("legal_name is not null");
			return (Criteria) this;
		}

		public Criteria andLegalNameEqualTo(String value)
		{
			addCriterion("legal_name =", value, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameNotEqualTo(String value)
		{
			addCriterion("legal_name <>", value, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameGreaterThan(String value)
		{
			addCriterion("legal_name >", value, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("legal_name >=", value, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameLessThan(String value)
		{
			addCriterion("legal_name <", value, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameLessThanOrEqualTo(String value)
		{
			addCriterion("legal_name <=", value, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameLike(String value)
		{
			addCriterion("legal_name like", value, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameNotLike(String value)
		{
			addCriterion("legal_name not like", value, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameIn(List<String> values)
		{
			addCriterion("legal_name in", values, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameNotIn(List<String> values)
		{
			addCriterion("legal_name not in", values, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameBetween(String value1, String value2)
		{
			addCriterion("legal_name between", value1, value2, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalNameNotBetween(String value1, String value2)
		{
			addCriterion("legal_name not between", value1, value2, "legalName");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardIsNull()
		{
			addCriterion("legal_id_card is null");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardIsNotNull()
		{
			addCriterion("legal_id_card is not null");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardEqualTo(String value)
		{
			addCriterion("legal_id_card =", value, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardNotEqualTo(String value)
		{
			addCriterion("legal_id_card <>", value, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardGreaterThan(String value)
		{
			addCriterion("legal_id_card >", value, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardGreaterThanOrEqualTo(String value)
		{
			addCriterion("legal_id_card >=", value, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardLessThan(String value)
		{
			addCriterion("legal_id_card <", value, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardLessThanOrEqualTo(String value)
		{
			addCriterion("legal_id_card <=", value, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardLike(String value)
		{
			addCriterion("legal_id_card like", value, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardNotLike(String value)
		{
			addCriterion("legal_id_card not like", value, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardIn(List<String> values)
		{
			addCriterion("legal_id_card in", values, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardNotIn(List<String> values)
		{
			addCriterion("legal_id_card not in", values, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardBetween(String value1, String value2)
		{
			addCriterion("legal_id_card between", value1, value2, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalIdCardNotBetween(String value1, String value2)
		{
			addCriterion("legal_id_card not between", value1, value2, "legalIdCard");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressIsNull()
		{
			addCriterion("legal_home_address is null");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressIsNotNull()
		{
			addCriterion("legal_home_address is not null");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressEqualTo(String value)
		{
			addCriterion("legal_home_address =", value, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressNotEqualTo(String value)
		{
			addCriterion("legal_home_address <>", value, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressGreaterThan(String value)
		{
			addCriterion("legal_home_address >", value, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressGreaterThanOrEqualTo(String value)
		{
			addCriterion("legal_home_address >=", value, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressLessThan(String value)
		{
			addCriterion("legal_home_address <", value, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressLessThanOrEqualTo(String value)
		{
			addCriterion("legal_home_address <=", value, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressLike(String value)
		{
			addCriterion("legal_home_address like", value, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressNotLike(String value)
		{
			addCriterion("legal_home_address not like", value, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressIn(List<String> values)
		{
			addCriterion("legal_home_address in", values, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressNotIn(List<String> values)
		{
			addCriterion("legal_home_address not in", values, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressBetween(String value1, String value2)
		{
			addCriterion("legal_home_address between", value1, value2, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalHomeAddressNotBetween(String value1,
				String value2)
		{
			addCriterion("legal_home_address not between", value1, value2, "legalHomeAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressIsNull()
		{
			addCriterion("legal_address is null");
			return (Criteria) this;
		}

		public Criteria andLegalAddressIsNotNull()
		{
			addCriterion("legal_address is not null");
			return (Criteria) this;
		}

		public Criteria andLegalAddressEqualTo(String value)
		{
			addCriterion("legal_address =", value, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressNotEqualTo(String value)
		{
			addCriterion("legal_address <>", value, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressGreaterThan(String value)
		{
			addCriterion("legal_address >", value, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressGreaterThanOrEqualTo(String value)
		{
			addCriterion("legal_address >=", value, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressLessThan(String value)
		{
			addCriterion("legal_address <", value, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressLessThanOrEqualTo(String value)
		{
			addCriterion("legal_address <=", value, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressLike(String value)
		{
			addCriterion("legal_address like", value, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressNotLike(String value)
		{
			addCriterion("legal_address not like", value, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressIn(List<String> values)
		{
			addCriterion("legal_address in", values, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressNotIn(List<String> values)
		{
			addCriterion("legal_address not in", values, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressBetween(String value1, String value2)
		{
			addCriterion("legal_address between", value1, value2, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalAddressNotBetween(String value1, String value2)
		{
			addCriterion("legal_address not between", value1, value2, "legalAddress");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneIsNull()
		{
			addCriterion("legal_phone is null");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneIsNotNull()
		{
			addCriterion("legal_phone is not null");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneEqualTo(String value)
		{
			addCriterion("legal_phone =", value, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneNotEqualTo(String value)
		{
			addCriterion("legal_phone <>", value, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneGreaterThan(String value)
		{
			addCriterion("legal_phone >", value, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneGreaterThanOrEqualTo(String value)
		{
			addCriterion("legal_phone >=", value, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneLessThan(String value)
		{
			addCriterion("legal_phone <", value, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneLessThanOrEqualTo(String value)
		{
			addCriterion("legal_phone <=", value, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneLike(String value)
		{
			addCriterion("legal_phone like", value, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneNotLike(String value)
		{
			addCriterion("legal_phone not like", value, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneIn(List<String> values)
		{
			addCriterion("legal_phone in", values, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneNotIn(List<String> values)
		{
			addCriterion("legal_phone not in", values, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneBetween(String value1, String value2)
		{
			addCriterion("legal_phone between", value1, value2, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andLegalPhoneNotBetween(String value1, String value2)
		{
			addCriterion("legal_phone not between", value1, value2, "legalPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeIsNull()
		{
			addCriterion("merchant_join_time is null");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeIsNotNull()
		{
			addCriterion("merchant_join_time is not null");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeEqualTo(Date value)
		{
			addCriterion("merchant_join_time =", value, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeNotEqualTo(Date value)
		{
			addCriterion("merchant_join_time <>", value, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeGreaterThan(Date value)
		{
			addCriterion("merchant_join_time >", value, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeGreaterThanOrEqualTo(Date value)
		{
			addCriterion("merchant_join_time >=", value, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeLessThan(Date value)
		{
			addCriterion("merchant_join_time <", value, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeLessThanOrEqualTo(Date value)
		{
			addCriterion("merchant_join_time <=", value, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeIn(List<Date> values)
		{
			addCriterion("merchant_join_time in", values, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeNotIn(List<Date> values)
		{
			addCriterion("merchant_join_time not in", values,
					"merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeBetween(Date value1, Date value2)
		{
			addCriterion("merchant_join_time between", value1, value2, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantJoinTimeNotBetween(Date value1, Date value2)
		{
			addCriterion("merchant_join_time not between", value1, value2, "merchantJoinTime");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlIsNull()
		{
			addCriterion("merchant_logo_url is null");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlIsNotNull()
		{
			addCriterion("merchant_logo_url is not null");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlEqualTo(String value)
		{
			addCriterion("merchant_logo_url =", value, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlNotEqualTo(String value)
		{
			addCriterion("merchant_logo_url <>", value, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlGreaterThan(String value)
		{
			addCriterion("merchant_logo_url >", value, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlGreaterThanOrEqualTo(String value)
		{
			addCriterion("merchant_logo_url >=", value, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlLessThan(String value)
		{
			addCriterion("merchant_logo_url <", value, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlLessThanOrEqualTo(String value)
		{
			addCriterion("merchant_logo_url <=", value, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlLike(String value)
		{
			addCriterion("merchant_logo_url like", value, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlNotLike(String value)
		{
			addCriterion("merchant_logo_url not like", value, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlIn(List<String> values)
		{
			addCriterion("merchant_logo_url in", values, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlNotIn(List<String> values)
		{
			addCriterion("merchant_logo_url not in", values, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlBetween(String value1, String value2)
		{
			addCriterion("merchant_logo_url between", value1, value2, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantLogoUrlNotBetween(String value1,
				String value2)
		{
			addCriterion("merchant_logo_url not between", value1, value2, "merchantLogoUrl");
			return (Criteria) this;
		}

		public Criteria andMerchantNameIsNull()
		{
			addCriterion("merchant_name is null");
			return (Criteria) this;
		}

		public Criteria andMerchantNameIsNotNull()
		{
			addCriterion("merchant_name is not null");
			return (Criteria) this;
		}

		public Criteria andMerchantNameEqualTo(String value)
		{
			addCriterion("merchant_name =", value, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameNotEqualTo(String value)
		{
			addCriterion("merchant_name <>", value, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameGreaterThan(String value)
		{
			addCriterion("merchant_name >", value, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameGreaterThanOrEqualTo(String value)
		{
			addCriterion("merchant_name >=", value, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameLessThan(String value)
		{
			addCriterion("merchant_name <", value, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameLessThanOrEqualTo(String value)
		{
			addCriterion("merchant_name <=", value, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameLike(String value)
		{
			addCriterion("merchant_name like", value, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameNotLike(String value)
		{
			addCriterion("merchant_name not like", value, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameIn(List<String> values)
		{
			addCriterion("merchant_name in", values, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameNotIn(List<String> values)
		{
			addCriterion("merchant_name not in", values, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameBetween(String value1, String value2)
		{
			addCriterion("merchant_name between", value1, value2, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantNameNotBetween(String value1, String value2)
		{
			addCriterion("merchant_name not between", value1, value2, "merchantName");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneIsNull()
		{
			addCriterion("merchant_phone is null");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneIsNotNull()
		{
			addCriterion("merchant_phone is not null");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneEqualTo(String value)
		{
			addCriterion("merchant_phone =", value, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneNotEqualTo(String value)
		{
			addCriterion("merchant_phone <>", value, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneGreaterThan(String value)
		{
			addCriterion("merchant_phone >", value, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneGreaterThanOrEqualTo(String value)
		{
			addCriterion("merchant_phone >=", value, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneLessThan(String value)
		{
			addCriterion("merchant_phone <", value, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneLessThanOrEqualTo(String value)
		{
			addCriterion("merchant_phone <=", value, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneLike(String value)
		{
			addCriterion("merchant_phone like", value, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneNotLike(String value)
		{
			addCriterion("merchant_phone not like", value, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneIn(List<String> values)
		{
			addCriterion("merchant_phone in", values, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneNotIn(List<String> values)
		{
			addCriterion("merchant_phone not in", values, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneBetween(String value1, String value2)
		{
			addCriterion("merchant_phone between", value1, value2, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantPhoneNotBetween(String value1, String value2)
		{
			addCriterion("merchant_phone not between", value1, value2, "merchantPhone");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressIsNull()
		{
			addCriterion("merchant_address is null");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressIsNotNull()
		{
			addCriterion("merchant_address is not null");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressEqualTo(String value)
		{
			addCriterion("merchant_address =", value, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressNotEqualTo(String value)
		{
			addCriterion("merchant_address <>", value, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressGreaterThan(String value)
		{
			addCriterion("merchant_address >", value, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressGreaterThanOrEqualTo(String value)
		{
			addCriterion("merchant_address >=", value, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressLessThan(String value)
		{
			addCriterion("merchant_address <", value, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressLessThanOrEqualTo(String value)
		{
			addCriterion("merchant_address <=", value, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressLike(String value)
		{
			addCriterion("merchant_address like", value, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressNotLike(String value)
		{
			addCriterion("merchant_address not like", value, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressIn(List<String> values)
		{
			addCriterion("merchant_address in", values, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressNotIn(List<String> values)
		{
			addCriterion("merchant_address not in", values, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressBetween(String value1, String value2)
		{
			addCriterion("merchant_address between", value1, value2, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantAddressNotBetween(String value1,
				String value2)
		{
			addCriterion("merchant_address not between", value1, value2, "merchantAddress");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailIsNull()
		{
			addCriterion("merchant_email is null");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailIsNotNull()
		{
			addCriterion("merchant_email is not null");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailEqualTo(String value)
		{
			addCriterion("merchant_email =", value, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailNotEqualTo(String value)
		{
			addCriterion("merchant_email <>", value, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailGreaterThan(String value)
		{
			addCriterion("merchant_email >", value, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailGreaterThanOrEqualTo(String value)
		{
			addCriterion("merchant_email >=", value, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailLessThan(String value)
		{
			addCriterion("merchant_email <", value, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailLessThanOrEqualTo(String value)
		{
			addCriterion("merchant_email <=", value, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailLike(String value)
		{
			addCriterion("merchant_email like", value, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailNotLike(String value)
		{
			addCriterion("merchant_email not like", value, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailIn(List<String> values)
		{
			addCriterion("merchant_email in", values, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailNotIn(List<String> values)
		{
			addCriterion("merchant_email not in", values, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailBetween(String value1, String value2)
		{
			addCriterion("merchant_email between", value1, value2, "merchantEmail");
			return (Criteria) this;
		}

		public Criteria andMerchantEmailNotBetween(String value1, String value2)
		{
			addCriterion("merchant_email not between", value1, value2, "merchantEmail");
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

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
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