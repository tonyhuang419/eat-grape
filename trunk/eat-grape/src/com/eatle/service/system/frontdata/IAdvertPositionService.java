package com.eatle.service.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.AdvertPosition;
import com.eatle.persistent.pojo.system.frontdata.AdvertPositionCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IAdvertPositionService {
    /**
* @Description:
*
* @param entity
*/
    int add(AdvertPosition entity);

    /**
* @Description:
*
* @param entity
*/
    int delete(AdvertPosition entity);

    /**
* @Description:
*
* @param entity
*/
    int update(AdvertPosition entity);

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
    AdvertPosition findById(long id);

    /**
* @Description:
*
*/
    List<AdvertPosition> findAll();

    /**
* @Description:
*
*/
    List<AdvertPosition> findByCriteria(AdvertPositionCriteria criteria);
}