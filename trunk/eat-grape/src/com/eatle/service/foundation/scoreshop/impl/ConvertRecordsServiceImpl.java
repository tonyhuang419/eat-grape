package com.eatle.service.foundation.scoreshop.impl;

import com.eatle.persistent.mapper.ConvertRecordsMapper;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecords;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecordsCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecordsCriteria;
import com.eatle.service.foundation.scoreshop.IConvertRecordsService;
import com.eatle.utils.Pagination;
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
		ConvertRecordsCriteria convertRecordsCriteria = new ConvertRecordsCriteria();
		Criteria criteria = convertRecordsCriteria.createCriteria();
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
		convertRecordsCriteria.setPageSize(pageSize);
		convertRecordsCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<ConvertRecords> items = convertRecordsMapper.selectByCriteria(convertRecordsCriteria);
		int totalCount = (int) convertRecordsMapper.selectCountByCriteria(convertRecordsCriteria);
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
}