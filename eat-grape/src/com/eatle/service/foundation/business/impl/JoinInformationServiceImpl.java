package com.eatle.service.foundation.business.impl;

import com.eatle.persistent.mapper.JoinInformationMapper;
import com.eatle.persistent.pojo.foundation.business.JoinInformation;
import com.eatle.persistent.pojo.foundation.business.JoinInformationCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.business.JoinInformationCriteria;
import com.eatle.service.foundation.business.IJoinInformationService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("joinInformationService")
public class JoinInformationServiceImpl implements IJoinInformationService
{
	@Resource
	private JoinInformationMapper joinInformationMapper;

	@Override
	public int add(JoinInformation entity)
	{
		return joinInformationMapper.insert(entity);
	}

	@Override
	public int delete(JoinInformation entity)
	{
		return joinInformationMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(JoinInformation entity)
	{
		return joinInformationMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		JoinInformationCriteria joinInformationCriteria = new JoinInformationCriteria();
		Criteria criteria = joinInformationCriteria.createCriteria();
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
		joinInformationCriteria.setPageSize(pageSize);
		joinInformationCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<JoinInformation> items = joinInformationMapper.selectByCriteria(joinInformationCriteria);
		int totalCount = (int) joinInformationMapper.selectCountByCriteria(joinInformationCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public JoinInformation findById(long id)
	{
		return joinInformationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<JoinInformation> findAll()
	{
		return joinInformationMapper.selectByCriteria(null);
	}

	@Override
	public List<JoinInformation> findByCriteria(JoinInformationCriteria criteria)
	{
		return joinInformationMapper.selectByCriteria(criteria);
	}
}