package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.business.distcommmgr.Distinct;
import com.eatle.persistent.pojo.business.distcommmgr.DistinctCriteria;
import java.util.List;
import java.util.Map;

public interface DistinctMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Distinct record);

    int insertSelective(Distinct record);

    List<Distinct> selectByCriteria(DistinctCriteria example);

    Distinct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Distinct record);

    int updateByPrimaryKey(Distinct record);

    //统计总的记录数
    long selectCountByCriteria(DistinctCriteria example);

    //通过map参数进行查询
    List<Distinct> selectByMap(Map paramMap);
}