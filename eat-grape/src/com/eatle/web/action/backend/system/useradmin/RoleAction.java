package com.eatle.web.action.backend.system.useradmin;

import java.io.IOException;
import java.util.ArrayList;
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
 *@Author:xiangtao, tanyouzhong
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

	private List<PrivTree> topPrivTrees;	// 系统存在的所有权限

	private List<Priv> havePrivs;			// 当前分配角色所拥有的权限

	private String allPrivHtml;				// 权限分配展示树HTML

	private String privsIds; 				// 为角色分配权限需要保存的权限的id集合

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
			if(roleService.add(role) < 1)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "角色已存在，请重新输入！");
			}
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
			if(roleService.delete(role) < 1)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "删除失败！");
			}
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		role = roleService.findById(role.getId());
		
		// 存入修改的角色，执行修改时查重使用
		session.put("oldRole", role);
		
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
			if(roleService.update(role, (Role) session.get("oldRole")) < 1)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "角色已存在，请重新输入！");
			}
			session.remove("oldRole");
		}
		super.writeMap(json);
	}

	public String showSetPriv()
	{
		havePrivs = roleService.findPrivsByRoleId(role.getId());
		topPrivTrees = privService.findPrivTree();
		allPrivHtml = TreeUtil.getTreeString(topPrivTrees, havePrivs).toString();
		
		// 存入分配前拥有的权限ID集合
		List<Long> oldPrivIds = new ArrayList<Long>();
		for(Priv priv : havePrivs)
		{
			oldPrivIds.add(priv.getId());
		}
		session.put("oldPrivIds", oldPrivIds);
		
		return "showSetPriv";
	}

	@SuppressWarnings("unchecked")
	public void setPriv() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		if (privsIds == "" || privsIds == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			// 获取分配前拥有的权限
			List<Long> oldPrivIds = (List<Long>) session.get("oldPrivIds");
			
			// 执行权限分配
			for (String id : privsIds.split(","))
			{
				// 新分配的权限中包含分配前已有的权限，则不做任何数据库动作，从分配前的权限集合中移除
				if(oldPrivIds.contains(Long.parseLong(id)))
				{
					oldPrivIds.remove(Long.parseLong(id));
				}
				else
				{
					// 新增分配前没有的权限
					RolePrivilege rp = new RolePrivilege();
					rp.setRoleId(role.getId());
					rp.setPrivId(Long.parseLong(id));
					rolePrivilegeService.add(rp);
				}
			}
			// 将分配前有的权限，然而分配后没有的权限删除掉
			for(Long privId : oldPrivIds)
			{
				rolePrivilegeService.deleteByRoleIdAndPrivId(role.getId(), privId);
			}
		}
		// 清理内存，移除分配前拥有的权限ID集合
		session.remove("oldPrivIds");
		
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

	public void setRolePrivilegeService(
			IRolePrivilegeService rolePrivilegeService)
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

	public String getAllPrivHtml()
	{
		return allPrivHtml;
	}

	public void setAllPrivHtml(String allPrivHtml)
	{
		this.allPrivHtml = allPrivHtml;
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
