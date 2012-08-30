package com.eatle.action;

/**
 * xt
 * 2011-11-14
 */

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport implements  SessionAware, ServletRequestAware, ServletResponseAware {

     private static final long serialVersionUID = 863288218722339735L;

     protected static final Log logger = LogFactory.getLog(BaseAction.class);

     protected Map<String, Object> session;
 	 protected HttpServletRequest request;
 	 protected HttpServletResponse response;

     protected String ERROR_CODE_404 = "404";

     protected String FAIL = "fail";

     protected String INPUT = "input";

     protected String BLANK = "";

     protected String message;

     protected Map<String, Object> resultMap = new HashMap<String, Object>();
     
     protected String navTabId = "";
     protected String dialogId = "";

     /**
      * 获取请求参数
      * 
      * @param request
      * @return
      * @exception
      * @see
      * @since
      */
     @SuppressWarnings("rawtypes")
     public Map<String, Object> getRequestParameters(HttpServletRequest request) {
          Map<String, Object> map = new HashMap<String, Object>();
          Enumeration parameters = request.getParameterNames();
          while (parameters.hasMoreElements()) {
               String key = parameters.nextElement().toString();
               String value = request.getParameter(key);
               if(value != null && !"".equals(value)){
            	   map.put(key, value);
               }
          }

          return map;
     }
     
     protected void writeInResponse(String sth) throws IOException {
 		this.writeInResponse(null, sth);
 	}
     
     protected void writeInResponse(String contentType, String sth) throws IOException {
 		if (contentType == null || contentType.equals("")) {
 			contentType = "text/html;charset=utf-8";
 		}
 		HttpServletResponse response = ServletActionContext.getResponse();
 		response.setContentType(contentType);
 		response.setHeader("cache-control", "no-cache");
 		response.setHeader("pragma", "no-cache");
 		response.setHeader("expires", "0");
		Writer writer = response.getWriter();
		writer.write(sth);
		writer.close();
 	}
     
     protected void writeMap(Map<?, ?> map) throws IOException {
    	JsonConfig config = new JsonConfig();
    	config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
  		String json = JSONObject.fromObject(map, config).toString();
  		writeInResponse(json);
  	 }
     
     protected void writeList(List<?> list, JsonConfig config) throws IOException {
 		HashMap<String, Object> h = new HashMap<String, Object>();
 		h.put("total", list.size());
 		h.put("rows", list);
 		String json = JSONObject.fromObject(h, config).toString();
 		writeInResponse(json);
 	 }
     

     public Map<String, Object> getResultMap() {
          return resultMap;
     }

     public void setResultMap(Map<String, Object> resultMap) {
          this.resultMap = resultMap;
     }
     
     public String getMessage() {
         return message;
    }

    public void setMessage(String message) {
         this.message = message;
    }

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String getDialogId() {
		return dialogId;
	}

	public void setDialogId(String dialogId) {
		this.dialogId = dialogId;
	}
}
