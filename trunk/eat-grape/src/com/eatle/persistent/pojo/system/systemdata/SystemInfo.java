package com.eatle.persistent.pojo.system.systemdata;

import org.springframework.stereotype.Component;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：系统信息封装对象
 * @version 日期：2013-1-26 下午07:11:11
 */
public class SystemInfo
{
	/**
	 * @corpor 公司：深讯信科
	 * @author 作者：谭又中
	 * @explain 释义：服务器信息封装对象
	 * @version 日期：2013-1-26 下午07:11:11
	 */
	@Component("serverInfo")
	public static class ServerInfo
	{
		private String serverName; // 服务器名称

		private String serverDir; // 服务器当前工作目录

		private String serverDns; // 服务器域名

		private String serverIp; // 服务器IP

		private Integer serverPort; // 服务器端口

		private String serverTime; // 服务器当前时间

		private String serverRunTime; // 服务器运行时间

		private String osName; // 操作系统名称

		private String osArch; // 操作系统架构

		private String osVersion; // 操作系统版本

		private String javaHome; // JRE安装路径

		private String javaVersion; // JRE版本

		private String totalMemory; // 总共内存

		private String freeMemory; // 剩余内存

		private String maxMemory; // 最大内存

		private Integer sessionCount; // 当前Seesion总数

		private Integer applicationCount; // Application总数

		public String getServerName()
		{
			return serverName;
		}

		public void setServerName(String serverName)
		{
			this.serverName = serverName;
		}

		public String getServerDir()
		{
			return serverDir;
		}

		public void setServerDir(String serverDir)
		{
			this.serverDir = serverDir;
		}

		public String getServerDns()
		{
			return serverDns;
		}

		public void setServerDns(String serverDns)
		{
			this.serverDns = serverDns;
		}

		public String getServerIp()
		{
			return serverIp;
		}

		public void setServerIp(String serverIp)
		{
			this.serverIp = serverIp;
		}

		public Integer getServerPort()
		{
			return serverPort;
		}

		public void setServerPort(Integer serverPort)
		{
			this.serverPort = serverPort;
		}

		public String getServerTime()
		{
			return serverTime;
		}

		public void setServerTime(String serverTime)
		{
			this.serverTime = serverTime;
		}

		public String getServerRunTime()
		{
			return serverRunTime;
		}

		public void setServerRunTime(String serverRunTime)
		{
			this.serverRunTime = serverRunTime;
		}

		public String getOsName()
		{
			return osName;
		}

		public void setOsName(String osName)
		{
			this.osName = osName;
		}

		public String getOsArch()
		{
			return osArch;
		}

		public void setOsArch(String osArch)
		{
			this.osArch = osArch;
		}

		public String getOsVersion()
		{
			return osVersion;
		}

		public void setOsVersion(String osVersion)
		{
			this.osVersion = osVersion;
		}

		public String getJavaHome()
		{
			return javaHome;
		}

		public void setJavaHome(String javaHome)
		{
			this.javaHome = javaHome;
		}

		public String getJavaVersion()
		{
			return javaVersion;
		}

		public void setJavaVersion(String javaVersion)
		{
			this.javaVersion = javaVersion;
		}

		public String getTotalMemory()
		{
			return totalMemory;
		}

		public void setTotalMemory(String totalMemory)
		{
			this.totalMemory = totalMemory;
		}

		public String getFreeMemory()
		{
			return freeMemory;
		}

		public void setFreeMemory(String freeMemory)
		{
			this.freeMemory = freeMemory;
		}

		public String getMaxMemory()
		{
			return maxMemory;
		}

		public void setMaxMemory(String maxMemory)
		{
			this.maxMemory = maxMemory;
		}

		public Integer getSessionCount()
		{
			return sessionCount;
		}

		public void setSessionCount(Integer sessionCount)
		{
			this.sessionCount = sessionCount;
		}

		public Integer getApplicationCount()
		{
			return applicationCount;
		}

		public void setApplicationCount(Integer applicationCount)
		{
			this.applicationCount = applicationCount;
		}
	}

	/**
	 * @corpor 公司：深讯信科
	 * @author 作者：谭又中
	 * @explain 释义：客户端信息封装对象
	 * @version 日期：2013-1-26 下午07:11:11
	 */
	@Component("clientInfo")
	public static class ClientInfo
	{
		private String clientIp; // 客户端IP

		private Integer clientPort; // 客户端端口

		private String clientAgent; // 客户端浏览器及系统信息

		private String language; // 客户端语言环境

		public String getClientIp()
		{
			return clientIp;
		}

		public void setClientIp(String clientIp)
		{
			this.clientIp = clientIp;
		}

		public Integer getClientPort()
		{
			return clientPort;
		}

		public void setClientPort(Integer clientPort)
		{
			this.clientPort = clientPort;
		}

		public String getClientAgent()
		{
			return clientAgent;
		}

		public void setClientAgent(String clientAgent)
		{
			this.clientAgent = clientAgent;
		}

		public String getLanguage()
		{
			return language;
		}

		public void setLanguage(String language)
		{
			this.language = language;
		}
	}
}
