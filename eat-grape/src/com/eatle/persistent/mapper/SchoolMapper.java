package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.place.School;
import com.eatle.persistent.pojo.foundation.place.SchoolCriteria;
import java.util.List;
import java.util.Map;

public interface SchoolMapper {
    int deleteByPrimaryKey(Long id);

    int insert(School record);

    int insertSelective(School record);

    List<School> selectByCriteria(SchoolCriteria example);

    School selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

    //统计总的记录数
    long selectCountByCriteria(SchoolCriteria example);

    //通过map参数进行查询
    List<School> selectByMap(Map paramMap);
}