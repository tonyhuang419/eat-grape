package com.eatle.web.action.backend.foundation.place;

import com.eatle.persistent.pojo.foundation.place.Community;
import com.eatle.persistent.pojo.foundation.place.School;
import com.eatle.service.foundation.place.ICommunityService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.utils.ReflectionUtils;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

public class CommunityAction extends BaseAction {
    @Resource
    private ICommunityService communityService;

    private Pagination page;

    private Community community;

    public void setPage(Pagination page) {
        this.page = page;
    }

    public Pagination getPage() {
        return this.page;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public String showIndex() {
        Map<String,Object> params = super.getRequestParameters(request);
        int pageNum = Pagination.CURRENTPAGE;
        int pageSize = Pagination.PAGESIZE;
        if(params.containsKey("pageNum")){
            pageNum = Integer.parseInt((String)params.get("pageNum"));
        }
        if(params.containsKey("numPerPage")){
            pageSize = Integer.parseInt((String)params.get("numPerPage"));
        }
        page = communityService.findPagination(params, pageNum, pageSize);
        return "showIndex";
    }

    public String showAdd() {
        return "showAdd";
    }

    public void add() throws IOException {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(community == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            communityService.add(community);
        }
        super.writeMap(json);
    }

    public void delete() throws IOException {
        Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
        if(community == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            communityService.delete(community);
        }
        super.writeMap(json);
    }

    public String showUpdate() {
        community = communityService.findById(community.getId());
        return "showUpdate";
    }

    public void update() throws Exception {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(community == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
        	Community cy = communityService.findById(community.getId());
        	ReflectionUtils.copyPorperties(cy, community, new String[]{"name","pinyinName"});
            communityService.update(cy);
        }
        super.writeMap(json);
    }

	public Community getCommunity() {
		return community;
	}
}