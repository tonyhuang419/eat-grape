package com.eatle.service.foundation.scoreshop.impl;

import com.eatle.persistent.mapper.ConvertGoodsMapper;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoods;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoodsCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoodsCriteria;
import com.eatle.service.foundation.scoreshop.IConvertGoodsService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("convertGoodsService")
public class ConvertGoodsServiceImpl implements IConvertGoodsService
{
	@Resource
	private ConvertGoodsMapper convertGoodsMapper;

	@Override
	public int add(ConvertGoods entity)
	{
		return convertGoodsMapper.insert(entity);
	}

	@Override
	public int delete(ConvertGoods entity)
	{
		return convertGoodsMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(ConvertGoods entity)
	{
		return convertGoodsMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		ConvertGoodsCriteria convertGoodsCriteria = new ConvertGoodsCriteria();
		Criteria criteria = convertGoodsCriteria.createCriteria();
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
		convertGoodsCriteria.setPageSize(pageSize);
		convertGoodsCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<ConvertGoods> items = convertGoodsMapper.selectByCriteria(convertGoodsCriteria);
		int totalCount = (int) convertGoodsMapper.selectCountByCriteria(convertGoodsCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public ConvertGoods findById(long id)
	{
		return convertGoodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ConvertGoods> findAll()
	{
		return convertGoodsMapper.selectByCriteria(null);
	}

	@Override
	public List<ConvertGoods> findByCriteria(ConvertGoodsCriteria criteria)
	{
		return convertGoodsMapper.selectByCriteria(criteria);
	}
}