package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.frontdata.ServiceInformation;
import com.eatle.persistent.pojo.system.frontdata.ServiceInformationCriteria;
import java.util.List;
import java.util.Map;

public interface ServiceInformationMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(ServiceInformation record);

	int insertSelective(ServiceInformation record);

	List<ServiceInformation> selectByCriteria(ServiceInformationCriteria example);

	ServiceInformation selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ServiceInformation record);

	int updateByPrimaryKey(ServiceInformation record);

	// 统计总的记录数
	long selectCountByCriteria(ServiceInformationCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<ServiceInformation> selectByMap(Map paramMap);
}