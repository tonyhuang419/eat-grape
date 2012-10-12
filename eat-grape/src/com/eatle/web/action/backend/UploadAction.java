package com.eatle.web.action.backend;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.ImageUtil;
import com.eatle.utils.StringUtil;
import com.eatle.web.action.BaseAction;

/**
 * @corpor: 公司：深讯信科
 * @author: 作者：谭又中
 * @explain: 释义：数据导出到Excel
 * @version: 日期：2012-10-11 上午09:41:33
 */
public class UploadAction extends BaseAction
{
	private static final long serialVersionUID = -4673924683393088523L;

	@Resource
	private IMerchantService merchantService;

	private Long id; 							// 标识ID

	private File[] logo; 						// 封装文件上传域

	private String[] logoFileName; 				// 封装上传文件名

	private String[] logoContentType; 			// 封装上传文件类型

	private String savePath; 					// 保存路径(struts.xml中配置)

	private long maxSize; 						// 允许的文件大小(struts.xml中配置)

	private String allowTypes; 					// 允许的文件类型(struts.xml中配置)
	
	private boolean isCrossValidate = false;	// 是否通过校验

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public File[] getLogo()
	{
		return logo;
	}

	public void setLogo(File[] logo)
	{
		this.logo = logo;
	}

	public String[] getLogoFileName()
	{
		return logoFileName;
	}

	public void setLogoFileName(String[] logoFileName)
	{
		this.logoFileName = logoFileName;
	}

	public String[] getLogoContentType()
	{
		return logoContentType;
	}

	public void setLogoContentType(String[] logoContentType)
	{
		this.logoContentType = logoContentType;
	}

	public String getSavePath()
	{
		return savePath;
	}

	public void setSavePath(String savePath)
	{
		this.savePath = savePath;
	}

	public long getMaxSize()
	{
		return maxSize;
	}

	public void setMaxSize(long maxSize)
	{
		this.maxSize = maxSize;
	}

	public String getAllowTypes()
	{
		return allowTypes;
	}

	public void setAllowTypes(String allowTypes)
	{
		this.allowTypes = allowTypes;
	}

	/**
	 * @throws IOException
	 * @deprecated: 商家Logo上传
	 */
	public void merchantLogoUpload() throws IOException
	{
		if(isCrossValidate)
		{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_DIALOGID, dialogId);
		if (logo != null)
		{
			for (int i = 0; i < logo.length; i++)
			{
				// 生成文件UUID名称
				String uuidName = StringUtil.getUUIDName(logoFileName[i]);
				// 保存文件
				String saveName = ServletActionContext.getServletContext()
						.getRealPath(getSavePath()) + File.separator + uuidName;
				ImageUtil.thumbnails(logo[i], new File(saveName), 60);
				// 更新商家LogoUrl
				Merchant merchant = merchantService.findById(id);
				String oldLogoPath = ServletActionContext.getServletContext()
						.getRealPath(merchant.getMerchantLogoUrl());
				File oldLogoFile = new File(oldLogoPath == null ? "" : oldLogoPath);
				if (oldLogoFile.exists())
				{
					oldLogoFile.delete();
				}
				merchant.setMerchantLogoUrl(getSavePath() + "/" + uuidName);
				merchantService.update(merchant);
			}
		}
		else
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "请选择要上传的文件！");
		}
		super.writeMap(json);
		}
	}

	/**
	 * @throws IOException
	 * @deprecated: 手动校验文件类型和文件大小
	 */
	public void validate()
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "");
		// 校验文件类型
		String[] fileTypes = getLogoContentType(); 		// 获取上传文件的类型
		String[] types = getAllowTypes().split(","); 	// 获取允许上传的文件类型
		String state_type = "";
		String state_size = "";

		if(logo != null && fileTypes != null)
		{
			for (String type : types)
			{
				for (String fileType : fileTypes)
				{
					if (type.equals(fileType))
					{
						state_type = "yes";
					}
				}
			}
			if (state_type != "yes")
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "文件类型受限，请选择图形文件！");
			}

			// 校验文件大小
			for (int i = 0; i < logo.length; i++)
			{
				if (logo[i].length() < getMaxSize())
				{
					state_size = "yes";
				}
			}
			if (state_size != "yes")
			{
				json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
				json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "文件大小受限，文件必须小于1MB！");
			}
		}
		else
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "请选择要上传的文件！");
		}
		
		if(json.get(DwzAjaxJsonUtil.KEY_MESSAGE) != "")
		{
			try
			{
				isCrossValidate = false;
				super.writeMap(json);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			isCrossValidate = true;
		}
	}
}