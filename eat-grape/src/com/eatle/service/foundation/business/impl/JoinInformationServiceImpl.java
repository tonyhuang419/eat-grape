package com.eatle.service.foundation.business.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.JoinInformationMapper;
import com.eatle.persistent.pojo.foundation.business.JoinInformation;
import com.eatle.persistent.pojo.foundation.business.JoinInformationCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.business.JoinInformationCriteria;
import com.eatle.service.foundation.business.IJoinInformationService;
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

@Service("joinInformationService")
public class JoinInformationServiceImpl implements IJoinInformationService
{
	@Resource
	private JoinInformationMapper joinInformationMapper;

	@Override
	public int add(JoinInformation entity)
	{
		return joinInformationMapper.insert(entity);
	}

	@Override
	public int delete(JoinInformation entity)
	{
		return joinInformationMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(JoinInformation entity)
	{
		return joinInformationMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize) throws ParseException
	{
		JoinInformationCriteria joinInformationCriteria = new JoinInformationCriteria();
		Criteria criteria = joinInformationCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap != null)
			{
				if (queryMap.containsKey("shopName"))
				{
					criteria.andShopNameLike("%" + (String) queryMap.get("shopName") + "%");
				}
				if (queryMap.containsKey("linkMan"))
				{
					criteria.andLinkManLike("%" + (String) queryMap.get("linkMan") + "%");
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
				if(queryMap.containsKey("auditStatus"))
				{
					criteria.andAuditStatusEqualTo(Short.parseShort((String) queryMap.get("auditStatus")));
				}
			}
		}
		// 设置分页参数
		joinInformationCriteria.setPageSize(pageSize);
		joinInformationCriteria.setStartIndex((currentPage - 1) * pageSize);
		
		List<JoinInformation> joinInformations = joinInformationMapper.selectByCriteria(joinInformationCriteria);
		List<JoinInformation> items = new ArrayList<JoinInformation>();
		for(JoinInformation info : joinInformations)
		{
			if(info.getSubTime() != null)
				info.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getSubTime()));
			if(info.getAuditTime() != null)
				info.setAuditTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getAuditTime()));
			if(info.getAuditStatus() == Constants.Status.STATUS_WAIT_AUDIT)
				info.setAuditStatusStr(Constants.Status.STATUS_WAIT_AUDIT_HTML);
			if(info.getAuditStatus() == Constants.Status.STATUS_VIEWED)
				info.setAuditStatusStr(Constants.Status.STATUS_VIEWED_HTML);
			if(info.getAuditStatus() == Constants.Status.STATUS_COMPLETED)
				info.setAuditStatusStr(Constants.Status.STATUS_COMPLETED_HTML);
			items.add(info);
		}
		int totalCount = (int) joinInformationMapper.selectCountByCriteria(joinInformationCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public JoinInformation findById(long id)
	{
		JoinInformation info = joinInformationMapper.selectByPrimaryKey(id);

		if(info.getSubTime() != null)
			info.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getSubTime()));
		if(info.getAuditTime() != null)
			info.setAuditTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getAuditTime()));
		if(info.getAuditStatus() == Constants.Status.STATUS_WAIT_AUDIT)
			info.setAuditStatusStr(Constants.Status.STATUS_WAIT_AUDIT_HTML);
		if(info.getAuditStatus() == Constants.Status.STATUS_VIEWED)
			info.setAuditStatusStr(Constants.Status.STATUS_VIEWED_HTML);
		if(info.getAuditStatus() == Constants.Status.STATUS_COMPLETED)
			info.setAuditStatusStr(Constants.Status.STATUS_COMPLETED_HTML);
		
		return info;
	}

	@Override
	public List<JoinInformation> findAll()
	{
		return joinInformationMapper.selectByCriteria(null);
	}

	@Override
	public List<JoinInformation> findByCriteria(JoinInformationCriteria criteria)
	{
		return joinInformationMapper.selectByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List<JoinInformation> dataList = new ArrayList<JoinInformation>();
		for(JoinInformation info : findAll())
		{
			if(info.getSubTime() != null)
				info.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getSubTime()));
			if(info.getAuditTime() != null)
				info.setAuditTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getAuditTime()));
			if(info.getAuditStatus() == Constants.Status.STATUS_WAIT_AUDIT)
				info.setAuditStatusStr(Constants.Status.STATUS_WAIT_AUDIT_STR);
			if(info.getAuditStatus() == Constants.Status.STATUS_VIEWED)
				info.setAuditStatusStr(Constants.Status.STATUS_VIEWED_STR);
			if(info.getAuditStatus() == Constants.Status.STATUS_COMPLETED)
				info.setAuditStatusStr(Constants.Status.STATUS_COMPLETED_STR);
			dataList.add(info);
		}
		map.put("加盟审核信息", dataList);
		return map;
	}
}