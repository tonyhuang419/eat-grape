package com.eatle.service.system.frontdata.impl;

import com.eatle.persistent.mapper.FriendshipLinkMapper;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLink;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLinkCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLinkCriteria;
import com.eatle.service.system.frontdata.IFriendshipLinkService;
import com.eatle.utils.Pagination;

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
	
	@Resource
	private Map<String, String> showFriendLinkStr;
	
	@Resource
	private Map<String, String> showFriendLinkHtml;

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
		
		List<FriendshipLink> items = friendshipLinkMapper.selectByCriteria(friendshipLinkCriteria);
		for(FriendshipLink fl : items)
		{
			fl.setIsDisplayStr(showFriendLinkHtml.get("" + fl.getIsDisplay()));
		}
		
		int totalCount = (int) friendshipLinkMapper.selectCountByCriteria(friendshipLinkCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public FriendshipLink findById(long id)
	{
		FriendshipLink fl = friendshipLinkMapper.selectByPrimaryKey(id);
		fl.setIsDisplayStr(showFriendLinkHtml.get("" + fl.getIsDisplay()));
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
		
		List<FriendshipLink> dataList = findAll();
		for(FriendshipLink fl : dataList)
		{
			fl.setIsDisplayStr(showFriendLinkStr.get("" + fl.getIsDisplay()));			
		}
		map.put("友情链接", dataList);
		return map;
	}
}