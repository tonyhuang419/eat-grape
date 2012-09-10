/**
 */
package com.eatle.web.action.system.useradmin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.PrivCriteria;
import com.eatle.persistent.pojo.system.useradmin.PrivCriteria.Criteria;
import com.eatle.service.system.useradmin.IPrivService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;


/**
 *@Title:
 *@Description:
 *@Author:xt
 *@Since:2012-6-20
 *@Version:1.1.0
 */
public class PrivAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    
    @Resource
    private IPrivService privService;

    
    private Pagination page;
    
    private Priv priv;
    
    List<Priv> list;
    
    /**
     * 
     * @Description:显示首页
    	*
    	* @return
     */
   public String showIndex(){
       
	   Map<String,Object> params = super.getRequestParameters(request);
	   int pageNum = Pagination.CURRENTPAGE;
	   int pageSize = Pagination.PAGESIZE;
	   if(params.containsKey("pageNum")){
		   pageNum = Integer.parseInt((String)params.get("pageNum"));
	   }
	   if(params.containsKey("numPerPage")){
		   pageSize = Integer.parseInt((String)params.get("numPerPage"));
	   }
	   params.put("pidisnull", null);
	   page = privService.findPagination(params, pageNum, pageSize);
	   
       return "showIndex";
   }
   
   public String showAdd(){
	   return "showAdd";
   }
   
   public void add() throws IOException{
	   Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
	   json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
	   json.put(DwzAjaxJsonUtil.KEY_DIALOGID, dialogId);
	   json.put("pid", priv.getPId());
	   System.out.println(dialogId + "         " + navTabId);
	   if(priv == null){
		   json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
		   json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
	   }else{
		   privService.add(priv);
	   }
	   super.writeMap(json);
   }
   
   public void delete() throws IOException{
	   Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
	   json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
	   json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
	   if(priv == null){
		   json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
		   json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
	   }else{
		   privService.delete(priv);
	   }
	   super.writeMap(json);
	   
   }
   
   public String showUpdate(){
	   priv = privService.findById(priv.getId());
	   return "showUpdate";
   }
   
   public void update() throws IOException{
	   Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
	   json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
	   if(priv == null){
		   json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
		   json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
	   }else{
		   privService.update(priv);
	   }
	   super.writeMap(json);
   }
   
   public String showSetSubPriv(){
	   Map<String,Object> params = super.getRequestParameters(request);
	   Object pid  = params.get("pid");
	   PrivCriteria privCriteria = new PrivCriteria();
	   Criteria criteria = privCriteria.createCriteria();
	   criteria.andPIdIsNotNull();
	   criteria.andPIdEqualTo(Long.parseLong((String)pid));
	   list = privService.findByCriteria(privCriteria);
	   
	   return "showSetSubPriv";
   }
   
   
	public Pagination getPage() {
		return page;
	}
	public void setPage(Pagination page) {
		this.page = page;
	}

	public Priv getPriv() {
		return priv;
	}

	public void setPriv(Priv priv) {
		this.priv = priv;
	}

	public List<Priv> getList() {
		return list;
	}

	public void setList(List<Priv> list) {
		this.list = list;
	}
}
