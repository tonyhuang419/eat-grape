package com.eatle.service.business.distcommmgr.impl;

import com.eatle.persistent.mapper.DistinctMapper;
import com.eatle.persistent.pojo.business.distcommmgr.Distinct;
import com.eatle.persistent.pojo.business.distcommmgr.DistinctCriteria.Criteria;
import com.eatle.persistent.pojo.business.distcommmgr.DistinctCriteria;
import com.eatle.service.business.distcommmgr.IDistinctService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("distinctService")
public class DistinctServiceImpl implements IDistinctService {
    @Resource
    private DistinctMapper distinctMapper;

    @Override
    public void add(Distinct entity) {
        distinctMapper.insert(entity);
    }

    @Override
    public void delete(Distinct entity) {
        distinctMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public void update(Distinct entity) {
        distinctMapper.updateByPrimaryKey(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        DistinctCriteria distinctCriteria = new DistinctCriteria();
        Criteria criteria = distinctCriteria.createCriteria();
        // 设置搜索条件参数
        //if(queryMap != null){
            //if(queryMap.containsKey("username")){
                //criteria.andUserNameLike("%"+(String)queryMap.get("username")+"%");
                //}
                //if(queryMap.containsKey("email")){
                    //criteria.andEmailLike((String)queryMap.get("email"));
                    //}
                    //}
                    // 设置分页参数
                    distinctCriteria.setPageSize(pageSize);
                    distinctCriteria.setStartIndex((currentPage-1)*pageSize);
                    List<Distinct> items = distinctMapper.selectByCriteria(distinctCriteria);
                    int totalCount = (int)distinctMapper.selectCountByCriteria(distinctCriteria);
                    return new Pagination(pageSize, currentPage, totalCount, items);
                }

    @Override
    public Distinct findById(long id) {
        return distinctMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Distinct> findAll() {
        return distinctMapper.selectByCriteria(null);
    }

    @Override
    public List<Distinct> findByCriteria(DistinctCriteria criteria) {
        return distinctMapper.selectByCriteria(criteria);
    }
}