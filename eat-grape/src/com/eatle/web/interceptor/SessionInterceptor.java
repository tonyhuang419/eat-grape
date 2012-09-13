package com.eatle.web.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.web.action.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author tanyouzhong
 * session拦截器
 */
public class SessionInterceptor extends BaseAction implements Interceptor {

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
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		// 请求来源URL
		String referer = ServletActionContext.getRequest().getHeader("referer");
		if(session.get("user") == null)
		{
			if(referer == null || "".equals(referer)
					|| referer.endsWith("nopower.jsp"))
			{
				return "timeout";
			}
			else
			{
				Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
			    json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 301);
			    json.put("message", "登录超时，请您重新登录！");
			    writeMap(json);
			}
		}
		return invocation.invoke();
	}
}
