package com.eatle.web.action.backend.foundation.scoreshop;

import com.eatle.persistent.pojo.foundation.scoreshop.ConvertGoods;
import com.eatle.service.foundation.scoreshop.IConvertGoodsService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

public class ConvertGoodsAction extends BaseAction
{
	private static final long serialVersionUID = 5301313662329366416L;

	@Resource
	private IConvertGoodsService convertGoodsService;

	private Pagination page;

	private ConvertGoods convertGoods;

	public void setPage(Pagination page)
	{
		this.page = page;
	}

	public Pagination getPage()
	{
		return this.page;
	}

	public ConvertGoods getConvertGoods()
	{
		return convertGoods;
	}

	public void setConvertGoods(ConvertGoods convertGoods)
	{
		this.convertGoods = convertGoods;
	}

	public String showIndex()
	{
		Map<String, Object> params = super.getRequestParameters(request);
		int pageNum = Pagination.CURRENTPAGE;
		int pageSize = Pagination.PAGESIZE;
		if (params.containsKey("pageNum"))
		{
			pageNum = Integer.parseInt((String) params.get("pageNum"));
		}
		if (params.containsKey("numPerPage"))
		{
			pageSize = Integer.parseInt((String) params.get("numPerPage"));
		}
		page = convertGoodsService.findPagination(params, pageNum, pageSize);
		return "showIndex";
	}

	public String showAdd()
	{
		return "showAdd";
	}

	public void add() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (convertGoods == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			convertGoodsService.add(convertGoods);
		}
		super.writeMap(json);
	}

	public void delete() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
		if (convertGoods == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			convertGoodsService.delete(convertGoods);
		}
		super.writeMap(json);
	}

	public String showUpdate()
	{
		convertGoods = convertGoodsService.findById(convertGoods.getId());
		return "showUpdate";
	}

	public void update() throws IOException
	{
		Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
		json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
		if (convertGoods == null)
		{
			json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
			json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
		}
		else
		{
			convertGoodsService.update(convertGoods);
		}
		super.writeMap(json);
	}

	/**
	 * @Description: 显示详细信息
	 */
	public String showDetail()
	{
		convertGoods = convertGoodsService.findById(convertGoods.getId());
		return "showDetail";
	}

	/**
	 * @Description: 显示商品图片上传
	 */
	public String showPicUpload()
	{
		return "showPicUpload";
	}
}