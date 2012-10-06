/**
 * @author soap
 * @date 2012-10-6
 */
package com.eatle.web.action.front;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.taglibs.standard.lang.jstl.ArraySuffix;

import com.eatle.persistent.pojo.foundation.place.Community;
import com.eatle.persistent.pojo.foundation.place.District;
import com.eatle.persistent.pojo.foundation.place.Shool;
import com.eatle.service.foundation.place.ICommunityService;
import com.eatle.service.foundation.place.IDistrictService;
import com.eatle.service.foundation.place.IShoolService;


/**
 *@Title: 前台首页Action
 *@Description:
 *@Author:xt
 *@Since:2012-10-6
 *@Version:1.1.0
 */
public class IndexAction {
	
	@Resource
    private IDistrictService districtService;
	@Resource
    private ICommunityService communityService;
	@Resource
    private IShoolService shoolService;
	
	private List<District> provinceList;
//	private Map map = new HashMap();
	
	public String showIndex(){
		List<District> list = districtService.findAll();
		
		Map<Long,List<District>> disMap = pushDistrictListIntoMap(list);
		provinceList = disMap.get(0L);
		if(provinceList==null) provinceList = Collections.emptyList();
		for(District provinceDist:provinceList){
			//得到市
			List<District> cityList = disMap.get(provinceDist.getId());
			provinceDist.setChildDistricts(cityList);
			if(cityList==null) cityList = Collections.emptyList();
			for(District cityDist:cityList){
				//得到区
				List<District> areaList = disMap.get(cityDist.getId());
				cityDist.setChildDistricts(areaList);
				
				//得到学校，社区
				List<Shool> shoolList = shoolService.findAll();
				List<Community> communityList = communityService.findAll();
				Map<Long,List<Shool>> shoolMap = pushShoolListIntoMap(shoolList);
				Map<Long,List<Community>> communityMap = pushCommunityListIntoMap(communityList);
				if(areaList==null) areaList = Collections.emptyList();
				for(District areaDist:areaList){
					List<Shool> shools = shoolMap.get(areaDist.getId());
					areaDist.setShools(shools);
					List<Community> communities = communityMap.get(areaDist.getId());
					areaDist.setCommunities(communities);
				}
			}
		}
		
		return "showIndex";	
	}
	
	private Map<Long,List<District>> pushDistrictListIntoMap(List<District> districtList){
		Map<Long,List<District>> disMap = new HashMap<Long, List<District>>();
		for(int i=0;i<districtList.size();i++){
			District district = districtList.get(i);
			Long parentId = district.getParentId();
			Long key = parentId;
			if(parentId==null||parentId==0){
				key = 0L;
			}
			List<District> disList = disMap.get(key);
			if(disList==null){
				disList = new ArrayList<District>();
			}
			disList.add(district);
			disMap.put(key, disList);
		}
		return disMap;
	}
	
	private Map<Long,List<Shool>> pushShoolListIntoMap(List<Shool> shoolList){
		Map<Long,List<Shool>> shoolMap = new HashMap<Long, List<Shool>>();
		for(int i=0;i<shoolList.size();i++){
			Shool shool = shoolList.get(i);
			Long distinctId = shool.getDistrictId();
			Long key = distinctId;
			if(distinctId==null||distinctId==0){
				key = 0L;
			}
			List<Shool> disList = shoolMap.get(key);
			if(disList==null){
				disList = new ArrayList<Shool>();
			}
			disList.add(shool);
			shoolMap.put(key, disList);
		}
		return shoolMap;
	}
	
	private Map<Long,List<Community>> pushCommunityListIntoMap(List<Community> communityList){
		Map<Long,List<Community>> communityMap = new HashMap<Long, List<Community>>();
		for(int i=0;i<communityList.size();i++){
			Community community = communityList.get(i);
			Long distinctId = community.getDistrictId();
			Long key = distinctId;
			if(distinctId==null||distinctId==0){
				key = 0L;
			}
			List<Community> disList = communityMap.get(key);
			if(disList==null){
				disList = new ArrayList<Community>();
			}
			disList.add(community);
			communityMap.put(key, disList);
		}
		return communityMap;
	}

	public List<District> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<District> provinceList) {
		this.provinceList = provinceList;
	}
}
