package com.eatle.web.action.backend.system.systemdata;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.system.systemdata.SystemInfo.*;
import com.eatle.service.system.systemdata.ISystemInfoService;
import com.eatle.web.action.BaseAction;

public class SystemInfoAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	@Resource
	ISystemInfoService systemInfoService;

	private ServerInfo serverInfo;

	private ClientInfo clientInfo;

	public ServerInfo getServerInfo()
	{
		return serverInfo;
	}

	public void setServerInfo(ServerInfo serverInfo)
	{
		this.serverInfo = serverInfo;
	}

	public ClientInfo getClientInfo()
	{
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clientInfo)
	{
		this.clientInfo = clientInfo;
	}

	public String showIndex()
	{
		serverInfo = systemInfoService.getServerInfo(request);
		clientInfo = systemInfoService.getClientInfo(request);

		return "showIndex";
	}
	
	public void ajaxLoadSystemInfo() throws IOException
	{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		serverInfo = systemInfoService.getServerInfo(request);
		clientInfo = systemInfoService.getClientInfo(request);
		
		jsonMap.put("serverInfo", serverInfo);
		jsonMap.put("clientInfo", clientInfo);
		
		super.writeMap(jsonMap);
	}
}