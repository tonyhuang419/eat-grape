package com.eatle.web.action.backend;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.eatle.persistent.pojo.foundation.dictionary.MenuFeature;
import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoods;
import com.eatle.persistent.pojo.merchant.Merchant;
import com.eatle.persistent.pojo.merchant.Restaurant;
import com.eatle.persistent.pojo.system.frontdata.FriendshipLink;
import com.eatle.service.foundation.dictionary.IMenuFeatureService;
import com.eatle.service.foundation.scoreshop.IConvertGoodsService;
import com.eatle.service.merchant.IMerchantService;
import com.eatle.service.merchant.IRestaurantService;
import com.eatle.service.system.frontdata.IFriendshipLinkService;
import com.eatle.utils.ConfigurationRead;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.ImageUtil;
import com.eatle.utils.StringUtil;
import com.eatle.web.action.BaseAction;

/**
 * @corpor: 公司：深讯信科
 * @author: 作者：谭又中
 * @explain: 释义：文件上传处理
 * @version: 日期：2012-10-11 上午09:41:33
 */
public class UploadAction extends BaseAction
{
	private static final long serialVersionUID = -4673924683393088523L;

	@Resource
	private IMerchantService merchantService;
	
	@Resource
	private IRestaurantService restaurantService;
	
	@Resource
	private IMenuFeatureService menuFeatureService;
	
	@Resource
	private IFriendshipLinkService friendshipLinkService;
	
	@Resource
	private IConvertGoodsService convertGoodsService;
	
	private ConfigurationRead config = ConfigurationRead.getInstance();

	private Long id; 							// 标识ID

	private File[] logo; 						// 封装文件上传域

	private String[] logoFileName; 				// 封装上传文件名

