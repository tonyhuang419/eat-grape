package com.eatle.service.foundation.dictionary.impl;

import com.eatle.persistent.mapper.SendRemarkMapper;
import com.eatle.persistent.pojo.foundation.dictionary.SendRemark;
import com.eatle.persistent.pojo.foundation.dictionary.SendRemarkCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.dictionary.SendRemarkCriteria;
import com.eatle.service.foundation.dictionary.ISendRemarkService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("sendRemarkService")
public class SendRemarkServiceImpl implements ISendRemarkService
{
	@Resource
	private SendRemarkMapper sendRemarkMapper;

	@Override
	public int add(SendRemark entity)
	{
		return sendRemarkMapper.insert(entity);
	}

	@Override
	public int delete(SendRemark entity)
	{
		return sendRemarkMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(SendRemark entity)
	{
		return sendRemarkMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		SendRemarkCriteria sendRemarkCriteria = new SendRemarkCriteria();
		Criteria criteria = sendRemarkCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("word"))
			{
				criteria.andWordLike("%" + (String) queryMap.get("word") + "%");
			}
		}
		// 设置分页参数
		sendRemarkCriteria.setPageSize(pageSize);
		sendRemarkCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<SendRemark> items = sendRemarkMapper.selectByCriteria(sendRemarkCriteria);
		int totalCount = (int) sendRemarkMapper.selectCountByCriteria(sendRemarkCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public SendRemark findById(long id)
	{
		return sendRemarkMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SendRemark> findAll()
	{
		return sendRemarkMapper.selectByCriteria(null);
	}

	@Override
	public List<SendRemark> findByCriteria(SendRemarkCriteria criteria)
	{
		return sendRemarkMapper.selectByCriteria(criteria);
	}
}