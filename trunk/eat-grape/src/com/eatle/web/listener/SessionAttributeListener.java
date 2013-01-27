package com.eatle.web.listener; 

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：监听Session域的属性添加和移除（实现在线人数统计）
 *  @version 日期：2013-1-27 下午01:48:09 
 */
public class SessionAttributeListener implements HttpSessionAttributeListener
{
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe)
	{
		if(hsbe.getName().equals("user"))
		{
			ServletContext ctx = hsbe.getSession().getServletContext();
			int sessionCount = (Integer) ctx.getAttribute("sessionCount");
			ctx.setAttribute("sessionCount", sessionCount + 1);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe)
	{
		if(hsbe.getName().equals("user"))
		{
			ServletContext ctx = hsbe.getSession().getServletContext();
			int sessionCount = (Integer) ctx.getAttribute("sessionCount");
			ctx.setAttribute("sessionCount", sessionCount < 1 ? 0 : sessionCount - 1);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent hsbe)
	{

	}
}
 