<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/foundation/place/school/update.htm?action=zxdyxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input name="school.id" type="hidden" value="${school.id}" />
			<p>
				<label>学校名称：</label>
				<input name="school.name" class="required" type="text" size="30"  value="${school.name}" alt="请输入学校名称"/>
			</p>
			<p>
				<label>英文名称：</label>
				<input name="school.englishName"  type="text" size="30"   value="${school.englishName}" alt="请输入英文名称" />
			</p>
				<label>所属区域：</label>
				<select class="combox" id="w_combox_province" ref="w_combox_city" onchange="checkProvince()" refUrl="${ctx}/foundation/place/district/getDistrictsByParentId.htm?district.parentId={value}">
					<option></option> 
					<s:iterator value="#request.topLevelDistrict" id="d">
						<option value="${d.id}">${d.name}</option>
					</s:iterator>
				</select>
				<select class="combox" id="w_combox_city" ref="w_combox_area" refUrl="${ctx}/foundation/place/district/getDistrictsByParentId.htm?district.parentId={value}"></select>
				<span id="district">
					<select class="combox" id="w_combox_area" ref="w_combox_district" refUrl="${ctx}/foundation/place/district/getDistrictsByParentId.htm?district.parentId={value}"></select>
				</span>
				<select class="combox" id="w_combox_district" name="school.districtId"></select>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
