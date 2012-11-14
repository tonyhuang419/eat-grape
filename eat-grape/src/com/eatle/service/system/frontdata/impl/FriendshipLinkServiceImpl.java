package com.eatle.service.system.frontdata.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.FriendshipLinkMapper;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLink;
import com.eatle.persistent.pojo.system.frontdata.SystemNotice;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLinkCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLinkCriteria;
import com.eatle.service.system.frontdata.IFriendshipLinkService;
import com.eatle.utils.Pagination;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("friendshipLinkService")
public class FriendshipLinkServiceImpl implements IFriendshipLinkService
{
	@Resource
	private FriendshipLinkMapper friendshipLinkMapper;

	@Override
	public int add(FriendshipLink entity)
	{
		return friendshipLinkMapper.insert(entity);
	}

	@Override
	public int delete(FriendshipLink entity)
	{
		return friendshipLinkMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(FriendshipLink entity)
	{
		return friendshipLinkMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		FriendshipLinkCriteria friendshipLinkCriteria = new FriendshipLinkCriteria();
		Criteria criteria = friendshipLinkCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("name"))
			{
				criteria.andLinkNameLike("%" + (String) queryMap.get("name") + "%");
			}
			if (queryMap.containsKey("isDisplay"))
			{
				criteria.andIsDisplayEqualTo(Short.parseShort((String) queryMap.get("isDisplay")));
			}
		}
		// 设置分页参数
		friendshipLinkCriteria.setPageSize(pageSize);
		friendshipLinkCriteria.setStartIndex((currentPage - 1) * pageSize);
		
		List<FriendshipLink> items = new ArrayList<FriendshipLink>();
		List<FriendshipLink> friendshipLinks = friendshipLinkMapper.selectByCriteria(friendshipLinkCriteria);
		for(FriendshipLink fl : friendshipLinks)
		{
			if(fl.getIsDisplay() == Constants.FriendLink.FRIENDLINK_YES)
				fl.setIsDisplayStr(Constants.FriendLink.FRIENDLINK_YES_HTML);
			if(fl.getIsDisplay() == Constants.FriendLink.FRIENDLINK_NO)
				fl.setIsDisplayStr(Constants.FriendLink.FRIENDLINK_NO_HTML);
			
			items.add(fl);
		}
		
		int totalCount = (int) friendshipLinkMapper.selectCountByCriteria(friendshipLinkCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public FriendshipLink findById(long id)
	{
		FriendshipLink fl = friendshipLinkMapper.selectByPrimaryKey(id);
		
		if(fl.getIsDisplay() == Constants.FriendLink.FRIENDLINK_YES)
			fl.setIsDisplayStr(Constants.FriendLink.FRIENDLINK_YES_HTML);
		if(fl.getIsDisplay() == Constants.FriendLink.FRIENDLINK_NO)
			fl.setIsDisplayStr(Constants.FriendLink.FRIENDLINK_NO_HTML);
		
		return fl;
	}

	@Override
	public List<FriendshipLink> findAll()
	{
		return friendshipLinkMapper.selectByCriteria(null);
	}

	@Override
	public List<FriendshipLink> findByCriteria(FriendshipLinkCriteria criteria)
	{
		return friendshipLinkMapper.selectByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		
		List<FriendshipLink> dataList = new ArrayList<FriendshipLink>();
		for(FriendshipLink fl : findAll())
		{
			if(fl.getIsDisplay() == Constants.FriendLink.FRIENDLINK_YES)
				fl.setIsDisplayStr(Constants.FriendLink.FRIENDLINK_YES_STR);
			if(fl.getIsDisplay() == Constants.FriendLink.FRIENDLINK_NO)
				fl.setIsDisplayStr(Constants.FriendLink.FRIENDLINK_NO_STR);
			
			dataList.add(fl);
		}
		map.put("友情链接", dataList);
		return map;
	}
}