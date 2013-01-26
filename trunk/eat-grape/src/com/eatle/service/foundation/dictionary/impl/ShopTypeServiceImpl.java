package com.eatle.service.foundation.dictionary.impl;

import com.eatle.common.Constants;
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
	public int add(ShopType shopType)
	{
		int result = Constants.Base.FAIL;
		
		ShopTypeCriteria shopTypeCriteria = new ShopTypeCriteria();
		Criteria criteria = shopTypeCriteria.createCriteria();
		criteria.andTypeIdentifyEqualTo(shopType.getTypeIdentify());
		List<ShopType> shopTypes = shopTypeMapper.selectByCriteria(shopTypeCriteria);
		if (shopTypes.size() < 1)
		{
			if(shopTypeMapper.insert(shopType) > 0)
			{
				result = Constants.Base.SUCCESS;
			}
			else
			{
				result = Constants.Base.FAIL;
			}
		}
		else
		{
			result = Constants.Base.REPEAT;
		}
		return result;
	}

	@Override
	public int delete(ShopType shopType)
	{
		return shopTypeMapper.deleteByPrimaryKey(shopType.getId());
	}

	@Override
	public int update(ShopType shopType, ShopType oldShopType)
	{
		int result = Constants.Base.FAIL;

		ShopTypeCriteria shopTypeCriteria = new ShopTypeCriteria();
		Criteria criteria = shopTypeCriteria.createCriteria();
		criteria.andTypeIdentifyEqualTo(shopType.getTypeIdentify());
		List<ShopType> shopTypes = shopTypeMapper.selectByCriteria(shopTypeCriteria);
		if (shopTypes.size() < 1)
		{
			if(shopTypeMapper.updateByPrimaryKeySelective(shopType) > 0)
			{
				result = Constants.Base.SUCCESS;
			}
		}
		else
		{
			if(shopTypes.get(0).getTypeIdentify().equals(oldShopType.getTypeIdentify()))
			{
				if(shopTypeMapper.updateByPrimaryKeySelective(shopType) > 0)
				{
					result = Constants.Base.SUCCESS;
				}
			}
			else
			{
				result = Constants.Base.REPEAT;
			}
		}
		return result;
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		ShopTypeCriteria shopTypeCriteria = new ShopTypeCriteria();
		Criteria criteria = shopTypeCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("typeName"))
			{
				criteria.andTypeNameLike("%" + (String) queryMap.get("typeName") + "%");
			}
		}
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

	@Override
	public ShopType findByIdentify(String identify)
	{
		ShopTypeCriteria shopTypeCriteria = new ShopTypeCriteria();
		Criteria criteria = shopTypeCriteria.createCriteria();
		criteria.andTypeIdentifyEqualTo(identify);
		return shopTypeMapper.selectByCriteria(shopTypeCriteria).get(0);
	}
}