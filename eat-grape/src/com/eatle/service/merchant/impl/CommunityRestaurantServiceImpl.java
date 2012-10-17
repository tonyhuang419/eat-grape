package com.eatle.service.merchant.impl;

import com.eatle.persistent.mapper.CommunityRestaurantMapper;
import com.eatle.persistent.pojo.merchant.CommunityRestaurant;
import com.eatle.persistent.pojo.merchant.CommunityRestaurantCriteria.Criteria;
import com.eatle.persistent.pojo.merchant.CommunityRestaurantCriteria;
import com.eatle.service.merchant.ICommunityRestaurantService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("communityRestaurantService")
public class CommunityRestaurantServiceImpl implements ICommunityRestaurantService
{
	@Resource
	private CommunityRestaurantMapper communityRestaurantMapper;

	@Override
	public int add(CommunityRestaurant entity)
	{
		return communityRestaurantMapper.insert(entity);
	}

	@Override
	public int delete(CommunityRestaurant entity)
	{
		return communityRestaurantMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(CommunityRestaurant entity)
	{
		return communityRestaurantMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		CommunityRestaurantCriteria communityRestaurantCriteria = new CommunityRestaurantCriteria();
		Criteria criteria = communityRestaurantCriteria.createCriteria();
		// 设置搜索条件参数
		// if(queryMap != null){
		// if(queryMap.containsKey("username")){
		// criteria.andUserNameLike("%"+(String)queryMap.get("username")+"%");
		// }
		// if(queryMap.containsKey("email")){
		// criteria.andEmailLike((String)queryMap.get("email"));
		// }
		// }
		// 设置分页参数
		communityRestaurantCriteria.setPageSize(pageSize);
		communityRestaurantCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<CommunityRestaurant> items = communityRestaurantMapper.selectByCriteria(communityRestaurantCriteria);
		int totalCount = (int) communityRestaurantMapper.selectCountByCriteria(communityRestaurantCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public CommunityRestaurant findById(long id)
	{
		return communityRestaurantMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CommunityRestaurant> findAll()
	{
		return communityRestaurantMapper.selectByCriteria(null);
	}

	@Override
	public List<CommunityRestaurant> findByCriteria(
			CommunityRestaurantCriteria criteria)
	{
		return communityRestaurantMapper.selectByCriteria(criteria);
	}
}