package com.eatle.service.system.systemdata;

import javax.servlet.http.HttpServletRequest;

import com.eatle.persistent.pojo.system.systemdata.SystemInfo.*;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：系统信息业务组件接口
 * @version 日期：2013-1-26 下午07:29:38
 */
public interface ISystemInfoService
{
	/**
	 * @Description: 获取服务器信息
	 */
	ServerInfo getServerInfo(HttpServletRequest request);

	/**
	 * @Description: 获取客户端信息
	 */
	ClientInfo getClientInfo(HttpServletRequest request);
}
