package com.eatle.service.foundation.dictionary.impl;

import com.eatle.persistent.mapper.MenuFeatureMapper;
import com.eatle.persistent.pojo.foundation.dictionary.MenuFeature;
import com.eatle.persistent.pojo.foundation.dictionary.MenuFeatureCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.dictionary.MenuFeatureCriteria;
import com.eatle.service.foundation.dictionary.IMenuFeatureService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("menuFeatureService")
public class MenuFeatureServiceImpl implements IMenuFeatureService
{
	@Resource
	private MenuFeatureMapper menuFeatureMapper;

	@Override
	public int add(MenuFeature entity)
	{
		return menuFeatureMapper.insert(entity);
	}

	@Override
	public int delete(MenuFeature entity)
	{
		return menuFeatureMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(MenuFeature entity)
	{
		return menuFeatureMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		MenuFeatureCriteria menuFeatureCriteria = new MenuFeatureCriteria();
		Criteria criteria = menuFeatureCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("feature"))
			{
				criteria.andFeatureLike("%" + (String) queryMap.get("feature") + "%");
			}
		}
		// 设置分页参数
		menuFeatureCriteria.setPageSize(pageSize);
		menuFeatureCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<MenuFeature> items = menuFeatureMapper.selectByCriteria(menuFeatureCriteria);
		int totalCount = (int) menuFeatureMapper.selectCountByCriteria(menuFeatureCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public MenuFeature findById(long id)
	{
		return menuFeatureMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MenuFeature> findAll()
	{
		return menuFeatureMapper.selectByCriteria(null);
	}

	@Override
	public List<MenuFeature> findByCriteria(MenuFeatureCriteria criteria)
	{
		return menuFeatureMapper.selectByCriteria(criteria);
	}
}