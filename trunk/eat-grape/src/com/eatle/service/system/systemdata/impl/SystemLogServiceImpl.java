package com.eatle.service.system.systemdata.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eatle.persistent.pojo.system.systemdata.SystemLog;
import com.eatle.service.system.systemdata.ISystemLogService;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：系统日志业务组件实现
 * @version 日期：2013-2-19 下午05:10:29
 */
@Service("systemLogService")
public class SystemLogServiceImpl implements ISystemLogService
{
	@Override
	public boolean deleteLogFile(File logFile)
	{
		return logFile.delete();
	}

	@Override
	public List<SystemLog> getAllLogs(String logFilePath)
	{
		List<SystemLog> list = new ArrayList<SystemLog>();
		File[] logFiles = new File(logFilePath).listFiles();
		for (File f : logFiles)
		{
			SystemLog sl = new SystemLog();
			sl.setFileName(f.getName());
			sl.setFileSize(NumberFormat.getInstance().format(
					(f.length() / Math.pow(1024.0, 1))) + " KB");
			sl.setLastModified(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date(f.lastModified())));

			list.add(sl);
		}
		return list;
	}

	@Override
	public InputStream getLogFileInputStream(File logFile)
			throws FileNotFoundException
	{
		return new FileInputStream(logFile);
	}

	@Override
	public String getLogFileContent(File logFile) throws IOException
	{
		StringBuffer content = new StringBuffer();
		String buffer = new String();
		BufferedReader br = new BufferedReader(new FileReader(logFile));
		while ((buffer = br.readLine()) != null)
		{
			content.append("<li>"+buffer + "</li>");
		}
		return content.toString();
	}
}