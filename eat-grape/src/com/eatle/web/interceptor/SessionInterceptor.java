package com.eatle.web.interceptor;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
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
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object obj = session.getAttribute("user");
		if(obj == null){
			return "timeout";
		}
		return invocation.invoke();
	}
}
