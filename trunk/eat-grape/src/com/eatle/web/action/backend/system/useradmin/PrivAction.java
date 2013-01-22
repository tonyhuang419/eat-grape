package com.eatle.web.action.backend.system.useradmin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.common.Constants;
import com.eatle.persistent.pojo.foundation.dictionary.ShopType;
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
public class PrivAction extends BaseAction
{
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
		params.put("pidisnull", null);
		page = privService.findPagination(params, pageNum, pageSize);

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
		json.put(DwzAjaxJsonUtil.KEY_DIALOGID, dialogId);
		json.put("pid", priv.getPid());
		if (priv == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			int result = privService.add(priv);
			if(result == Constants.Base.REPEAT)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "动作指令已存在，请重新输入！");
			}
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_DIALOGID, dialogId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (priv == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			if(privService.delete(priv) < 1)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "删除失败！");
			}
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		priv = privService.findById(priv.getId());
		
		// 存入修改的权限，执行修改时查重使用
		session.put("oldPriv", priv);
		
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_DIALOGID, dialogId);
		if (priv == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			int result = privService.update(priv, (Priv) session.get("oldPriv"));
			if(result == Constants.Base.REPEAT)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "动作指令已存在，请重新输入！");
			}
			else if(result == Constants.Base.SUCCESS)
			{
				session.remove("oldPriv");
			}
		}
		super.writeMap(json);
	}

	public String showSetSubPriv()
	{
		Map<String, Object> params = super.getRequestParameters(request);
		Object pid = params.get("pid");
		PrivCriteria privCriteria = new PrivCriteria();
		Criteria criteria = privCriteria.createCriteria();
		criteria.andPIdIsNotNull();
		criteria.andPIdEqualTo(Long.parseLong((String) pid));
		list = privService.findByCriteria(privCriteria);

		return "showSetSubPriv";
	}
	
	
	public String showIndexVm(){
		return "showIndexVm";
	}

	public Pagination getPage()
	{
		return page;
	}

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Priv getPriv()
	{
		return priv;
	}

	public void setPriv(Priv priv)
	{
		this.priv = priv;
	}

	public List<Priv> getList()
	{
		return list;
	}

	public void setList(List<Priv> list)
	{
		this.list = list;
	}
}
