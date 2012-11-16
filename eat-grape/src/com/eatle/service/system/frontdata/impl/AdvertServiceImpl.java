package com.eatle.service.system.frontdata.impl;

import com.eatle.common.Constants;
import com.eatle.persistent.mapper.AdvertMapper;
import com.eatle.persistent.mapper.AdvertPositionMapper;
import com.eatle.persistent.pojo.system.frontdata.Advert;
import com.eatle.persistent.pojo.system.frontdata.AdvertCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.AdvertCriteria;
import com.eatle.service.system.frontdata.IAdvertService;
import com.eatle.utils.DateUtil;
import com.eatle.utils.Pagination;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("advertService")
public class AdvertServiceImpl implements IAdvertService
{
	@Resource
	private AdvertMapper advertMapper;
	@Resource
	private AdvertPositionMapper advertPositionMapper;

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
		if (queryMap != null)
		{
			if (queryMap.containsKey("name"))
			{
				criteria.andAdvertNameLike("%" + (String) queryMap.get("name") + "%");
			}
			if (queryMap.containsKey("linkMan"))
			{
				criteria.andLinkManLike("%" + (String) queryMap.get("linkMan") + "%");
			}
			if (queryMap.containsKey("type"))
			{
				criteria.andAdvertTypeEqualTo(Short.parseShort((String) queryMap.get("type")));
			}
			if (queryMap.containsKey("enabled"))
			{
				criteria.andAdvertEnabledEqualTo(Short.parseShort((String) queryMap.get("enabled")));
			}
		}
		// 设置分页参数
		advertCriteria.setPageSize(pageSize);
		advertCriteria.setStartIndex((currentPage - 1) * pageSize);
		// 查询并处理数据
		List<Advert> items = new ArrayList<Advert>();
		List<Advert> adverts = advertMapper.selectByCriteria(advertCriteria);
		for(Advert ad : adverts)
		{
			items.add(handleAdvert(ad));
		}
		
		int totalCount = (int) advertMapper.selectCountByCriteria(advertCriteria);
		return new Pagination(pageSize, currentPage, totalCount, items);
	}

	@Override
	public Advert findById(long id)
	{
		return handleAdvert(advertMapper.selectByPrimaryKey(id));
	}

	@Override
	public List<Advert> findAll()
	{
		List<Advert> items = new ArrayList<Advert>();
		List<Advert> adverts = advertMapper.selectByExampleWithBLOBs(null);
		for(Advert ad : adverts)
		{
			items.add(handleAdvert(ad));
		}
		return items;
	}

	@Override
	public List<Advert> findByCriteria(AdvertCriteria criteria)
	{
		List<Advert> items = new ArrayList<Advert>();
		List<Advert> adverts = advertMapper.selectByExampleWithBLOBs(criteria);
		for(Advert ad : adverts)
		{
			items.add(handleAdvert(ad));
		}
		return items;
	}

	/**
	 * @Description : 处理广告对象
	 * @param ad : 广告对象
	 * @return : 广告对象
	 */
	public Advert handleAdvert(Advert ad)
	{
		// 广告类型
		ad.setAdvertTypeStr(this.getAdvertTypeStr(ad.getAdvertType()));
		// 广告状态
		ad.setAdvertEnabledStr(this.getAdvertEnabledStr(ad.getAdvertEnabled()));
		// 开始时间
		ad.setStartTimeStr(new SimpleDateFormat(DateUtil.getDateTimePattern()).format(ad.getStartTime()));
		// 结束时间
		ad.setEndTimeStr(new SimpleDateFormat(DateUtil.getDateTimePattern()).format(ad.getEndTime()));
		// 发布时间
		ad.setIssueTimeStr(new SimpleDateFormat(DateUtil.getDateTimePattern()).format(ad.getIssueTime()));
		// 广告位
		ad.setAdvertPosition(advertPositionMapper.selectByPrimaryKey(ad.getAdvertPositionId()));
		
		return ad;
	}
	
	/**
	 * @Description : 处理广告类型
	 * @param advertType : 广告类型标识符
	 * @return : 广告类型名称
	 */
	public String getAdvertTypeStr(int advertType)
	{
		String advertTypeStr = StringUtils.EMPTY;
		
		if(advertType == Constants.AdvertType.ADVERT_TYPE_PIC)
			advertTypeStr = Constants.AdvertType.ADVERT_TYPE_PIC_HTML;
		if(advertType == Constants.AdvertType.ADVERT_TYPE_FLASH)
			advertTypeStr = Constants.AdvertType.ADVERT_TYPE_FLASH_HTML;
		if(advertType == Constants.AdvertType.ADVERT_TYPE_CODE)
			advertTypeStr = Constants.AdvertType.ADVERT_TYPE_CODE_HTML;
		if(advertType == Constants.AdvertType.ADVERT_TYPE_TEXT)
			advertTypeStr = Constants.AdvertType.ADVERT_TYPE_TEXT_HTML;
		
		return advertTypeStr;
	}
	
	/**
	 * @Description : 处理广告状态
	 * @param advertType : 广告状态标识符
	 * @return : 广告状态名称
	 */
	public String getAdvertEnabledStr(int advertEnabled)
	{
		String advertEnabledStr = StringUtils.EMPTY;
		
		if(advertEnabled == Constants.AdvertEnabled.ADVERT_ENABLED_OPEN)
			advertEnabledStr = Constants.AdvertEnabled.ADVERT_ENABLED_OPEN_HTML;
		if(advertEnabled == Constants.AdvertEnabled.ADVERT_ENABLED_CLOSE)
			advertEnabledStr = Constants.AdvertEnabled.ADVERT_ENABLED_CLOSE_HTML;
		
		return advertEnabledStr;
	}
}