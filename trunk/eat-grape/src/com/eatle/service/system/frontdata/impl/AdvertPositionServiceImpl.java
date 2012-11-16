package com.eatle.service.system.frontdata.impl;

import com.eatle.persistent.mapper.AdvertPositionMapper;
import com.eatle.persistent.pojo.system.frontdata.AdvertPosition;
import com.eatle.persistent.pojo.system.frontdata.AdvertPositionCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.AdvertPositionCriteria;
import com.eatle.service.system.frontdata.IAdvertPositionService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("advertPositionService")
public class AdvertPositionServiceImpl implements IAdvertPositionService
{
	@Resource
	private AdvertPositionMapper advertPositionMapper;

	@Override
	public int add(AdvertPosition entity)
	{
		return advertPositionMapper.insert(entity);
	}

	@Override
	public int delete(AdvertPosition entity)
	{
		return advertPositionMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(AdvertPosition entity)
	{
		return advertPositionMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		AdvertPositionCriteria advertPositionCriteria = new AdvertPositionCriteria();
		Criteria criteria = advertPositionCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("name"))
			{
				criteria.andPositionNameLike("%" + (String) queryMap.get("name") + "%");
			}
		}
		// 设置分页参数
		advertPositionCriteria.setPageSize(pageSize);
		advertPositionCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<AdvertPosition> items = advertPositionMapper.selectByExampleWithBLOBs(advertPositionCriteria);
		int totalCount = (int) advertPositionMapper.selectCountByCriteria(advertPositionCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public AdvertPosition findById(long id)
	{
		return advertPositionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<AdvertPosition> findAll()
	{
		return advertPositionMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public List<AdvertPosition> findByCriteria(AdvertPositionCriteria criteria)
	{
		return advertPositionMapper.selectByExampleWithBLOBs(criteria);
	}
}