package com.eatle.service.foundation.business.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.CustomerMapper;
import com.eatle.persistent.mapper.FeedbackMapper;
import com.eatle.persistent.mapper.MerchantMapper;
import com.eatle.persistent.pojo.foundation.business.Feedback;
import com.eatle.persistent.pojo.foundation.business.FeedbackCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.business.FeedbackCriteria;
import com.eatle.service.foundation.business.IFeedbackService;
import com.eatle.utils.Pagination;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("feedbackService")
public class FeedbackServiceImpl implements IFeedbackService
{
	@Resource
	private FeedbackMapper feedbackMapper;

	@Resource
	private MerchantMapper merchantMapper;
	
	@Resource
	private CustomerMapper customerMapper;

	@Override
	public int add(Feedback entity)
	{
		return feedbackMapper.insert(entity);
	}

	@Override
	public int delete(Feedback entity)
	{
		return feedbackMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Feedback entity)
	{
		return feedbackMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize) throws ParseException
	{
		FeedbackCriteria feedbackCriteria = new FeedbackCriteria();
		Criteria criteria = feedbackCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap != null)
			{
				if (queryMap.containsKey("startTime"))
				{
					if(queryMap.containsKey("endTime"))
					{
						criteria.andSubTimeBetween(
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("startTime")), 
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("endTime")));
					}
					else
					{
						criteria.andSubTimeBetween(
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("startTime")), 
							new Date());
					}
				}
				if(queryMap.containsKey("handleStatus"))
				{
					criteria.andHandleStatusEqualTo(Short.parseShort((String) queryMap.get("handleStatus")));
				}
				if(queryMap.containsKey("identifyType"))
				{
					criteria.andHandleStatusEqualTo(Short.parseShort((String) queryMap.get("identifyType")));
				}
			}
		}
		// 设置分页参数
		feedbackCriteria.setPageSize(pageSize);
		feedbackCriteria.setStartIndex((currentPage - 1) * pageSize);
		
		List<Feedback> feedbacks = feedbackMapper.selectByCriteria(feedbackCriteria);
		List<Feedback> items = new ArrayList<Feedback>();
		for(Feedback fb : feedbacks)
		{
			// 反馈人
			if(fb.getIdentifyId() != null)
			{
				Short type = fb.getIdentifyType();
				if(type != null)
				{
					if(type == Constants.Identity.IDENTITY_MERCHANT)
					{
						fb.setIdentifyStr(merchantMapper.selectByPrimaryKey(fb.getIdentifyId()).getMerchantName());
						fb.setIdentifyTypeStr(Constants.Identity.IDENTITY_MERCHANT_HTML);
					}
					else if(type == Constants.Identity.IDENTITY_CUSTOMER)
					{
						fb.setIdentifyStr(customerMapper.selectByPrimaryKey(fb.getIdentifyId()).getLoginEmail());
						fb.setIdentifyTypeStr(Constants.Identity.IDENTITY_CUSTOMER_HTML);
					}
				}
			}
			// 反馈时间
			if(fb.getSubTime() != null)
				fb.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fb.getSubTime()));
			// 处理状态
			if(fb.getHandleStatus() == Constants.Status.STATUS_WAIT_HANDLE)
				fb.setHandleStatusStr(Constants.Status.STATUS_WAIT_HANDLE_HTML);
			if(fb.getHandleStatus() == Constants.Status.STATUS_VIEWED)
				fb.setHandleStatusStr(Constants.Status.STATUS_VIEWED_HTML);
			if(fb.getHandleStatus() == Constants.Status.STATUS_HANDLED)
				fb.setHandleStatusStr(Constants.Status.STATUS_HANDLED_HTML);
			// 处理时间
			if(fb.getHandleTime() != null)
				fb.setHandleTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fb.getHandleTime()));
			
			items.add(fb);
		}
		int totalCount = (int) feedbackMapper.selectCountByCriteria(feedbackCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Feedback findById(long id)
	{
		Feedback fb = feedbackMapper.selectByPrimaryKey(id);

		// 反馈人
		if(fb.getIdentifyId() != null)
		{
			Short type = fb.getIdentifyType();
			if(type != null)
			{
				if(type == Constants.Identity.IDENTITY_MERCHANT)
				{
					fb.setIdentifyStr(merchantMapper.selectByPrimaryKey(fb.getIdentifyId()).getMerchantName());
					fb.setIdentifyTypeStr(Constants.Identity.IDENTITY_MERCHANT_HTML);
				}
				else if(type == Constants.Identity.IDENTITY_CUSTOMER)
				{
					fb.setIdentifyStr(customerMapper.selectByPrimaryKey(fb.getIdentifyId()).getLoginEmail());
					fb.setIdentifyTypeStr(Constants.Identity.IDENTITY_CUSTOMER_HTML);
				}
			}
		}
		// 反馈时间
		if(fb.getSubTime() != null)
			fb.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fb.getSubTime()));
		// 处理状态
		if(fb.getHandleStatus() == Constants.Status.STATUS_WAIT_HANDLE)
			fb.setHandleStatusStr(Constants.Status.STATUS_WAIT_HANDLE_HTML);
		if(fb.getHandleStatus() == Constants.Status.STATUS_VIEWED)
			fb.setHandleStatusStr(Constants.Status.STATUS_VIEWED_HTML);
		if(fb.getHandleStatus() == Constants.Status.STATUS_HANDLED)
			fb.setHandleStatusStr(Constants.Status.STATUS_HANDLED_HTML);
		// 处理时间
		if(fb.getHandleTime() != null)
			fb.setHandleTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fb.getHandleTime()));
		
		return fb;
	}

	@Override
	public List<Feedback> findAll()
	{
		return feedbackMapper.selectByCriteria(null);
	}

	@Override
	public List<Feedback> findByCriteria(FeedbackCriteria criteria)
	{
		return feedbackMapper.selectByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List<Feedback> dataList = new ArrayList<Feedback>();
		for(Feedback fb : findAll())
		{
			// 反馈人
			if(fb.getIdentifyId() != null)
			{
				Short type = fb.getIdentifyType();
				if(type != null)
				{
					if(type == Constants.Identity.IDENTITY_MERCHANT)
					{
						fb.setIdentifyStr(merchantMapper.selectByPrimaryKey(fb.getIdentifyId()).getMerchantName());
						fb.setIdentifyTypeStr(Constants.Identity.IDENTITY_MERCHANT_STR);
					}
					else if(type == Constants.Identity.IDENTITY_CUSTOMER)
					{
						fb.setIdentifyStr(customerMapper.selectByPrimaryKey(fb.getIdentifyId()).getLoginEmail());
						fb.setIdentifyTypeStr(Constants.Identity.IDENTITY_CUSTOMER_STR);
					}
				}
			}
			// 反馈时间
			if(fb.getSubTime() != null)
				fb.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fb.getSubTime()));
			// 处理状态
			if(fb.getHandleStatus() == Constants.Status.STATUS_WAIT_HANDLE)
				fb.setHandleStatusStr(Constants.Status.STATUS_WAIT_HANDLE_STR);
			if(fb.getHandleStatus() == Constants.Status.STATUS_VIEWED)
				fb.setHandleStatusStr(Constants.Status.STATUS_VIEWED_STR);
			if(fb.getHandleStatus() == Constants.Status.STATUS_HANDLED)
				fb.setHandleStatusStr(Constants.Status.STATUS_HANDLED_STR);
			// 处理时间
			if(fb.getHandleTime() != null)
				fb.setHandleTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fb.getHandleTime()));
			
			dataList.add(fb);
		}
		map.put("反馈建议信息", dataList);
		return map;
	}
}