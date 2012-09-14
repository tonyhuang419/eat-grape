package com.eatle.web.action.system.useradmin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.system.useradmin.Role;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.useradmin.IRoleService;
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
public class UserAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	private IUserService userService;

	@Resource
	private IRoleService roleService;
	
	private List<Role> allRole;

	private Pagination page;

	private User user;

	/**
	 * 
	 * @Description:显示首页
	 * @return
	 */
	public String showIndex()
	{
		Map<String, Object> params = super.getRequestParameters(request);
		int pageNum = Pagination.CURRENTPAGE;
		int pageSize = Pagination.PAGESIZE;

		if (params.containsKey("pageNum"))
		{
			pageNum = Integer.parseInt((String) params.get("pageNum"));
		}
		if (params.containsKey("numPerPage"))
		{
			pageSize = Integer.parseInt((String) params.get("numPerPage"));
		}
		page = userService.findPagination(params, pageNum, pageSize);
		// 所有角色
		allRole = roleService.findAll();

		return "showIndex";
	}

	public String showAdd()
	{
		// 所有角色
		allRole = roleService.findAll();
		
		return "showAdd";
	}

	public void add() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (user == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			userService.add(user);
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (user == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			userService.delete(user);
		}
		super.writeMap(json);

	}

	public String showUpdate()
	{
		// 所有用户
		user = userService.findById(user.getId());
		// 所有角色
		allRole = roleService.findAll();
		
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (user == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			userService.update(user);
		}
		super.writeMap(json);
	}

	public IUserService getUserService()
	{
		return userService;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public IRoleService getRoleService()
	{
		return roleService;
	}

	public void setRoleService(IRoleService roleService)
	{
		this.roleService = roleService;
	}

	public List<Role> getAllRole()
	{
		return allRole;
	}

	public void setAllRole(List<Role> allRole)
	{
		this.allRole = allRole;
	}

	public Pagination getPage()
	{
		return page;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
}
