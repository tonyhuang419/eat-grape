package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.frontdata.FriendshipLink;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLinkCriteria;
import java.util.List;
import java.util.Map;

public interface FriendshipLinkMapper
{
	int deleteByPrimaryKey(Long id);

	int insert(FriendshipLink record);

	int insertSelective(FriendshipLink record);

	List<FriendshipLink> selectByCriteria(FriendshipLinkCriteria example);

	FriendshipLink selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(FriendshipLink record);

	int updateByPrimaryKey(FriendshipLink record);

	// 统计总的记录数
	long selectCountByCriteria(FriendshipLinkCriteria example);

	// 通过map参数进行查询
	@SuppressWarnings("unchecked")
	List<FriendshipLink> selectByMap(Map paramMap);
}