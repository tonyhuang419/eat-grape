package com.eatle.service.merchant.impl;

import com.eatle.persistent.mapper.SchoolRestaurantMapper;
import com.eatle.persistent.pojo.foundation.place.School;
import com.eatle.persistent.pojo.merchant.SchoolRestaurant;
import com.eatle.persistent.pojo.merchant.SchoolRestaurantCriteria.Criteria;
import com.eatle.persistent.pojo.merchant.SchoolRestaurantCriteria;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.service.merchant.ISchoolRestaurantService;
import com.eatle.utils.Pagination;
import com.eatle.utils.StringUtil;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("schoolRestaurantService")
public class SchoolRestaurantServiceImpl implements ISchoolRestaurantService
{
	@Resource
	private SchoolRestaurantMapper schoolRestaurantMapper;
	
	@Resource
	private IDistrictService districtService;

	@Override
	public int add(SchoolRestaurant entity)
	{
		return schoolRestaurantMapper.insert(entity);
	}

	@Override
	public int delete(SchoolRestaurant entity)
	{
		return schoolRestaurantMapper.deleteByPrimaryKey(entity.getId());
	}
	
	@Override
	public int deleteBySelective(SchoolRestaurant entity)
	{
		return schoolRestaurantMapper.deleteBySelective(entity);
	}

	@Override
	public int update(SchoolRestaurant entity)
	{
		return schoolRestaurantMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize)
	{
		SchoolRestaurantCriteria schoolRestaurantCriteria = new SchoolRestaurantCriteria();
		Criteria criteria = schoolRestaurantCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("restaurantId"))
			{
				criteria.andRestaurantIdEqualTo((Long) queryMap.get("restaurantId"));
			}
		}
		// 设置分页参数
		schoolRestaurantCriteria.setPageSize(pageSize);
		schoolRestaurantCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<SchoolRestaurant> items = schoolRestaurantMapper.selectByCriteria(schoolRestaurantCriteria);
		int totalCount = (int) schoolRestaurantMapper.selectCountByCriteria(schoolRestaurantCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public SchoolRestaurant findById(long id)
	{
		return schoolRestaurantMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SchoolRestaurant> findAll()
	{
		return schoolRestaurantMapper.selectByCriteria(null);
	}

	@Override
	public List<SchoolRestaurant> findByCriteria(SchoolRestaurantCriteria criteria)
	{
		return schoolRestaurantMapper.selectByCriteria(criteria);
	}

	@Override
	public Pagination getSendSchoolsByRestaurantId(
			Map<String, Object> queryMap, int currentPage, int pageSize)
	{
		int totalCount = (int) schoolRestaurantMapper.selectSendSchoolsCountByRestaurantId(queryMap);
		
		queryMap.put("startIndex", (currentPage - 1) * pageSize);
		queryMap.put("pageSize", pageSize);
		
		List<School> items = schoolRestaurantMapper.selectSendSchoolsByRestaurantId(queryMap);
		
		// 设置所属区域的全名
		for(School s : items)
		{
			StringBuffer districtName = new StringBuffer();
			districtService.findAllFatherById(s.getDistrictId(), districtName);
			s.setDistrictName(StringUtil.reverseStrAsSplitStr(districtName.toString(), ";"));
		}
		
		return new Pagination(pageSize, currentPage, totalCount, items);
	}
}