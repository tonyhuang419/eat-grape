package com.eatle.service.business.distcommmgr;

import com.eatle.persistent.pojo.business.distcommmgr.Distinct;
import com.eatle.persistent.pojo.business.distcommmgr.DistinctCriteria;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;

public interface IDistinctService {
    /**
* @Description:
*
* @param entity
*/
    void add(Distinct entity);

    /**
* @Description:
*
* @param entity
*/
    void delete(Distinct entity);

    /**
* @Description:
*
* @param entity
*/
    void update(Distinct entity);

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
    Distinct findById(long id);

    /**
* @Description:
*
*/
    List<Distinct> findAll();

    /**
* @Description:
*
*/
    List<Distinct> findByCriteria(DistinctCriteria criteria);
}