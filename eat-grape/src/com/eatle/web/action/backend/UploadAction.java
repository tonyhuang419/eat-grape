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

public class UploadAction extends BaseAction
{
	private static final long serialVersionUID = -4673924683393088523L;

	@Resource
	private IMerchantService merchantService;

	private Long id; 					// 标识ID

	private File[] logo; 				// 封装文件上传域

	private String[] logoFileName; 		// 封装上传文件名
	
	private String savePath; 			// 保存路径(struts.xml中配置)
	
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

	public String getSavePath()
	{
		return savePath;
	}

	public void setSavePath(String savePath)
	{
		this.savePath = savePath;
	}
	

	/**
	 * @throws IOException
	 * @deprecated: 商家Logo上传
	 */
	public void merchantLogoUpload() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
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
				if(oldLogoFile.exists())
				{
					oldLogoFile.delete();
				}
				merchant.setMerchantLogoUrl(getSavePath() + File.separator + uuidName);
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