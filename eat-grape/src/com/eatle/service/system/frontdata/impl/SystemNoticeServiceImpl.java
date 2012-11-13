package com.eatle.service.system.frontdata.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.SystemNoticeMapper;
import com.eatle.persistent.mapper.UserMapper;
import com.eatle.persistent.pojo.system.frontdata.SystemNotice;
import com.eatle.persistent.pojo.system.frontdata.SystemNoticeCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.SystemNoticeCriteria;
import com.eatle.service.system.frontdata.ISystemNoticeService;
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

@Service("systemNoticeService")
public class SystemNoticeServiceImpl implements ISystemNoticeService
{
	@Resource
	private SystemNoticeMapper systemNoticeMapper;
	
	@Resource
	private UserMapper userMapper;

	@Override
	public int add(SystemNotice entity)
	{
		return systemNoticeMapper.insert(entity);
	}

	@Override
	public int delete(SystemNotice entity)
	{
		return systemNoticeMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(SystemNotice entity)
	{
		return systemNoticeMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize) throws ParseException
	{
		SystemNoticeCriteria systemNoticeCriteria = new SystemNoticeCriteria();
		Criteria criteria = systemNoticeCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("title"))
			{
				criteria.andTitleLike("%" + (String) queryMap.get("title") + "%");
			}
			if (queryMap.containsKey("content"))
			{
				criteria.andContentLike("%" + (String) queryMap.get("content") + "%");
			}
			if (queryMap.containsKey("startTime"))
			{
				if(queryMap.containsKey("endTime"))
				{
					criteria.andSendTimeBetween(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("startTime")), 
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("endTime")));
				}
				else
				{
					criteria.andSendTimeBetween(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) queryMap.get("startTime")), 
						new Date());
				}
			}
			if (queryMap.containsKey("target"))
			{
				criteria.andTargetEqualTo(Short.parseShort((String) queryMap.get("target")));
			}
		}
		// 设置分页参数
		systemNoticeCriteria.setPageSize(pageSize);
		systemNoticeCriteria.setStartIndex((currentPage - 1) * pageSize);

		List<SystemNotice> items = new ArrayList<SystemNotice>();
		List<SystemNotice> systemNotices = systemNoticeMapper.selectByCriteria(systemNoticeCriteria);
		for(SystemNotice sn : systemNotices)
		{
			// 公告人
			if(sn.getUserId() != null)
				sn.setUserStr(userMapper.selectByPrimaryKey(sn.getUserId()).getUserName());
			// 公告时间
			if(sn.getSendTime() != null)
				sn.setSendTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sn.getSendTime()));
			// 公告对象
			if(sn.getTarget() == Constants.UserIdentity.USERIDENTITY_MERCHANT)
				sn.setTargetStr(Constants.UserIdentity.USERIDENTITY_MERCHANT_HTML);
			if(sn.getTarget() == Constants.UserIdentity.USERIDENTITY_CUSTOMER)
				sn.setTargetStr(Constants.UserIdentity.USERIDENTITY_CUSTOMER_HTML);
			
			items.add(sn);
		}
		int totalCount = (int) systemNoticeMapper.selectCountByCriteria(systemNoticeCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public SystemNotice findById(long id)
	{
		SystemNotice sn = systemNoticeMapper.selectByPrimaryKey(id);
		
		// 公告人
		if(sn.getUserId() != null)
			sn.setUserStr(userMapper.selectByPrimaryKey(sn.getUserId()).getUserName());
		// 公告时间
		if(sn.getSendTime() != null)
			sn.setSendTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sn.getSendTime()));
		// 公告对象
		if(sn.getTarget() == Constants.UserIdentity.USERIDENTITY_MERCHANT)
			sn.setTargetStr(Constants.UserIdentity.USERIDENTITY_MERCHANT_HTML);
		if(sn.getTarget() == Constants.UserIdentity.USERIDENTITY_CUSTOMER)
			sn.setTargetStr(Constants.UserIdentity.USERIDENTITY_CUSTOMER_HTML);
		
		return sn;
	}

	@Override
	public List<SystemNotice> findAll()
	{
		return systemNoticeMapper.selectByCriteria(null);
	}

	@Override
	public List<SystemNotice> findByCriteria(SystemNoticeCriteria criteria)
	{
		return systemNoticeMapper.selectByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		
		List<SystemNotice> dataList = new ArrayList<SystemNotice>();
		for(SystemNotice sn : findAll())
		{
			// 公告人
			if(sn.getUserId() != null)
				sn.setUserStr(userMapper.selectByPrimaryKey(sn.getUserId()).getUserName());
			// 公告时间
			if(sn.getSendTime() != null)
				sn.setSendTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sn.getSendTime()));
			// 公告对象
			if(sn.getTarget() == Constants.UserIdentity.USERIDENTITY_MERCHANT)
				sn.setTargetStr(Constants.UserIdentity.USERIDENTITY_MERCHANT_STR);
			if(sn.getTarget() == Constants.UserIdentity.USERIDENTITY_CUSTOMER)
				sn.setTargetStr(Constants.UserIdentity.USERIDENTITY_CUSTOMER_STR);
			
			dataList.add(sn);
		}
		map.put("系统公告", dataList);
		return map;
	}
}