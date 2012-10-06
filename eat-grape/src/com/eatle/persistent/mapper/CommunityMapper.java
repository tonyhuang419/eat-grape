package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.place.Community;
import com.eatle.persistent.pojo.foundation.place.CommunityCriteria;
import java.util.List;
import java.util.Map;

public interface CommunityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Community record);

    int insertSelective(Community record);

    List<Community> selectByCriteria(CommunityCriteria example);

    Community selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);

    //统计总的记录数
    long selectCountByCriteria(CommunityCriteria example);

    //通过map参数进行查询
    List<Community> selectByMap(Map paramMap);
}