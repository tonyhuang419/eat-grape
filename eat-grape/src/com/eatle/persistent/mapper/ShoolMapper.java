package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.place.Shool;
import com.eatle.persistent.pojo.foundation.place.ShoolCriteria;
import java.util.List;
import java.util.Map;

public interface ShoolMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Shool record);

    int insertSelective(Shool record);

    List<Shool> selectByCriteria(ShoolCriteria example);

    Shool selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Shool record);

    int updateByPrimaryKey(Shool record);

    //统计总的记录数
    long selectCountByCriteria(ShoolCriteria example);

    //通过map参数进行查询
    List<Shool> selectByMap(Map paramMap);
}