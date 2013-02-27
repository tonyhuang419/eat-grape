package com.eatle.service.merchant.impl;

import com.eatle.persistent.mapper.RestaurantMapper;
import com.eatle.persistent.pojo.foundation.dictionary.ShopType;
import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria.Criteria;
import com.eatle.persistent.pojo.merchant.RestaurantCriteria;
import com.eatle.service.foundation.dictionary.IShopTypeService;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.utils.Pagination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("restaurantService")
public class RestaurantServiceImpl implements IRestaurantService
{
	@Resource
	private RestaurantMapper restaurantMapper;
	
	@Resource
	private IMerchantService merchantService;
	
	@Resource
	private IShopTypeService shopTypeService;

	@Override
	public int add(Restaurant entity)
	{
		return restaurantMapper.insert(entity);
	}

	@Override
	public int delete(Restaurant entity)
	{
		return restaurantMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Restaurant entity)
	{
		return restaurantMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		RestaurantCriteria restaurantCriteria = new RestaurantCriteria();
		Criteria criteria = restaurantCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("merchantId"))
			{
				criteria.andMerchantIdEqualTo(Long.parseLong((String) queryMap.get("merchantId")));
			}
			if (queryMap.containsKey("name"))
			{
				criteria.andNameLike("%" + (String) queryMap.get("name") + "%");
			}
			if (queryMap.containsKey("address"))
			{
				criteria.andAddressLike("%" + (String) queryMap.get("address") + "%");
			}
			if (queryMap.containsKey("contactName"))
			{
				criteria.andContactNameLike("%" + (String) queryMap.get("contactName") + "%");
			}
			if (queryMap.containsKey("contactPhone"))
			{
				criteria.andContactPhoneLike("%" + (String) queryMap.get("contactPhone") + "%");
			}
		}
		// 设置分页参数
		restaurantCriteria.setPageSize(pageSize);
		restaurantCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Restaurant> items = restaurantMapper.selectByCriteria(restaurantCriteria);
		
		// 设置餐厅主营类型
		Map<String, String> shopTypes = getAllShopType();
		for(Restaurant r : items)
		{
			r.setShopTypeStr(shopTypes.get(r.getShopType()));
		}
		
		int totalCount = (int) restaurantMapper.selectCountByCriteria(restaurantCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Restaurant findById(long id)
	{
		Restaurant restaurant = restaurantMapper.selectByPrimaryKey(id);
		// 设置主营类型
		restaurant.setShopTypeStr(shopTypeService.
				findByIdentify(restaurant.getShopType()).getTypeName());
		// 设置所属商家
		restaurant.setMerchantName(merchantService.
				findById(restaurant.getMerchantId()).getMerchantName());
		return restaurant;
	}

	@Override
	public List<Restaurant> findAll()
	{
		List<Restaurant> items = restaurantMapper.selectByCriteria(null);
		// 设置餐厅主营类型
		Map<String, String> shopTypes = getAllShopType();
		for(Restaurant r : items)
		{
			r.setShopTypeStr(shopTypes.get(r.getShopType()));
		}
		return items;
	}

	@Override
	public List<Restaurant> findByCriteria(RestaurantCriteria criteria)
	{
		List<Restaurant> items = restaurantMapper.selectByCriteria(criteria); 
		// 设置餐厅主营类型
		Map<String, String> shopTypes = getAllShopType();
		for(Restaurant r : items)
		{
			r.setShopTypeStr(shopTypes.get(r.getShopType()));
		}
		return items;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List<Merchant> merchants = merchantService.findAll();
		for(int i = 0, len = merchants.size(); i < len; i++)
		{
			RestaurantCriteria rc = new RestaurantCriteria();
			Criteria criteria = rc.createCriteria();
			criteria.andMerchantIdEqualTo(merchants.get(i).getId());
			map.put((i + 1) + "." + merchants.get(i).getMerchantName(), findByCriteria(rc));
		}
		return map;
	}
	
	/**
	 * @Description: 获取所有餐厅主营类型及标识的映射集合
	 */
	public Map<String, String> getAllShopType()
	{
		Map<String, String> map = new HashMap<String, String>();
		List<ShopType> shopTypes = shopTypeService.findAll();
		for(ShopType st : shopTypes)
		{
			map.put(st.getTypeIdentify(), st.getTypeName());
		}
		return map;
	}

	@Override
	public List<Restaurant> findByMultiIds(String[] ids)
	{
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		for(String id : ids)
		{
			restaurants.add(findById(Long.parseLong(id)));
		}
		return restaurants;
	}

	@Override
	public String findByMultiIds(String[] ids, String separatorChars)
	{
		StringBuffer restaurants = new StringBuffer();
		for(String id : ids)
		{
			restaurants.append((findById(Long.parseLong(id)).getName()));
			restaurants.append(separatorChars);
		}
		return restaurants.substring(0, restaurants.lastIndexOf(separatorChars));
	}
}