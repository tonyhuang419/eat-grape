package com.eatle.service.system.impl;

import com.eatle.persistent.mapper.MenuMapper;
import com.eatle.persistent.pojo.system.Menu;
import com.eatle.persistent.pojo.system.MenuCriteria.Criteria;
import com.eatle.persistent.pojo.system.MenuCriteria;
import com.eatle.service.system.IMenuService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public void add(Menu entity) {
        menuMapper.insert(entity);
    }

    @Override
    public void delete(Menu entity) {
        menuMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public void update(Menu entity) {
        menuMapper.updateByPrimaryKey(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        MenuCriteria menuCriteria = new MenuCriteria();
        Criteria criteria = menuCriteria.createCriteria();
        //if(queryMap!=null){
            //if(queryMap.containsKey("username")){
                //criteria.andUserNameLike("%"+(String)queryMap.get("username")+"%");
                //}
                //if(queryMap.containsKey("email")){
                    //criteria.andEmailLike((String)queryMap.get("email"));
                    //}
                    //}
                    //设置分页参数
                    menuCriteria.setPageSize(pageSize);
                    menuCriteria.setStartIndex((currentPage-1)*pageSize);
                    List<Menu> items = menuMapper.selectByCriteria(menuCriteria);
                    int totalCount = (int)menuMapper.selectCountByCriteria(menuCriteria);
                    return new Pagination(pageSize, currentPage, totalCount, items);
                }

    @Override
    public Menu findById(long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Menu> findAll() {
        return menuMapper.selectByCriteria(null);
    }

    @Override
    public List<Menu> findByCriteria(MenuCriteria criteria) {
        return menuMapper.selectByCriteria(criteria);
    }
}