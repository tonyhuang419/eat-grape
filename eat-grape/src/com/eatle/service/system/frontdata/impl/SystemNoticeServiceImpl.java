package com.eatle.service.system.frontdata.impl;

import com.eatle.persistent.mapper.SystemNoticeMapper;
import com.eatle.persistent.pojo.system.frontdata.SystemNotice;
import com.eatle.persistent.pojo.system.frontdata.SystemNoticeCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.SystemNoticeCriteria;
import com.eatle.service.system.frontdata.ISystemNoticeService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("systemNoticeService")
public class SystemNoticeServiceImpl implements ISystemNoticeService {
    @Resource
    private SystemNoticeMapper systemNoticeMapper;

    @Override
    public int add(SystemNotice entity) {
        return systemNoticeMapper.insert(entity);
    }

    @Override
    public int delete(SystemNotice entity) {
        return systemNoticeMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public int update(SystemNotice entity) {
        return systemNoticeMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        SystemNoticeCriteria systemNoticeCriteria = new SystemNoticeCriteria();
        Criteria criteria = systemNoticeCriteria.createCriteria();
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
                    systemNoticeCriteria.setPageSize(pageSize);
                    systemNoticeCriteria.setStartIndex((currentPage-1)*pageSize);
                    List<SystemNotice> items = systemNoticeMapper.selectByCriteria(systemNoticeCriteria);
                    int totalCount = (int)systemNoticeMapper.selectCountByCriteria(systemNoticeCriteria);
                    return new Pagination(pageSize, currentPage, totalCount, items);
                }

    @Override
    public SystemNotice findById(long id) {
        return systemNoticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemNotice> findAll() {
        return systemNoticeMapper.selectByCriteria(null);
    }

    @Override
    public List<SystemNotice> findByCriteria(SystemNoticeCriteria criteria) {
        return systemNoticeMapper.selectByCriteria(criteria);
    }
}