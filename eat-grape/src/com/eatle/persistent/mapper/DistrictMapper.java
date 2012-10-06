package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria;
import java.util.List;
import java.util.Map;

public interface DistrictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByCriteria(DistrictCriteria example);

    District selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    //统计总的记录数
    long selectCountByCriteria(DistrictCriteria example);

    //通过map参数进行查询
    List<District> selectByMap(Map paramMap);
}