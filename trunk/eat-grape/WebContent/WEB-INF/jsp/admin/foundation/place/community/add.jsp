<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/foundation/place/community/add.htm?navTabId=${navTabId}&action=zxdytj&dialogId=${dialogId}" class="pageForm required-validate"
			 onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>社区名称：</label>
				<input name="community.name" class="required" type="text" size="35" alt="请输入社区名称"/>
			</p>
			<p>
				<label>名称拼音：</label>
				<input name="community.pinyinName" type="text" size="35" alt="请输入名称拼音"/>
			</p>
				<label>所属区域：</label>
				<select class="combox" id="w_combox_province" ref="w_combox_city" refUrl="${ctx}/admin/foundation/place/district/getDistrictsByParentId.htm?district.parentId={value}">
					<option value="-1">省份</option>
					<s:iterator value="#request.topLevelDistrict" id="d">
						<option value="${d.id}">${d.name}</option>
					</s:iterator>
				</select>
				<select class="combox" id="w_combox_city" ref="w_combox_area" refUrl="${ctx}/admin/foundation/place/district/getDistrictsByParentId.htm?district.parentId={value}">
					<option value="">城市</option>
				</select>
				<select class="combox" id="w_combox_area" ref="w_combox_district" refUrl="${ctx}/admin/foundation/place/district/getDistrictsByParentId.htm?district.parentId={value}">
					<option value="">区县</option>
				</select>
				<select class="combox" id="w_combox_district" name="community.districtId">
					<option value="">区域</option>
				</select>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
