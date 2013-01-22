package com.eatle.web.action.backend.system.useradmin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.common.Constants;
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
			int result = userService.add(user);
			if(result == Constants.Base.REPEAT)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "用户已存在，请重新输入！");
			}
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
			if(userService.delete(user) < 1)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "删除失败！");
			}
		}
		super.writeMap(json);

	}

	public String showUpdate()
	{
		// 修改的用户
		user = userService.findById(user.getId());
		// 所有角色
		allRole = roleService.findAll();
		// 存入修改的用户，执行修改时查重使用
		session.put("oldUser", user);
		
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
			int result = userService.update(user, (User) session.get("oldUser"));
			if(result == Constants.Base.REPEAT)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "用户已存在，请重新输入！");
			}
			else if(result == Constants.Base.SUCCESS)
			{
				session.remove("oldUser");
			}
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
