package com.eatle.service.foundation.place.impl;

import com.eatle.persistent.mapper.DistrictMapper;
import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("districtService")
public class DistrictServiceImpl implements IDistrictService
{
	@Resource
	private DistrictMapper districtMapper;

	@Override
	public int add(District entity)
	{
		return districtMapper.insert(entity);
	}

	@Override
	public int delete(District entity)
	{
		return districtMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(District entity)
	{
		return districtMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		DistrictCriteria districtCriteria = new DistrictCriteria();
		Criteria criteria = districtCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("name"))
			{
				criteria.andNameLike("%" + (String) queryMap.get("name") + "%");
			}
			if (queryMap.containsKey("pinyinName"))
			{
				criteria.andPinyinNameLike("%" + (String) queryMap.get("pinyinName") + "%");
			}

			if (queryMap.containsKey("pidIsNull"))
			{
				criteria.andParentIdIsNull();
			}
		}
		// 设置分页参数
		districtCriteria.setPageSize(pageSize);
		districtCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<District> items = districtMapper.selectByCriteria(districtCriteria);
		int totalCount = (int) districtMapper.selectCountByCriteria(districtCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public District findById(long id)
	{
		return districtMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<District> findAll()
	{
		return districtMapper.selectByCriteria(null);
	}

	@Override
	public List<District> findByCriteria(DistrictCriteria criteria)
	{
		return districtMapper.selectByCriteria(criteria);
	}

	@Override
	public void findAllFatherById(long id, StringBuffer fatherStr)
	{
		District district = findById(id);
		if(district != null)
		{
			fatherStr.append(district.getName() + ";");
			if(district.getParentId() != null)
			{
				findAllFatherById(district.getParentId(), fatherStr);
			}
		}
	}
}