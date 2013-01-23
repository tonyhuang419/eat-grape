package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.order.Order;
import com.eatle.persistent.pojo.order.OrderCriteria;
import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByCriteria(OrderCriteria example);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //统计总的记录数
    long selectCountByCriteria(OrderCriteria example);

    //通过map参数进行查询
    List<Order> selectByMap(Map paramMap);
}