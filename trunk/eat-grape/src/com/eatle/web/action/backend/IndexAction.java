package com.eatle.web.action.backend;

import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.User;
//import com.eatle.service.system.systemdata.IMenuService;
import com.eatle.service.system.useradmin.IPrivService;
import com.eatle.web.action.BaseAction;

/**
 * @Description: 主页
 * @Author: asus
 * @Since: 2012-6-18
 * @Version: 1.1.0
 */
public class IndexAction extends BaseAction
{

	private static final long serialVersionUID = -5221880781064937400L;

//	@Resource
//	private IMenuService menuService;
	
	@Resource
	private IPrivService privService;
	
	
	public String index()
	{
		// 当前登录用户所属角色拥有的权限集合
		Map<String, Priv> allPrivs = ((User) session.get("user")).getAllPrivs();
		String contextPath = request.getContextPath();
		// 存入菜单HTML
		//String allMenuHtml = menuService.findAllMenu(allPrivs,contextPath);
		//request.setAt	tribute("allMenuHtml", allMenuHtml);
		
		//FIX 改为通过Priv里的is_show字段来显示
		String allMenuHtml = privService.findAllPrivMenu(contextPath, allPrivs);
		request.setAttribute("allMenuHtml", allMenuHtml);
		
		return SUCCESS;
	}
}
