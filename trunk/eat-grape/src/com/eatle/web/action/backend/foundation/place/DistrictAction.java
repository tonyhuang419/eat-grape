package com.eatle.web.action.backend.foundation.place;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria;
import com.eatle.persistent.pojo.foundation.place.DistrictCriteria.Criteria;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.utils.DwzAjaxJsonUtil;
import com.eatle.utils.Pagination;
import com.eatle.web.action.BaseAction;

public class DistrictAction extends BaseAction {
	private static final long serialVersionUID = 1222415210116823784L;

	@Resource
    private IDistrictService districtService;

    private Pagination page;

    private District district;
    private List<District> list;

    public String showIndex() {
        Map<String,Object> params = super.getRequestParameters(request);
        int pageNum = Pagination.CURRENTPAGE;
        int pageSize = Pagination.PAGESIZE;
        if(params.containsKey("pageNum")){
            pageNum = Integer.parseInt((String)params.get("pageNum"));
        }
        if(params.containsKey("numPerPage")){
            pageSize = Integer.parseInt((String)params.get("numPerPage"));
        }
		params.put("pidIsNull", true);
        page = districtService.findPagination(params, pageNum, pageSize);
        return "showIndex";
    }

    public String showAdd() {
        return "showAdd";
    }

    public void add() throws IOException {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(district == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            districtService.add(district);
        }
        super.writeMap(json);
    }

    public void delete() throws IOException {
        Map<String, Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        json.put(DwzAjaxJsonUtil.KEY_CALLBACKTYPE, "");
        if(district == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            districtService.delete(district);
        }
        super.writeMap(json);
    }

    public String showUpdate() {
        district = districtService.findById(district.getId());
        return "showUpdate";
    }

    public void update() throws IOException {
        Map<String,Object> json = DwzAjaxJsonUtil.getDefaultAjaxJson();
        json.put(DwzAjaxJsonUtil.KEY_NAVTABID, navTabId);
        if(district == null){
            json.put(DwzAjaxJsonUtil.KEY_STATUSCODE, 300);
            json.put(DwzAjaxJsonUtil.KEY_MESSAGE, "操作失败！");
        }else{
            districtService.update(district);
        }
        super.writeMap(json);
    }
    
    public String showSetSubDist()
	{
		Map<String, Object> params = super.getRequestParameters(request);
		Object parentId = params.get("pid");
		DistrictCriteria distinctCriteria = new DistrictCriteria();
		Criteria criteria = distinctCriteria.createCriteria();
		criteria.andParentIdIsNotNull();
		criteria.andParentIdEqualTo(Long.parseLong((String) parentId));
		list = districtService.findByCriteria(distinctCriteria);

		return "showSetSubDist";
	}
    
    public void setPage(Pagination page) {
        this.page = page;
    }

    public Pagination getPage() {
        return this.page;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
	public District getDistrict() {
		return district;
	}

	public List<District> getList() {
		return list;
	}

	public void setList(List<District> list) {
		this.list = list;
	}
}