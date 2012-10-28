package com.eatle.service.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.FriendshipLink;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLinkCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IFriendshipLinkService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(FriendshipLink entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(FriendshipLink entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(FriendshipLink entity);

	/**
	 * @Description:
	 * 
	 * @param queryMap 查询参数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize);

	/**
	 * @Description:
	 * 
	 * @param id
	 */
	FriendshipLink findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<FriendshipLink> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<FriendshipLink> findByCriteria(FriendshipLinkCriteria criteria);
}