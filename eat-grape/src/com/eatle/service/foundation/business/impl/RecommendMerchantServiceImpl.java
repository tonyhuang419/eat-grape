package com.eatle.service.foundation.business.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.RecommendMerchantMapper;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchant;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchantCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchantCriteria;
import com.eatle.service.foundation.business.IRecommendMerchantService;
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

@Service("recommendMerchantService")
public class RecommendMerchantServiceImpl implements IRecommendMerchantService
{
	@Resource
	private RecommendMerchantMapper recommendMerchantMapper;

	@Override
	public int add(RecommendMerchant entity)
	{
		return recommendMerchantMapper.insert(entity);
	}

	@Override
	public int delete(RecommendMerchant entity)
	{
		return recommendMerchantMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(RecommendMerchant entity)
	{
		return recommendMerchantMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize) throws ParseException
	{
		RecommendMerchantCriteria recommendMerchantCriteria = new RecommendMerchantCriteria();
		Criteria criteria = recommendMerchantCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap != null)
			{
				if (queryMap.containsKey("shopName"))
				{
					criteria.andShopNameLike("%" + (String) queryMap.get("shopName") + "%");
				}
				if (queryMap.containsKey("referrer"))
				{
//					Long customerId = XXX (String) queryMap.get("referrer");
//					criteria.andCustomerIdEqualTo(customerId);
				}
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
			}
		}
		// 设置分页参数
		recommendMerchantCriteria.setPageSize(pageSize);
		recommendMerchantCriteria.setStartIndex((currentPage - 1) * pageSize);
		
		List<RecommendMerchant> recommendMerchants = recommendMerchantMapper.selectByCriteria(recommendMerchantCriteria);
		List<RecommendMerchant> items = new ArrayList<RecommendMerchant>();
		for(RecommendMerchant rm : recommendMerchants)
		{
			if(rm.getCustomerId() != null)
				rm.setCustomerStr("推荐人需要查Customer表");
			if(rm.getSubTime() != null)
				rm.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rm.getSubTime()));
			if(rm.getHandleTime() != null)
				rm.setHandleTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rm.getHandleTime()));
			if(rm.getHandleStatus() == Constants.Status.STATUS_WAIT_HANDLE)
				rm.setHandleStatusStr(Constants.Status.STATUS_WAIT_HANDLE_HTML);
			if(rm.getHandleStatus() == Constants.Status.STATUS_VIEWED)
				rm.setHandleStatusStr(Constants.Status.STATUS_VIEWED_HTML);
			if(rm.getHandleStatus() == Constants.Status.STATUS_HANDLED)
				rm.setHandleStatusStr(Constants.Status.STATUS_HANDLED_HTML);
			items.add(rm);
		}
		int totalCount = (int) recommendMerchantMapper.selectCountByCriteria(recommendMerchantCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public RecommendMerchant findById(long id)
	{
		RecommendMerchant rm = recommendMerchantMapper.selectByPrimaryKey(id);

		if(rm.getCustomerId() != null)
			rm.setCustomerStr("推荐人需要查Customer表");
		if(rm.getSubTime() != null)
			rm.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rm.getSubTime()));
		if(rm.getHandleTime() != null)
			rm.setHandleTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rm.getHandleTime()));
		if(rm.getHandleStatus() == Constants.Status.STATUS_WAIT_HANDLE)
			rm.setHandleStatusStr(Constants.Status.STATUS_WAIT_HANDLE_HTML);
		if(rm.getHandleStatus() == Constants.Status.STATUS_VIEWED)
			rm.setHandleStatusStr(Constants.Status.STATUS_VIEWED_HTML);
		if(rm.getHandleStatus() == Constants.Status.STATUS_HANDLED)
			rm.setHandleStatusStr(Constants.Status.STATUS_HANDLED_HTML);
		
		return rm;
	}

	@Override
	public List<RecommendMerchant> findAll()
	{
		return recommendMerchantMapper.selectByCriteria(null);
	}

	@Override
	public List<RecommendMerchant> findByCriteria(
			RecommendMerchantCriteria criteria)
	{
		return recommendMerchantMapper.selectByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List<RecommendMerchant> dataList = new ArrayList<RecommendMerchant>();
		for(RecommendMerchant rm : findAll())
		{
			if(rm.getCustomerId() != null)
				rm.setCustomerStr("推荐人需要查Customer表");
			if(rm.getSubTime() != null)
				rm.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rm.getSubTime()));
			if(rm.getHandleTime() != null)
				rm.setHandleTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rm.getHandleTime()));
			if(rm.getHandleStatus() == Constants.Status.STATUS_WAIT_HANDLE)
				rm.setHandleStatusStr(Constants.Status.STATUS_WAIT_HANDLE_STR);
			if(rm.getHandleStatus() == Constants.Status.STATUS_VIEWED)
				rm.setHandleStatusStr(Constants.Status.STATUS_VIEWED_STR);
			if(rm.getHandleStatus() == Constants.Status.STATUS_HANDLED)
				rm.setHandleStatusStr(Constants.Status.STATUS_HANDLED_STR);
			dataList.add(rm);
		}
		map.put("顾客推荐信息", dataList);
		return map;
	}
}