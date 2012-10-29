package com.eatle.web.action.backend.system.frontdata;

import com.eatle.persistent.pojo.system.frontdata.FrontMenu;
import com.eatle.service.system.frontdata.IFrontMenuService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.web.action.BaseAction;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class FrontMenuAction extends BaseAction
{
	private static final long serialVersionUID = -1598345728676407818L;

	@Resource
	private IFrontMenuService frontMenuService;

	private FrontMenu frontMenu;

	private List<FrontMenu> allFrontMenu; 	// 所有菜单对象

	private String allMenuHtml; 		// 所有菜单树形HTML

	private String delMenuIds; 			// 需要删除的菜单的id集合

	public FrontMenu getFrontMenu()
	{
		return frontMenu;
	}

	public void setFrontMenu(FrontMenu frontMenu)
	{
		this.frontMenu = frontMenu;
	}

	public List<FrontMenu> getAllFrontMenu()
	{
		return allFrontMenu;
	}

	public void setAllFrontMenu(List<FrontMenu> allFrontMenu)
	{
		this.allFrontMenu = allFrontMenu;
	}

	public String getAllMenuHtml()
	{
		return allMenuHtml;
	}

	public void setAllMenuHtml(String allMenuHtml)
	{
		this.allMenuHtml = allMenuHtml;
	}

	public String getDelMenuIds()
	{
		return delMenuIds;
	}

	public void setDelMenuIds(String delMenuIds)
	{
		this.delMenuIds = delMenuIds;
	}

	public String showIndex()
	{
		allMenuHtml = frontMenuService.findAllFrontMenu();
		return "showIndex";
	}

	public String showAdd()
	{
		allFrontMenu = frontMenuService.findAll();
		return "showAdd";
	}

	public void add() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (frontMenu == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
		}
		else
		{
			frontMenuService.add(frontMenu);
		}
		super.writeMap(json);
	}

	// 批量删除菜单
	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (delMenuIds == "" || delMenuIds == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
		}
		else
		{
			for (String id : delMenuIds.split(","))
			{
				FrontMenu m = new FrontMenu();
				m.setId(Long.parseLong(id));
				frontMenuService.delete(m);
			}
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		frontMenu = frontMenuService.findById(frontMenu.getId());
		allFrontMenu = frontMenuService.findAll();
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (frontMenu == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
		}
		else
		{
			frontMenuService.update(frontMenu);
		}
		super.writeMap(json);
	}
}