package com.eatle.web.action.system;

import com.eatle.persistent.pojo.system.Menu;
import com.eatle.service.system.IMenuService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class MenuAction extends BaseAction
{
	private static final long serialVersionUID = -1598345728676407818L;

	@Resource
	private IMenuService menuService2;

	private Pagination page;

	private Menu menu;

	private List<Menu> allMenu; // 所有菜单对象

	private String allMenuHtml; // 所有菜单树形HTML

	private String delMenuIds; // 需要删除的菜单的id集合

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}

	public Menu getMenu()
	{
		return this.menu;
	}

	public List<Menu> getAllMenu()
	{
		return allMenu;
	}

	public void setAllMenu(List<Menu> allMenu)
	{
		this.allMenu = allMenu;
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
		// Map<String,Object> params = super.getRequestParameters(request);
		// int pageNum = Pagination.CURRENTPAGE;
		// int pageSize = Pagination.PAGESIZE;
		// if(params.containsKey("pageNum")){
		// pageNum = Integer.parseInt((String)params.get("pageNum"));
		// }
		// if(params.containsKey("numPerPage")){
		// pageSize = Integer.parseInt((String)params.get("numPerPage"));
		// }
		// page = menuService2.findPagination(params, pageNum, pageSize);
		allMenuHtml = menuService2.findAllMenu();
		return "showIndex";
	}

	public String showAdd()
	{
		allMenu = menuService2.findAll();
		return "showAdd";
	}

	public void add() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (menu == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
		}
		else
		{
			menuService2.add(menu);
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
				Menu m = new Menu();
				m.setId(Long.parseLong(id));
				menuService2.delete(m);
			}
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		menu = menuService2.findById(menu.getId());
		allMenu = menuService2.findAll();
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (menu == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
		}
		else
		{
			menuService2.update(menu);
		}
		super.writeMap(json);
	}
}