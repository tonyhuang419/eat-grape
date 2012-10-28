package com.eatle.service.foundation.business.impl;

import com.eatle.persistent.mapper.RecommendMerchantMapper;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchant;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchantCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.business.RecommendMerchantCriteria;
import com.eatle.service.foundation.business.IRecommendMerchantService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("recommendMerchantService")
public class RecommendMerchantServiceImpl implements IRecommendMerchantService
{
	@Resource
	private RecommendMerchantMapper recommendMerchantMapper;

	@Override
	public int add(RecommendMerchant entity)
	{
		return recommendMerchantMapper.insert(entity);
	}

	@Override
	public int delete(RecommendMerchant entity)
	{
		return recommendMerchantMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(RecommendMerchant entity)
	{
		return recommendMerchantMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		RecommendMerchantCriteria recommendMerchantCriteria = new RecommendMerchantCriteria();
		Criteria criteria = recommendMerchantCriteria.createCriteria();
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
		recommendMerchantCriteria.setPageSize(pageSize);
		recommendMerchantCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<RecommendMerchant> items = recommendMerchantMapper.selectByCriteria(recommendMerchantCriteria);
		int totalCount = (int) recommendMerchantMapper.selectCountByCriteria(recommendMerchantCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public RecommendMerchant findById(long id)
	{
		return recommendMerchantMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RecommendMerchant> findAll()
	{
		return recommendMerchantMapper.selectByCriteria(null);
	}

	@Override
	public List<RecommendMerchant> findByCriteria(
			RecommendMerchantCriteria criteria)
	{
		return recommendMerchantMapper.selectByCriteria(criteria);
	}
}