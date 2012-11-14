package com.eatle.service.system.frontdata.impl;

import com.eatle.persistent.mapper.AdvertMapper;
import com.eatle.persistent.pojo.system.frontdata.Advert;
import com.eatle.persistent.pojo.system.frontdata.AdvertCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.AdvertCriteria;
import com.eatle.service.system.frontdata.IAdvertService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("advertService")
public class AdvertServiceImpl implements IAdvertService
{
	@Resource
	private AdvertMapper advertMapper;

	@Override
	public int add(Advert entity)
	{
		return advertMapper.insert(entity);
	}

	@Override
	public int delete(Advert entity)
	{
		return advertMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Advert entity)
	{
		return advertMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		AdvertCriteria advertCriteria = new AdvertCriteria();
		Criteria criteria = advertCriteria.createCriteria();
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
		advertCriteria.setPageSize(pageSize);
		advertCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Advert> items = advertMapper.selectByCriteria(advertCriteria);
		int totalCount = (int) advertMapper
				.selectCountByCriteria(advertCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Advert findById(long id)
	{
		return advertMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Advert> findAll()
	{
		return advertMapper.selectByCriteria(null);
	}

	@Override
	public List<Advert> findByCriteria(AdvertCriteria criteria)
	{
		return advertMapper.selectByCriteria(criteria);
	}
}