package com.eatle.web.action.system.useradmin;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;


/**
 *@Title: User Action
 *@Description:
 *@Author:xt
 *@Since:2012-6-20
 *@Version:1.1.0
 */
public class UserAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    
    @Resource
    private IUserService userService;

    
    private Pagination page;
    
    private User user;
    
    /**
     * 
     * @Description:显示首页
     * @return
     */
   public String showIndex(){
       
	   Map<String,Object> params = super.getRequestParameters(request);
	   int pageNum = Pagination.CURRENTPAGE;
	   String numPerPage = (String) params.get("numPerPage");
	   int pageSize = Integer.parseInt((numPerPage == null) ? "" + Pagination.PAGESIZE : numPerPage);
	   System.out.println("谭又中谭又中："+pageSize);
	   if(params.containsKey("pageNum")){
		   pageNum = Integer.parseInt((String)params.get("pageNum"));
	   }
	   if(params.containsKey("numPerPage")){
		   pageSize = Integer.parseInt((String)params.get("numPerPage"));
	   }
	   page = userService.findPagination(params, pageNum, pageSize);
	   
       return "showIndex";
   }
   
   public String showAdd(){
	   return "showAdd";
   }
   
   public void add() throws IOException{
	   Map json = DwzAjaxJsonUtil.getDefaultAjaxJson();
	   json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
	   if(user==null){
		   json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
	   }else{
		   userService.add(user);
	   }
	   super.writeMap(json);
   }
   
   public void delete() throws IOException{
	   Map json = DwzAjaxJsonUtil.getDefaultAjaxJson();
	   json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
	   if(user==null){
		   json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
	   }else{
		   userService.delete(user);
	   }
	   super.writeMap(json);
	   
   }
   
   public String showUpdate(){
	   user = userService.findById(user.getId());
	   return "showUpdate";
   }
   
   public void update() throws IOException{
	   Map json = DwzAjaxJsonUtil.getDefaultAjaxJson();
	   json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
	   if(user==null){
		   json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
	   }else{
		   userService.update(user);
	   }
	   super.writeMap(json);
   }
   
   
	public Pagination getPage() {
		return page;
	}
	public void setPage(Pagination page) {
		this.page = page;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
