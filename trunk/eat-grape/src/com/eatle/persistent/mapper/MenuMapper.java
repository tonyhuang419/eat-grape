package com.eatle.persistent.mapper;

import com.eatle.persistent.pojo.system.Menu;
import com.eatle.persistent.pojo.system.MenuCriteria;
import java.util.List;
import java.util.Map;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByCriteria(MenuCriteria example);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    //统计总的记录数
    long selectCountByCriteria(MenuCriteria example);

    //通过map参数进行查询
    List<Menu> selectByMap(Map paramMap);
}