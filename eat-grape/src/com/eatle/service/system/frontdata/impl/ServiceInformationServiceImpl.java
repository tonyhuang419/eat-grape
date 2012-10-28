package com.eatle.service.system.frontdata.impl;

import com.eatle.persistent.mapper.ServiceInformationMapper;
import com.eatle.persistent.pojo.system.frontdata.ServiceInformation;
import com.eatle.persistent.pojo.system.frontdata.ServiceInformationCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.ServiceInformationCriteria;
import com.eatle.service.system.frontdata.IServiceInformationService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("serviceInformationService")
public class ServiceInformationServiceImpl implements IServiceInformationService {
    @Resource
    private ServiceInformationMapper serviceInformationMapper;

    @Override
    public int add(ServiceInformation entity) {
        return serviceInformationMapper.insert(entity);
    }

    @Override
    public int delete(ServiceInformation entity) {
        return serviceInformationMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public int update(ServiceInformation entity) {
        return serviceInformationMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        ServiceInformationCriteria serviceInformationCriteria = new ServiceInformationCriteria();
        Criteria criteria = serviceInformationCriteria.createCriteria();
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
                    serviceInformationCriteria.setPageSize(pageSize);
                    serviceInformationCriteria.setStartIndex((currentPage-1)*pageSize);
                    List<ServiceInformation> items = serviceInformationMapper.selectByCriteria(serviceInformationCriteria);
                    int totalCount = (int)serviceInformationMapper.selectCountByCriteria(serviceInformationCriteria);
                    return new Pagination(pageSize, currentPage, totalCount, items);
                }

    @Override
    public ServiceInformation findById(long id) {
        return serviceInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ServiceInformation> findAll() {
        return serviceInformationMapper.selectByCriteria(null);
    }

    @Override
    public List<ServiceInformation> findByCriteria(ServiceInformationCriteria criteria) {
        return serviceInformationMapper.selectByCriteria(criteria);
    }
}