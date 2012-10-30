package com.eatle.persistent.pojo.foundation.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JoinInformationCriteria
{
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	// 开始索引号
	private int startIndex;

	// 每页大小
	private int pageSize;

	public JoinInformationCriteria()
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

	public JoinInformationCriteria(int pageSize, int startIndex)
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

		public Criteria andLinkTelIsNull()
		{
			addCriterion("link_tel is null");
			return (Criteria) this;
		}

		public Criteria andLinkTelIsNotNull()
		{
			addCriterion("link_tel is not null");
			return (Criteria) this;
		}

		public Criteria andLinkTelEqualTo(String value)
		{
			addCriterion("link_tel =", value, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelNotEqualTo(String value)
		{
			addCriterion("link_tel <>", value, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelGreaterThan(String value)
		{
			addCriterion("link_tel >", value, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelGreaterThanOrEqualTo(String value)
		{
			addCriterion("link_tel >=", value, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelLessThan(String value)
		{
			addCriterion("link_tel <", value, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelLessThanOrEqualTo(String value)
		{
			addCriterion("link_tel <=", value, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelLike(String value)
		{
			addCriterion("link_tel like", value, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelNotLike(String value)
		{
			addCriterion("link_tel not like", value, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelIn(List<String> values)
		{
			addCriterion("link_tel in", values, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelNotIn(List<String> values)
		{
			addCriterion("link_tel not in", values, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelBetween(String value1, String value2)
		{
			addCriterion("link_tel between", value1, value2, "linkTel");
			return (Criteria) this;
		}

		public Criteria andLinkTelNotBetween(String value1, String value2)
		{
			addCriterion("link_tel not between", value1, value2, "linkTel");
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

		public Criteria andLinkQqIsNull()
		{
			addCriterion("link_qq is null");
			return (Criteria) this;
		}

		public Criteria andLinkQqIsNotNull()
		{
			addCriterion("link_qq is not null");
			return (Criteria) this;
		}

		public Criteria andLinkQqEqualTo(String value)
		{
			addCriterion("link_qq =", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqNotEqualTo(String value)
		{
			addCriterion("link_qq <>", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqGreaterThan(String value)
		{
			addCriterion("link_qq >", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqGreaterThanOrEqualTo(String value)
		{
			addCriterion("link_qq >=", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqLessThan(String value)
		{
			addCriterion("link_qq <", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqLessThanOrEqualTo(String value)
		{
			addCriterion("link_qq <=", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqLike(String value)
		{
			addCriterion("link_qq like", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqNotLike(String value)
		{
			addCriterion("link_qq not like", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqIn(List<String> values)
		{
			addCriterion("link_qq in", values, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqNotIn(List<String> values)
		{
			addCriterion("link_qq not in", values, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqBetween(String value1, String value2)
		{
			addCriterion("link_qq between", value1, value2, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqNotBetween(String value1, String value2)
		{
			addCriterion("link_qq not between", value1, value2, "linkQq");
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

		public Criteria andAuditStatusIsNull()
		{
			addCriterion("audit_status is null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNotNull()
		{
			addCriterion("audit_status is not null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusEqualTo(Short value)
		{
			addCriterion("audit_status =", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotEqualTo(Short value)
		{
			addCriterion("audit_status <>", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThan(Short value)
		{
			addCriterion("audit_status >", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThanOrEqualTo(Short value)
		{
			addCriterion("audit_status >=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThan(Short value)
		{
			addCriterion("audit_status <", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThanOrEqualTo(Short value)
		{
			addCriterion("audit_status <=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIn(List<Short> values)
		{
			addCriterion("audit_status in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotIn(List<Short> values)
		{
			addCriterion("audit_status not in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusBetween(Short value1, Short value2)
		{
			addCriterion("audit_status between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotBetween(Short value1, Short value2)
		{
			addCriterion("audit_status not between", value1, value2,
					"auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkIsNull()
		{
			addCriterion("audit_remark is null");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkIsNotNull()
		{
			addCriterion("audit_remark is not null");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkEqualTo(String value)
		{
			addCriterion("audit_remark =", value, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkNotEqualTo(String value)
		{
			addCriterion("audit_remark <>", value, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkGreaterThan(String value)
		{
			addCriterion("audit_remark >", value, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkGreaterThanOrEqualTo(String value)
		{
			addCriterion("audit_remark >=", value, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkLessThan(String value)
		{
			addCriterion("audit_remark <", value, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkLessThanOrEqualTo(String value)
		{
			addCriterion("audit_remark <=", value, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkLike(String value)
		{
			addCriterion("audit_remark like", value, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkNotLike(String value)
		{
			addCriterion("audit_remark not like", value, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkIn(List<String> values)
		{
			addCriterion("audit_remark in", values, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkNotIn(List<String> values)
		{
			addCriterion("audit_remark not in", values, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkBetween(String value1, String value2)
		{
			addCriterion("audit_remark between", value1, value2, "auditRemark");
			return (Criteria) this;
		}

		public Criteria andAuditRemarkNotBetween(String value1, String value2)
		{
			addCriterion("audit_remark not between", value1, value2,
					"auditRemark");
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