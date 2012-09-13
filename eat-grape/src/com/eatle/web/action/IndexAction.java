/**
 */
package com.eatle.web.action;

import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.service.system.IMenuService;

/**
 * @Title:
 * @Description:
 * @Author:asus
 * @Since:2012-6-18
 * @Version:1.1.0
 */
public class IndexAction extends BaseAction
{

	private static final long serialVersionUID = -5221880781064937400L;

	@Resource
	private IMenuService menuService;
	
	@SuppressWarnings("unchecked")
	public String index()
	{
		// 当前登录用户所属角色拥有的权限集合
		Map<String, Priv> allPrivs = (Map<String, Priv>) session.get("allPrivs");
		String allMenuHtml = menuService.findAllMenu(allPrivs);
		request.setAttribute("allMenuHtml", allMenuHtml);
		return SUCCESS;
	}

	public IMenuService getMenuService()
	{
		return menuService;
	}

	public void setMenuService(IMenuService menuService)
	{
		this.menuService = menuService;
	}
}
