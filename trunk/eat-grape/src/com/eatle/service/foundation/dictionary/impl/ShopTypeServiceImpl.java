package com.eatle.service.foundation.dictionary.impl;

import com.eatle.persistent.mapper.ShopTypeMapper;
import com.eatle.persistent.pojo.foundation.dictionary.ShopType;
import com.eatle.persistent.pojo.foundation.dictionary.ShopTypeCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.dictionary.ShopTypeCriteria;
import com.eatle.service.foundation.dictionary.IShopTypeService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("shopTypeService")
public class ShopTypeServiceImpl implements IShopTypeService
{
	@Resource
	private ShopTypeMapper shopTypeMapper;

	@Override
	public int add(ShopType entity)
	{
		return shopTypeMapper.insert(entity);
	}

	@Override
	public int delete(ShopType entity)
	{
		return shopTypeMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(ShopType entity)
	{
		return shopTypeMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		ShopTypeCriteria shopTypeCriteria = new ShopTypeCriteria();
		Criteria criteria = shopTypeCriteria.createCriteria();
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
		shopTypeCriteria.setPageSize(pageSize);
		shopTypeCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<ShopType> items = shopTypeMapper.selectByCriteria(shopTypeCriteria);
		int totalCount = (int) shopTypeMapper.selectCountByCriteria(shopTypeCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public ShopType findById(long id)
	{
		return shopTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ShopType> findAll()
	{
		return shopTypeMapper.selectByCriteria(null);
	}

	@Override
	public List<ShopType> findByCriteria(ShopTypeCriteria criteria)
	{
		return shopTypeMapper.selectByCriteria(criteria);
	}
}