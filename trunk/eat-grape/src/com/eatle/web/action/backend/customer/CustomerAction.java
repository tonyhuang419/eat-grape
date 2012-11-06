package com.eatle.web.action.backend.customer;

import com.eatle.persistent.pojo.customer.Customer;
import com.eatle.service.customer.ICustomerService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

public class CustomerAction extends BaseAction {
    @Resource
    private ICustomerService customerService;

    private Pagination page;

    private Customer customer;

    public void setPage(Pagination page) {
        this.page = page;
    }

    public Pagination getPage() {
        return this.page;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        page = customerService.findPagination(params, pageNum, pageSize);
        return "showIndex";
    }

    public String showAdd() {
        return "showAdd";
    }

    public void add() throws IOException {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(customer == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            customerService.add(customer);
        }
        super.writeMap(json);
    }

    public void delete() throws IOException {
        Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
        if(customer == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            customerService.delete(customer);
        }
        super.writeMap(json);
    }

    public String showUpdate() {
        customer = customerService.findById(customer.getId());
        return "showUpdate";
    }

    public void update() throws IOException {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(customer == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            customerService.update(customer);
        }
        super.writeMap(json);
    }
}