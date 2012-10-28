package com.eatle.service.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.ServiceInformation;
import com.eatle.persistent.pojo.system.frontdata.ServiceInformationCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IServiceInformationService
{
	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int add(ServiceInformation entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int delete(ServiceInformation entity);

	/**
	 * @Description:
	 * 
	 * @param entity
	 */
	int update(ServiceInformation entity);

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
	ServiceInformation findById(long id);

	/**
	 * @Description:
	 * 
	 */
	List<ServiceInformation> findAll();

	/**
	 * @Description:
	 * 
	 */
	List<ServiceInformation> findByCriteria(ServiceInformationCriteria criteria);
}