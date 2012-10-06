package com.eatle.web.action.backend;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.eatle.persistent.pojo.system.basedata.Menu;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.utils.ExcelUtil;
import com.eatle.utils.ExcelUtil.ExportSetInfo;
import com.eatle.web.action.BaseAction;

public class DownloadAction extends BaseAction
{
	private static final long serialVersionUID = -8529832147792896689L;
	
	@Resource
	private IUserService userService;

	// 下载文件名
	private String fileName;

	// 账号数据导出Excel下载
	public InputStream getUserExcel()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			List<String[]> headNames = new ArrayList<String[]>();
			headNames.add(new String[]{"用户名","密码","电子邮件","类型","角色"});
			
			ExportSetInfo setInfo = new ExportSetInfo();
			setInfo.setObjsMap(userService.getExportData());
			setInfo.setClazz(new Class[]{User.class, Menu.class, Menu.class});
			setInfo.setTitles(new String[]{"馋八戒后台用户数据"});
			setInfo.setStartFieldIndexs(new int[]{2});
			setInfo.setEndFieldIndexs(new int[]{6});
			setInfo.setHeadNames(headNames);
			setInfo.setOut(baos);
			// 将需要导出的数据输出到baos
			ExcelUtil.export2Excel(setInfo);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	public String downXls() throws Exception
	{
		return SUCCESS;
	}
	
	
	public IUserService getUserService()
	{
		return userService;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}
	
	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
}