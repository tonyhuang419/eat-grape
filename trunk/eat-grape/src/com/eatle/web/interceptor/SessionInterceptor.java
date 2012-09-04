package com.eatle.web.interceptor;

import java.util.Map;

import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.web.action.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 
 * @author tanyouzhong
 * session拦截器
 *
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
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		if(session.get("user") == null){
		    Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		    json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 301);
		    json.put("message", "登陆超时，请重新登录！");
		    writeMap(json);
		}
		return invocation.invoke();
	}
}
