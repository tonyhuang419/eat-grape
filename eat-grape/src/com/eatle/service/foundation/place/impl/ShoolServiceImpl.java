package com.eatle.service.foundation.place.impl;

import com.eatle.persistent.mapper.ShoolMapper;
import com.eatle.persistent.pojo.foundation.place.Shool;
import com.eatle.persistent.pojo.foundation.place.ShoolCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.place.ShoolCriteria;
import com.eatle.service.foundation.place.IShoolService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("shoolService")
public class ShoolServiceImpl implements IShoolService {
    @Resource
    private ShoolMapper shoolMapper;

    @Override
    public int add(Shool entity) {
        return shoolMapper.insert(entity);
    }

    @Override
    public int delete(Shool entity) {
        return shoolMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public int update(Shool entity) {
        return shoolMapper.updateByPrimaryKey(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        ShoolCriteria shoolCriteria = new ShoolCriteria();
        Criteria criteria = shoolCriteria.createCriteria();
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
                    shoolCriteria.setPageSize(pageSize);
                    shoolCriteria.setStartIndex((currentPage-1)*pageSize);
                    List<Shool> items = shoolMapper.selectByCriteria(shoolCriteria);
                    int totalCount = (int)shoolMapper.selectCountByCriteria(shoolCriteria);
                    return new Pagination(pageSize, currentPage, totalCount, items);
                }

    @Override
    public Shool findById(long id) {
        return shoolMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Shool> findAll() {
        return shoolMapper.selectByCriteria(null);
    }

    @Override
    public List<Shool> findByCriteria(ShoolCriteria criteria) {
        return shoolMapper.selectByCriteria(criteria);
    }
}