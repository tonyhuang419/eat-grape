package com.eatle.service.system.systemdata.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.eatle.persistent.pojo.system.systemdata.SystemInfo.*;
import com.eatle.service.system.systemdata.ISystemInfoService;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：系统信息业务组件实现
 * @version 日期：2013-1-26 下午07:33:38
 */
@Service("systemInfoService")
public class SystemInfoServiceImpl implements ISystemInfoService
{
	@Resource
	private ServerInfo serverInfo;

	@Resource
	private ClientInfo clientInfo;

	@Override
	public ServerInfo getServerInfo(HttpServletRequest request)
	{
		ServletContext ctx = request.getSession().getServletContext();

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(6);
		Runtime rt = Runtime.getRuntime();
		
		serverInfo.setServerName(request.getServerName());
		serverInfo.setServerDir(System.getProperty("user.dir"));
		serverInfo.setServerDns(System.getenv().get("USERDOMAIN"));
		serverInfo.setServerIp(request.getLocalAddr());
		serverInfo.setServerPort(request.getLocalPort());
		serverInfo.setServerTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		serverInfo.setServerRunTime(calculateRunTime(ctx));
		serverInfo.setOsName(System.getProperty("os.name"));
		serverInfo.setOsArch(System.getProperty("os.arch"));
		serverInfo.setOsVersion(System.getProperty("os.version"));
		serverInfo.setJavaHome(System.getProperty("java.home"));
		serverInfo.setJavaVersion(System.getProperty("java.version"));
		serverInfo.setTotalMemory(nf.format(rt.totalMemory() / 1024 / 1024.0));
		serverInfo.setFreeMemory(nf.format(rt.freeMemory() / 1024 / 1024.0));
		serverInfo.setMaxMemory(nf.format(rt.maxMemory() / 1024 / 1024.0));
		serverInfo.setSessionCount((Integer) ctx.getAttribute("sessionCount"));
		serverInfo.setApplicationCount(calculateApplicationCount(ctx));
		return serverInfo;
	}

	@Override
	public ClientInfo getClientInfo(HttpServletRequest request)
	{
		clientInfo.setClientIp(request.getRemoteAddr());
		clientInfo.setClientPort(request.getRemotePort());
		clientInfo.setClientAgent(request.getHeader("User-Agent"));
		clientInfo.setLanguage(StringUtils.split(request.getHeader("Accept-Language"), ",")[0]);
		return clientInfo;
	}

	/**
	 * @Description: 计算服务器已运行时间
	 */
	private String calculateRunTime(ServletContext ctx)
	{
		// 获取服务器启动时间
		Long startTime = (Long) ctx.getAttribute("startupTime");
		// 计算出服务器已运行的秒数
		Long runTimeSeconds = (System.currentTimeMillis() - startTime) / 1000;
		
		int day = (int) (runTimeSeconds / (60 * 60 * 24));
		int hour = (int) ((runTimeSeconds - day * 60 * 60) / 60 / 60);
		int minute = (int) ((runTimeSeconds - day * 60 * 60 * 24 - hour * 60 * 60) / 60);
		
		String runTime = day + "天" + hour + "小时" + minute + "分钟" + runTimeSeconds % 60 + "秒";
		
		return runTime;
	}

	/**
	 * @Description: 计算Application数量
	 */
	@SuppressWarnings("unchecked")
	private int calculateApplicationCount(ServletContext ctx)
	{
		int applicationCount = 0;
		Enumeration e = ctx.getAttributeNames();
		while(e.hasMoreElements())
		{
			applicationCount ++;
			e.nextElement();
		}
		return applicationCount;
	}
}
