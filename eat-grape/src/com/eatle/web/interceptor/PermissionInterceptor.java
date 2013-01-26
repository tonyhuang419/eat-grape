package com.eatle.web.interceptor;

import com.eatle.web.action.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：权限拦截验证
 * @version 日期：2012-9-15 下午02:12:33
 */
public class PermissionInterceptor extends BaseAction implements Interceptor {

	private static final long serialVersionUID = -7773237323227039638L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception 
	{
//		Map<String, Object> session = invocation.getInvocationContext().getSession();
		// 拥有的权限集合
//		Map<String, Priv> allPrivs = ((User) session.get("user")).getAllPrivs();
		// 请求的动作的动作指令
//		String action = (String) getRequestParameters(ServletActionContext.getRequest()).get("action");
		// 请求来源URL
//		String referer = ServletActionContext.getRequest().getHeader("referer");
		
		//TODO　暂时注释
		/*if(allPrivs.get(action) == null)
		{
			if(referer == null || "".equals(referer))
			{
				return "nopower";
			}
			else
			{
			    Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
			    json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			    json.put("message", "抱歉，您没有操作权限！");
			    writeMap(json);
			    return null;
			}
		}*/
		return invocation.invoke();
	}
}
