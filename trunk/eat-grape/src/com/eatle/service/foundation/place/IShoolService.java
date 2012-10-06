package com.eatle.service.foundation.place;

import com.eatle.persistent.pojo.foundation.place.Shool;
import com.eatle.persistent.pojo.foundation.place.ShoolCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IShoolService {
    /**
* @Description:
*
* @param entity
*/
    int add(Shool entity);

    /**
* @Description:
*
* @param entity
*/
    int delete(Shool entity);

    /**
* @Description:
*
* @param entity
*/
    int update(Shool entity);

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
    Shool findById(long id);

    /**
* @Description:
*
*/
    List<Shool> findAll();

    /**
* @Description:
*
*/
    List<Shool> findByCriteria(ShoolCriteria criteria);
}