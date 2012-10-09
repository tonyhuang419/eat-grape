package com.eatle.service.foundation.place.impl;

import com.eatle.persistent.mapper.SchoolMapper;
import com.eatle.persistent.pojo.foundation.place.School;
import com.eatle.persistent.pojo.foundation.place.SchoolCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.place.SchoolCriteria;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.service.foundation.place.ISchoolService;
import com.eatle.utils.Pagination;
import com.eatle.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("schoolService")
public class SchoolServiceImpl implements ISchoolService
{
	@Resource
	private SchoolMapper schoolMapper;
	
	@Resource
	private IDistrictService districtService;

	@Override
	public int add(School entity)
	{
		return schoolMapper.insert(entity);
	}

	@Override
	public int delete(School entity)
	{
		return schoolMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(School entity)
	{
		return schoolMapper.updateByPrimaryKey(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		SchoolCriteria schoolCriteria = new SchoolCriteria();
		Criteria criteria = schoolCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("name"))
			{
				criteria.andNameLike("%" + (String) queryMap.get("name") + "%");
			}
			if (queryMap.containsKey("englishName"))
			{
				criteria.andEnglishNameLike("%" + (String) queryMap.get("englishName") + "%");
			}
		}
		// 设置分页参数
		schoolCriteria.setPageSize(pageSize);
		schoolCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<School> schools = schoolMapper.selectByCriteria(schoolCriteria);
		// 结果集处理所属完整区域字符串
		List<School> items = new ArrayList<School>();
		for(School s : schools)
		{
			StringBuffer sb = new StringBuffer();
			districtService.findAllFatherById(s.getDistrictId(), sb);
			s.setDistrictName(StringUtil.reverseStrAsSplitStr(sb.toString(), ";"));
			items.add(s);
		}
		int totalCount = (int) schoolMapper.selectCountByCriteria(schoolCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public School findById(long id)
	{
		return schoolMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<School> findAll()
	{
		return schoolMapper.selectByCriteria(null);
	}

	@Override
	public List<School> findByCriteria(SchoolCriteria criteria)
	{
		return schoolMapper.selectByCriteria(criteria);
	}
}