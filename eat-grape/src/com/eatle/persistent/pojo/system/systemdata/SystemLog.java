package com.eatle.persistent.pojo.system.systemdata;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：系统日志
 * @version 日期：2013-2-19 下午04:52:49
 */
public class SystemLog
{
	private String fileName;

	private String fileSize;

	private String lastModified;

	private String content;

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileSize()
	{
		return fileSize;
	}

	public void setFileSize(String fileSize)
	{
		this.fileSize = fileSize;
	}

	public String getLastModified()
	{
		return lastModified;
	}

	public void setLastModified(String lastModified)
	{
		this.lastModified = lastModified;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
