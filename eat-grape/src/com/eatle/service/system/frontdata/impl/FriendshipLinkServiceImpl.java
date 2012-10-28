package com.eatle.service.system.frontdata.impl;

import com.eatle.persistent.mapper.FriendshipLinkMapper;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLink;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLinkCriteria.Criteria;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLinkCriteria;
import com.eatle.service.system.frontdata.IFriendshipLinkService;
import com.eatle.utils.Pagination;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("friendshipLinkService")
public class FriendshipLinkServiceImpl implements IFriendshipLinkService {
    @Resource
    private FriendshipLinkMapper friendshipLinkMapper;

    @Override
    public int add(FriendshipLink entity) {
        return friendshipLinkMapper.insert(entity);
    }

    @Override
    public int delete(FriendshipLink entity) {
        return friendshipLinkMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public int update(FriendshipLink entity) {
        return friendshipLinkMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public Pagination findPagination(Map<String, Object> queryMap, int currentPage, int pageSize) {
        FriendshipLinkCriteria friendshipLinkCriteria = new FriendshipLinkCriteria();
        Criteria criteria = friendshipLinkCriteria.createCriteria();
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
                    friendshipLinkCriteria.setPageSize(pageSize);
                    friendshipLinkCriteria.setStartIndex((currentPage-1)*pageSize);
                    List<FriendshipLink> items = friendshipLinkMapper.selectByCriteria(friendshipLinkCriteria);
                    int totalCount = (int)friendshipLinkMapper.selectCountByCriteria(friendshipLinkCriteria);
                    return new Pagination(pageSize, currentPage, totalCount, items);
                }

    @Override
    public FriendshipLink findById(long id) {
        return friendshipLinkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FriendshipLink> findAll() {
        return friendshipLinkMapper.selectByCriteria(null);
    }

    @Override
    public List<FriendshipLink> findByCriteria(FriendshipLinkCriteria criteria) {
        return friendshipLinkMapper.selectByCriteria(criteria);
    }
}