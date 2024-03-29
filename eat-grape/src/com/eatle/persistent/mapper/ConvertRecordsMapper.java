package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecords;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertRecordsCriteria;
import java.util.List;
import java.util.Map;

public interface ConvertRecordsMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(ConvertRecords record);

	int insertSelective(ConvertRecords record);

	List<ConvertRecords> selectByCriteria(ConvertRecordsCriteria example);

	ConvertRecords selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ConvertRecords record);

	int updateByPrimaryKey(ConvertRecords record);

	// 统计总的记录数
	long selectCountByCriteria(ConvertRecordsCriteria example);

	@SuppressWarnings("unchecked")
	// 通过map参数进行查询
	List<ConvertRecords> selectByMap(Map paramMap);
	
	/**
	 * @Description: 根据条件去t_customer、t_convert_goods、t_convert_records查询兑换记录
	 * @param queryMap: 查询条件
	 */
	List<ConvertRecords> selectConvertRecordsByCondition(Map<String, Object> queryMap);
	
	/**
	 * @Description: 根据条件去t_customer、t_convert_goods、t_convert_records查询兑换记录条数
	 * @param queryMap: 查询条件
	 */
	long selectConvertRecordsCountByCondition(Map<String, Object> queryMap);
}