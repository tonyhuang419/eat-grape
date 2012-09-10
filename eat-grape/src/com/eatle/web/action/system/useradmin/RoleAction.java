/**
 */
package com.eatle.web.action.system.useradmin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.system.useradmin.Priv;
import com.eatle.persistent.pojo.system.useradmin.PrivTree;
import com.eatle.persistent.pojo.system.useradmin.Role;
import com.eatle.persistent.pojo.system.useradmin.RolePrivilege;
import com.eatle.service.system.useradmin.IPrivService;
import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.service.system.useradmin.IRoleService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.utils.TreeUtil;
import com.eatle.web.action.BaseAction;

/**
 *@Title:
 *@Description:
 *@Author:xt
 *@Since:2012-6-20
 *@Version:1.1.0
 */
public class RoleAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	private IRoleService roleService;

	@Resource
	private IPrivService privService;
	
	@Resource
	private IRolePrivilegeService rolePrivilegeService;

	private Pagination page;

	private Role role;

	private List<PrivTree> topPrivTrees;

	private List<Priv> havePrivs;

	private String privsIds; 	// 为角色分配权限需要保存的权限的id集合

	/**
	 * 
	 * @Description:显示首页
	 * 
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
		page = roleService.findPagination(params, pageNum, pageSize);

		return "showIndex";
	}

	public String showAdd()
	{
		return "showAdd";
	}

	public void add() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (role == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			roleService.add(role);
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (role == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			roleService.delete(role);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		role = roleService.findById(role.getId());
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (role == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			roleService.update(role);
		}
		super.writeMap(json);
	}

	public String showSetPriv()
	{
		havePrivs = roleService.findPrivsByRoleId(role.getId());
		topPrivTrees = privService.findPrivTree();
		request.setAttribute("privTreeStr", TreeUtil.getTreeString(
				topPrivTrees, havePrivs).toString());
		request.setAttribute("topPrivTrees", topPrivTrees);
		return "showSetPriv";
	}
	
	public void setPriv() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (privsIds == "" || privsIds == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			for (String id : privsIds.split(","))
			{
				RolePrivilege rp = new RolePrivilege();
				rp.setRoleId(role.getId());
				rp.setPrivId(Long.parseLong(id));
				rolePrivilegeService.add(rp);
			}
		}
		super.writeMap(json);
	}

	public Pagination getPage()
	{
		return page;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public List<Priv> getHavePrivs()
	{
		return havePrivs;
	}

	public void setHavePrivs(List<Priv> havePrivs)
	{
		this.havePrivs = havePrivs;
	}

	public IRoleService getRoleService()
	{
		return roleService;
	}

	public void setRoleService(IRoleService roleService)
	{
		this.roleService = roleService;
	}

	public IPrivService getPrivService()
	{
		return privService;
	}

	public void setPrivService(IPrivService privService)
	{
		this.privService = privService;
	}

	public IRolePrivilegeService getRolePrivilegeService()
	{
		return rolePrivilegeService;
	}

	public void setRolePrivilegeService(IRolePrivilegeService rolePrivilegeService)
	{
		this.rolePrivilegeService = rolePrivilegeService;
	}

	public List<PrivTree> getTopPrivTrees()
	{
		return topPrivTrees;
	}

	public void setTopPrivTrees(List<PrivTree> topPrivTrees)
	{
		this.topPrivTrees = topPrivTrees;
	}

	public String getPrivsIds()
	{
		return privsIds;
	}

	public void setPrivsIds(String privsIds)
	{
		this.privsIds = privsIds;
	}
}
