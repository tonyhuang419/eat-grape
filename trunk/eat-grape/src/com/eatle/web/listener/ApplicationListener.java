package com.eatle.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：监听Web容器启动
 * @version 日期：2013-1-27 上午12:27:45
 */
public class ApplicationListener implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		// 记录Web容器启动时间（用于计算服务器已运行时间）
		sce.getServletContext().setAttribute("startupTime", System.currentTimeMillis());
		// 初始化Session数量
		sce.getServletContext().setAttribute("sessionCount", 0);

		// 设置VM系统变量
		System.setProperty("log.path", sce.getServletContext().getInitParameter("log.path"));	// 日志保存路径
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		sce.getServletContext().removeAttribute("startupTime");
	}
}
