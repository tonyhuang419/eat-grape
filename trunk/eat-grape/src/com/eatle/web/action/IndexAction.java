/**
 */
package com.eatle.web.action;

import javax.annotation.Resource;

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
	
	public String index()
	{
		String allMenuHtml = menuService.findAllMenu();
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
