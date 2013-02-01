<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script type="text/javascript" src="${ctx}/js/backend/merchant/restaurant/sendplace/addSendSchool.js"></script>

<div class="pageContent">
	<form id="addForm" method="post" action="${ctx}/admin/merchant/restaurant/sendplace/addSendSchool.htm?navTabId=${navTabId}&action=zxdytj&dialogId=${dialogId}" 
		class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input name="schoolRestaurant.restaurantId" type="hidden" value="${restaurant.id}" />
			<label>选择送餐学校：</label>
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
			<select class="combox" id="w_combox_district" ref="w_combox_school" refUrl="${ctx}/admin/foundation/place/school/getSchoolsByDistrictId.htm?school.districtId={value}">
				<option value="">区域</option>
			</select>
			<select class="combox" id="w_combox_school" name="schoolRestaurant.schoolId">
				<option value="">学校</option>
			</select>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="validate();">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>