package com.eatle.service.system.frontdata.impl;

import com.eatle.persistent.mapper.FrontMenuMapper;
import com.eatle.persistent.pojo.system.frontdata.FrontMenu;
import com.eatle.persistent.pojo.system.frontdata.FrontMenuCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.FrontMenuCriteria;
import com.eatle.service.system.frontdata.IFrontMenuService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("frontMenuService")
public class FrontMenuServiceImpl implements IFrontMenuService
{
	@Resource
	private FrontMenuMapper frontMenuMapper;

	@Override
	public int add(FrontMenu entity)
	{
		return frontMenuMapper.insert(entity);
	}

	@Override
	public int delete(FrontMenu entity)
	{
		return frontMenuMapper.deleteByPrimaryKey(entity.getId());
	}

	@Override
	public int update(FrontMenu entity)
	{
		return frontMenuMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Pagination findPagination(Map<String, Object> queryMap,
			int currentPage, int pageSize)
	{
		FrontMenuCriteria frontMenuCriteria = new FrontMenuCriteria();
		Criteria criteria = frontMenuCriteria.createCriteria();
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
		frontMenuCriteria.setPageSize(pageSize);
		frontMenuCriteria.setStartIndex((currentPage - 1) * pageSize);
		List<FrontMenu> items = frontMenuMapper.selectByCriteria(frontMenuCriteria);
		int totalCount = (int) frontMenuMapper.selectCountByCriteria(frontMenuCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public FrontMenu findById(long id)
	{
		return frontMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<FrontMenu> findAll()
	{
		return frontMenuMapper.selectByCriteria(null);
	}

	@Override
	public List<FrontMenu> findByCriteria(FrontMenuCriteria criteria)
	{
		return frontMenuMapper.selectByCriteria(criteria);
	}
}