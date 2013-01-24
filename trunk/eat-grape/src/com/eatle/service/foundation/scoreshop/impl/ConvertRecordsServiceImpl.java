package com.eatle.service.foundation.scoreshop.impl;

import com.eatle.persistent.mapper.ConvertRecordsMapper;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecords;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecordsCriteria;
import com.eatle.service.foundation.scoreshop.IConvertRecordsService;
import com.eatle.utils.Pagination;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("convertRecordsService")
public class ConvertRecordsServiceImpl implements IConvertRecordsService
{
	@Resource
	private ConvertRecordsMapper convertRecordsMapper;

	@Override
	public int add(ConvertRecords entity)
	{
		return convertRecordsMapper.insert(entity);
	}

	@Override
	public int delete(ConvertRecords entity)
	{
		return convertRecordsMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(ConvertRecords entity)
	{
		return convertRecordsMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		int totalCount = (int) convertRecordsMapper.selectConvertRecordsCountByCondition(queryMap);
		
		queryMap.put("startIndex", (currentPage - 1) * pageSize);
		queryMap.put("pageSize", pageSize);
		
		List<ConvertRecords> items = convertRecordsMapper.selectConvertRecordsByCondition(queryMap);
		for(ConvertRecords cr : items)
		{
			cr.setConvertTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cr.getConvertTime()));
		}

		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public ConvertRecords findById(long id)
	{
		return convertRecordsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ConvertRecords> findAll()
	{
		return convertRecordsMapper.selectByCriteria(null);
	}

	@Override
	public List<ConvertRecords> findByCriteria(ConvertRecordsCriteria criteria)
	{
		return convertRecordsMapper.selectByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		
		List<ConvertRecords> items = convertRecordsMapper.selectConvertRecordsByCondition(null);
		for(ConvertRecords cr : items)
		{
			cr.setConvertTimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cr.getConvertTime()));
		}
		map.put("商品兑换记录", items);
		
		return map;
	}
}