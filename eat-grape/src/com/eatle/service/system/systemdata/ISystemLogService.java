package com.eatle.service.system.systemdata; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.eatle.persistent.pojo.system.systemdata.SystemLog;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：系统日志业务组件接口
 *  @version 日期：2013-2-19 下午05:00:14 
 */
public interface ISystemLogService
{
	/**
	 * @Description: 获取所有日志
	 */
	List<SystemLog> getAllLogs(String logFilePath);

	/**
	 * @Description: 获取日志文件输入流（提供下载）
	 */
	InputStream getLogFileInputStream(File logFile) throws FileNotFoundException;

	/**
	 * @Description: 获取日志文件内容（提供查看）
	 */
	String getLogFileContent(File logFile) throws IOException;

	/**
	 * @Description: 删除日志文件
	 */
	boolean deleteLogFile(File logFile);
}
 