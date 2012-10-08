package com.eatle.service.foundation.place.impl;

import com.eatle.persistent.mapper.SchoolMapper;
import com.eatle.persistent.pojo.foundation.place.School;
import com.eatle.persistent.pojo.foundation.place.SchoolCriteria.Criteria;
import com.eatle.persistent.pojo.foundation.place.SchoolCriteria;
import com.eatle.service.foundation.place.ISchoolService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("schoolService")
public class SchoolServiceImpl implements ISchoolService {
    @Resource
    private SchoolMapper schoolMapper;

    @Override
    public int add(School entity) {
        return schoolMapper.insert(entity);
    }

    @Override
    public int delete(School entity) {
        return schoolMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public int update(School entity) {
        return schoolMapper.updateByPrimaryKey(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        SchoolCriteria schoolCriteria = new SchoolCriteria();
        Criteria criteria = schoolCriteria.createCriteria();
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
                    schoolCriteria.setPageSize(pageSize);
                    schoolCriteria.setStartIndex((currentPage-1)*pageSize);
                    List<School> items = schoolMapper.selectByCriteria(schoolCriteria);
                    int totalCount = (int)schoolMapper.selectCountByCriteria(schoolCriteria);
                    return new Pagination(pageSize, currentPage, totalCount, items);
                }

    @Override
    public School findById(long id) {
        return schoolMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<School> findAll() {
        return schoolMapper.selectByCriteria(null);
    }

    @Override
    public List<School> findByCriteria(SchoolCriteria criteria) {
        return schoolMapper.selectByCriteria(criteria);
    }
}