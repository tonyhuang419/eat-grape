package com.eatle.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.eatle.persistent.pojo.system.useradmin.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 
 * @author shijin
 * session拦截器
 *
 */
public class SessionInterceptor implements Interceptor {

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
			return "timeout";
		}
		return invocation.invoke();
	}
}
