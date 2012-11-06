package com.eatle.service.customer.impl;

import com.eatle.persistent.mapper.CustomerMapper;
import com.eatle.persistent.pojo.customer.Customer;
import com.eatle.persistent.pojo.customer.CustomerCriteria.Criteria;
import com.eatle.persistent.pojo.customer.CustomerCriteria;
import com.eatle.service.customer.ICustomerService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int add(Customer entity) {
        return customerMapper.insert(entity);
    }

    @Override
    public int delete(Customer entity) {
        return customerMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public int update(Customer entity) {
        return customerMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        CustomerCriteria customerCriteria = new CustomerCriteria();
        Criteria criteria = customerCriteria.createCriteria();
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
                    customerCriteria.setPageSize(pageSize);
                    customerCriteria.setStartIndex((currentPage-1)*pageSize);
                    List<Customer> items = customerMapper.selectByCriteria(customerCriteria);
                    int totalCount = (int)customerMapper.selectCountByCriteria(customerCriteria);
                    return new Pagination(pageSize, currentPage, totalCount, items);
                }

    @Override
    public Customer findById(long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.selectByCriteria(null);
    }

    @Override
    public List<Customer> findByCriteria(CustomerCriteria criteria) {
        return customerMapper.selectByCriteria(criteria);
    }
}