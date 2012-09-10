package com.eatle.web.action.system.useradmin;

import com.eatle.persistent.pojo.system.useradmin.RolePrivilege;
import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

public class RolePrivilegeAction extends BaseAction {
	
    private static final long serialVersionUID = -3474722896114805952L;

	@Resource
    private IRolePrivilegeService rolePrivilegeService;

    private Pagination page;

    private RolePrivilege rolePrivilege;

    public void setPage(Pagination page) {
        this.page = page;
    }

    public Pagination getPage() {
        return this.page;
    }

    public void setRolePrivilege(RolePrivilege rolePrivilege) {
        this.rolePrivilege = rolePrivilege;
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
        page = rolePrivilegeService.findPagination(params, pageNum, pageSize);
        return "showIndex";
    }

    public String showAdd() {
        return "showAdd";
    }

    public void add() throws IOException {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(rolePrivilege == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            rolePrivilegeService.add(rolePrivilege);
        }
        super.writeMap(json);
    }

    public void delete() throws IOException {
        Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
        if(rolePrivilege == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            rolePrivilegeService.delete(rolePrivilege);
        }
        super.writeMap(json);
    }

    public String showUpdate() {
        rolePrivilege = rolePrivilegeService.findById(rolePrivilege.getId());
        return "showUpdate";
    }

    public void update() throws IOException {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(rolePrivilege == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            rolePrivilegeService.update(rolePrivilege);
        }
        super.writeMap(json);
    }
}