	private String[] logoContentType; 			// 封装上传文件类型

//	private String savePath; 					// 保存路径(struts.xml中配置)

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

//	public String getSavePath()
//	{
//		return savePath;
//	}
//
//	public void setSavePath(String savePath)
//	{
//		this.savePath = savePath;
//	}

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
	 * @Description: 商家Logo上传
	 */
	public void merchantLogoUpload() throws IOException
	{
		// 检查是否通过类型和大小校验
		if(isCrossValidate)
		{
			Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
			if (logo != null)
			{
				for (int i = 0; i < logo.length; i++)
				{
					// 生成文件UUID名称
					String uuidName = StringUtil.getUUIDName(logoFileName[i]);
					// 保存路径
					String path = config.getConfigItem("merchant.logo");
					// 保存文件
					String saveName = ServletActionContext.getServletContext()
							.getRealPath(path) + File.separator + uuidName;
					ImageUtil.thumbnails(logo[i], new File(saveName), 70);
					// 更新商家LogoUrl
					Merchant merchant = merchantService.findById(id);
					String oldLogoPath = ServletActionContext.getServletContext()
							.getRealPath(merchant.getMerchantLogoUrl());
					File oldLogoFile = new File(oldLogoPath == null ? "" : oldLogoPath);
					if (oldLogoFile.exists())
					{
						oldLogoFile.delete();
					}
					merchant.setMerchantLogoUrl(path + "/" + uuidName);
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
	 * @Description: 餐厅Logo上传
	 */
	public void restaurantLogoUpload() throws IOException
	{
		// 检查是否通过类型和大小校验
		if(isCrossValidate)
		{
			Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
			if (logo != null)
			{
				for (int i = 0; i < logo.length; i++)
				{
					// 生成文件UUID名称
					String uuidName = StringUtil.getUUIDName(logoFileName[i]);
					// 保存路径
					String path = config.getConfigItem("restaurant.logo");
					// 保存文件
					String saveName = ServletActionContext.getServletContext()
							.getRealPath(path) + File.separator + uuidName;
					ImageUtil.thumbnails(logo[i], new File(saveName), 70);
					// 更新餐厅LogoUrl
					Restaurant restaurant = restaurantService.findById(id);
					String oldLogoPath = ServletActionContext.getServletContext()
							.getRealPath(restaurant.getLogoUrl());
					File oldLogoFile = new File(oldLogoPath == null ? "" : oldLogoPath);
					if (oldLogoFile.exists())
					{
						oldLogoFile.delete();
					}
					restaurant.setLogoUrl(path + "/" + uuidName);
					restaurantService.update(restaurant);
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
	 * @Description: 菜品特性图标上传
	 */
	public void menuFeatureIconUpload() throws IOException
	{
		// 检查是否通过类型和大小校验
		if(isCrossValidate)
		{
			Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
			json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
			if (logo != null)
			{
				for (int i = 0; i < logo.length; i++)
				{
					// 生成文件UUID名称
					String uuidName = StringUtil.getUUIDName(logoFileName[i]);
					// 保存路径
					String path = config.getConfigItem("menu.feature.icon");
					// 保存文件
					String saveName = ServletActionContext.getServletContext()
							.getRealPath(path) + File.separator + uuidName;
					ImageUtil.thumbnails(logo[i], new File(saveName), 20);
					// 更新特性IconUrl
					MenuFeature menuFeature = menuFeatureService.findById(id);
					String oldLogoPath = ServletActionContext.getServletContext()
							.getRealPath(menuFeature.getImageUrl());
					File oldLogoFile = new File(oldLogoPath == null ? "" : oldLogoPath);
					if (oldLogoFile.exists())
					{
						oldLogoFile.delete();
					}
					menuFeature.setImageUrl(path + "/" + uuidName);
					menuFeatureService.update(menuFeature);
				}
				json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
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
	 * @Description: 友情链接Logo上传
	 */
	public void friendshipLinkLogoUpload() throws IOException
	{
		// 检查是否通过类型和大小校验
		if(isCrossValidate)
		{
			Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
			json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
			if (logo != null)
			{
				for (int i = 0; i < logo.length; i++)
				{
					// 生成文件UUID名称
					String uuidName = StringUtil.getUUIDName(logoFileName[i]);
					// 保存路径
					String path = config.getConfigItem("friendship.link.logo");
					// 保存文件
					String saveName = ServletActionContext.getServletContext()
							.getRealPath(path) + File.separator + uuidName;
					ImageUtil.thumbnails(logo[i], new File(saveName), 25);
					// 更新特性IconUrl
					FriendshipLink friendshipLink = friendshipLinkService.findById(id);
					String oldLogoPath = ServletActionContext.getServletContext()
							.getRealPath(friendshipLink.getLogoUrl());
					File oldLogoFile = new File(oldLogoPath == null ? "" : oldLogoPath);
					if (oldLogoFile.exists())
					{
						oldLogoFile.delete();
					}
					friendshipLink.setLogoUrl(path + "/" + uuidName);
					friendshipLinkService.update(friendshipLink);
				}
				json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
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
	 * @Description: 积分兑换中商品的图片上传
	 */
	public void convertGoodsPicUpload() throws IOException
	{
		// 检查是否通过类型和大小校验
		if(isCrossValidate)
		{
			Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
			if (logo != null)
			{
				for (int i = 0; i < logo.length; i++)
				{
					// 生成文件UUID名称
					String uuidName = StringUtil.getUUIDName(logoFileName[i]);
					// 保存路径
					String path = config.getConfigItem("convertGoods.pic");
					// 保存文件
					String saveName = ServletActionContext.getServletContext()
							.getRealPath(path) + File.separator + uuidName;
					ImageUtil.thumbnails(logo[i], new File(saveName), 150);
					// 更新兑换物品PicUrl
					ConvertGoods convertGoods = convertGoodsService.findById(id);
					String oldLogoPath = ServletActionContext.getServletContext()
							.getRealPath(convertGoods.getPicUrl());
					File oldLogoFile = new File(oldLogoPath == null ? "" : oldLogoPath);
					if (oldLogoFile.exists())
					{
						oldLogoFile.delete();
					}
					convertGoods.setPicUrl(path + "/" + uuidName);
					convertGoodsService.update(convertGoods);
				}
				json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
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
	 * @Description: 手动校验文件类型和文件大小
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