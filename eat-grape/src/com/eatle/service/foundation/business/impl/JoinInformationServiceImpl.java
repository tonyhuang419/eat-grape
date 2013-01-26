package com.eatle.service.foundation.business.impl;

import com.eatle.persistent.mapper.JoinInformationMapper;
import com.eatle.persistent.pojo.foundation.business.JoinInformation;
import com.eatle.persistent.pojo.foundation.business.JoinInformationCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.business.JoinInformationCriteria;
import com.eatle.service.foundation.business.IJoinInformationService;
import com.eatle.utils.Pagination;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@Resource
	private Map<String, String> auditStatusStr;
	
	@Resource
	private Map<String, String> auditStatusHtml;

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
		
		List<JoinInformation> items = joinInformationMapper.selectByCriteria(joinInformationCriteria);
		for(JoinInformation info : items)
		{
			// 申请时间
			if(info.getSubTime() != null)
				info.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getSubTime()));
			// 审核状态
			info.setAuditStatusStr(auditStatusHtml.get("" + info.getAuditStatus()));
			// 审核时间
			if(info.getAuditTime() != null)
				info.setAuditTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getAuditTime()));
		}
		int totalCount = (int) joinInformationMapper.selectCountByCriteria(joinInformationCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public JoinInformation findById(long id)
	{
		JoinInformation info = joinInformationMapper.selectByPrimaryKey(id);

		// 申请时间
		if(info.getSubTime() != null)
			info.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getSubTime()));
		// 审核状态
		info.setAuditStatusStr(auditStatusHtml.get("" + info.getAuditStatus()));
		// 审核时间
		if(info.getAuditTime() != null)
			info.setAuditTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getAuditTime()));
		
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
		List<JoinInformation> dataList = findAll();
		for(JoinInformation info : dataList)
		{
			// 申请时间
			if(info.getSubTime() != null)
				info.setSubTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getSubTime()));
			// 审核状态
			info.setAuditStatusStr(auditStatusStr.get("" + info.getAuditStatus()));
			// 审核时间
			if(info.getAuditTime() != null)
				info.setAuditTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info.getAuditTime()));
		}
		map.put("加盟审核信息", dataList);
		return map;
	}
}