package com.eatle.persistent.pojo.foundation.place;

import java.util.List;

public class District {
    private Long id;

    private String name;

    private String pinyinName;

    private Long parentId;
    
    
    //业务数据
    private List<District> childDistricts;
    private List<Community> communities;
    private List<School> shools;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyinName() {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

	public List<District> getChildDistricts() {
		return childDistricts;
	}

	public void setChildDistricts(List<District> childDistricts) {
		this.childDistricts = childDistricts;
	}

	public List<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}

	public List<School> getShools() {
		return shools;
	}

	public void setShools(List<School> shools) {
		this.shools = shools;
	}
}