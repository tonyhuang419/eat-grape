package com.eatle.web.action.backend.foundation.place;

import com.eatle.persistent.pojo.foundation.place.Shool;
import com.eatle.service.foundation.place.IShoolService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.utils.ReflectionUtils;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

public class ShoolAction extends BaseAction {
    @Resource
    private IShoolService shoolService;

    private Pagination page;

    private Shool shool;

    public void setPage(Pagination page) {
        this.page = page;
    }

    public Pagination getPage() {
        return this.page;
    }

    public void setShool(Shool shool) {
        this.shool = shool;
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
        page = shoolService.findPagination(params, pageNum, pageSize);
        return "showIndex";
    }

    public String showAdd() {
        return "showAdd";
    }

    public void add() throws IOException {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(shool == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            shoolService.add(shool);
        }
        super.writeMap(json);
    }

    public void delete() throws IOException {
        Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
        if(shool == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            shoolService.delete(shool);
        }
        super.writeMap(json);
    }

    public String showUpdate() {
        shool = shoolService.findById(shool.getId());
        return "showUpdate";
    }

    public void update() throws Exception {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(shool == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
        	Shool sl = shoolService.findById(shool.getId());
        	ReflectionUtils.copyPorperties(sl, shool, new String[]{"name","englishName"});
            shoolService.update(sl);
        }
        super.writeMap(json);
    }

	public Shool getShool() {
		return shool;
	}
}