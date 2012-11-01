package com.eatle.service.foundation.business.impl;

import com.eatle.persistent.mapper.FeedbackMapper;
import com.eatle.persistent.pojo.foundation.business.Feedback;
import com.eatle.persistent.pojo.foundation.business.FeedbackCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.business.FeedbackCriteria;
import com.eatle.service.foundation.business.IFeedbackService;
import com.eatle.utils.Pagination;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("feedbackService")
public class FeedbackServiceImpl implements IFeedbackService
{
	@Resource
	private FeedbackMapper feedbackMapper;

	@Override
	public int add(Feedback entity)
	{
		return feedbackMapper.insert(entity);
	}

	@Override
	public int delete(Feedback entity)
	{
		return feedbackMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Feedback entity)
	{
		return feedbackMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		FeedbackCriteria feedbackCriteria = new FeedbackCriteria();
		Criteria criteria = feedbackCriteria.createCriteria();
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
		feedbackCriteria.setPageSize(pageSize);
		feedbackCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Feedback> items = feedbackMapper.selectByCriteria(feedbackCriteria);
		int totalCount = (int) feedbackMapper.selectCountByCriteria(feedbackCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Feedback findById(long id)
	{
		return feedbackMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Feedback> findAll()
	{
		return feedbackMapper.selectByCriteria(null);
	}

	@Override
	public List<Feedback> findByCriteria(FeedbackCriteria criteria)
	{
		return feedbackMapper.selectByCriteria(criteria);
	}

	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		return null;
	}
}