package com.eatle.web.action.system;

import com.eatle.persistent.pojo.system.Menu;
import com.eatle.service.system.IMenuService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;

import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

public class MenuAction extends BaseAction {
	
    private static final long serialVersionUID = -1598345728676407818L;

	@Resource
    private IMenuService menuService;

    private Pagination page;

    private Menu menu;

    public void setPage(Pagination page) {
        this.page = page;
    }

    public Pagination getPage() {
        return this.page;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return this.menu;
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
        page = menuService.findPagination(params, pageNum, pageSize);
        return "showIndex";
    }

    public String showAdd() {
        return "showAdd";
    }

    public void add() throws IOException {
        Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(menu==null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
        }else{
            menuService.add(menu);
        }
        super.writeMap(json);
    }

    public void delete() throws IOException {
        Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
 	    json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
        if(menu==null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
        }else{
            menuService.delete(menu);
        }
        super.writeMap(json);
    }

    public String showUpdate() {
        menu = menuService.findById(menu.getId());
        return "showUpdate";
    }

    public void update() throws IOException {
        Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(menu==null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
        }else{
            menuService.update(menu);
        }
        super.writeMap(json);
    }
}