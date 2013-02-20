package com.eatle.web.action.backend.system.systemdata;

import com.eatle.persistent.pojo.system.systemdata.SystemLog;
import com.eatle.service.system.systemdata.ISystemLogService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.web.action.BaseAction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class SystemLogAction extends BaseAction
{
	private static final long serialVersionUID = -3728029047940484616L;

	@Resource
	private ISystemLogService systemLogService;

	private List<SystemLog> systemLogs;
	
	private SystemLog systemLog;

	public List<SystemLog> getSystemLogs()
	{
		return systemLogs;
	}

	public void setSystemLogs(List<SystemLog> systemLogs)
	{
		this.systemLogs = systemLogs;
	}

	public SystemLog getSystemLog()
	{
		return systemLog;
	}

	public void setSystemLog(SystemLog systemLog)
	{
		this.systemLog = systemLog;
	}

	/**
	 * @Description: 展示所有日志文件
	 */
	public String showIndex() throws ParseException
	{
		systemLogs = systemLogService.getAllLogs(request.getSession()
				.getServletContext().getInitParameter("log.path"));
		return "showIndex";
	}

	/**
	 * @Description: 查看日志文件
	 * @throws IOException 
	 */
	public String detail() throws IOException
	{
		systemLog.setContent(systemLogService.getLogFileContent(
			new File(request.getSession().getServletContext()
				.getInitParameter("log.path") + File.separator 
					+ systemLog.getFileName())));
		return "detail";
	}

	/**
	 * @Description: 删除日志文件
	 */
	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (systemLog == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			boolean result = systemLogService.deleteLogFile(new File(request.getSession()
				.getServletContext().getInitParameter("log.path") + File.separator + systemLog.getFileName()));
			if(!result)
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
			}
		}
		super.writeMap(json);
	}

	/**
	 * @throws FileNotFoundException 
	 * @Description: 为下载日志文件返回输入流
	 */
	public InputStream getLogFile() throws FileNotFoundException
	{
		return systemLogService.getLogFileInputStream(
			new File(request.getSession().getServletContext()
			.getInitParameter("log.path") + File.separator + systemLog.getFileName()));
	}

	/**
	 * @Description: 下载日志文件
	 */
	public String downLog() throws Exception
	{
		return SUCCESS;
	}
}