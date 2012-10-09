package com.eatle.service.foundation.place.impl;

import com.eatle.persistent.mapper.CommunityMapper;
import com.eatle.persistent.pojo.foundation.place.Community;
import com.eatle.persistent.pojo.foundation.place.CommunityCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.place.CommunityCriteria;
import com.eatle.service.foundation.place.ICommunityService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("communityService")
public class CommunityServiceImpl implements ICommunityService
{
	@Resource
	private CommunityMapper communityMapper;

	@Override
	public int add(Community entity)
	{
		return communityMapper.insert(entity);
	}

	@Override
	public int delete(Community entity)
	{
		return communityMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Community entity)
	{
		return communityMapper.updateByPrimaryKey(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		CommunityCriteria communityCriteria = new CommunityCriteria();
		Criteria criteria = communityCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("name"))
			{
				criteria.andNameLike("%" + (String) queryMap.get("name") + "%");
			}
			if (queryMap.containsKey("pinyinName"))
			{
				criteria.andPinyinNameLike((String) queryMap.get("pinyinName"));
			}
		}
		// 设置分页参数
		communityCriteria.setPageSize(pageSize);
		communityCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Community> items = communityMapper.selectByCriteria(communityCriteria);
		int totalCount = (int) communityMapper.selectCountByCriteria(communityCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Community findById(long id)
	{
		return communityMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Community> findAll()
	{
		return communityMapper.selectByCriteria(null);
	}

	@Override
	public List<Community> findByCriteria(CommunityCriteria criteria)
	{
		return communityMapper.selectByCriteria(criteria);
	}
}