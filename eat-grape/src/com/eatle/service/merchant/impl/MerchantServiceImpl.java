package com.eatle.service.merchant.impl;

import com.eatle.persistent.mapper.MerchantMapper;
import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.persistent.pojo.merchant.MerchantCriteria.Criteria;
import com.eatle.persistent.pojo.merchant.MerchantCriteria;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.utils.Pagination;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("merchantService")
public class MerchantServiceImpl implements IMerchantService
{
	@Resource
	private MerchantMapper merchantMapper;

	@Override
	public int add(Merchant entity)
	{
		return merchantMapper.insert(entity);
	}

	@Override
	public int delete(Merchant entity)
	{
		return merchantMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(Merchant entity)
	{
		return merchantMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		MerchantCriteria merchantCriteria = new MerchantCriteria();
		Criteria criteria = merchantCriteria.createCriteria();
		// 设置搜索条件参数
		if (queryMap != null)
		{
			if (queryMap.containsKey("merchantName"))
			{
				criteria.andMerchantNameLike("%" + (String) queryMap.get("merchantName") + "%");
			}
			if (queryMap.containsKey("merchantAddress"))
			{
				criteria.andMerchantAddressLike("%" + (String) queryMap.get("merchantAddress") + "%");
			}
			if (queryMap.containsKey("legalName"))
			{
				criteria.andLegalNameLike("%" + (String) queryMap.get("legalName") + "%");
			}
			if (queryMap.containsKey("legalPhone"))
			{
				criteria.andLegalPhoneLike("%" + (String) queryMap.get("legalPhone") + "%");
			}
		}
		// 设置分页参数
		merchantCriteria.setPageSize(pageSize);
		merchantCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<Merchant> items = merchantMapper.selectByCriteria(merchantCriteria);
		int totalCount = (int) merchantMapper.selectCountByCriteria(merchantCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Merchant findById(long id)
	{
		return merchantMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Merchant> findAll()
	{
		return merchantMapper.selectByCriteria(null);
	}

	@Override
	public List<Merchant> findByCriteria(MerchantCriteria criteria)
	{
		return merchantMapper.selectByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<String, List> getExportData()
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		map.put("加盟商家信息", findAll());
		return map;
	}
}