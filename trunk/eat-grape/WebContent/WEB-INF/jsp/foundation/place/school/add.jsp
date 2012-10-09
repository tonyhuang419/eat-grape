<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script type="text/javascript">
	function checkProvince()
	{
		var selectProvince = $("#w_combox_province").find("option:selected").text();
		if(selectProvince.indexOf("北京") >= 0 || selectProvince.indexOf("天津") >= 0 ||
			selectProvince.indexOf("上海") >= 0 || selectProvince.indexOf("重庆") >= 0)
		{
			$("#district").css({"display" : "none"});
			$("#w_combox_city").attr({"ref" : "w_combox_district"});
		}
		else
		{
			$("#district").css({"display" : ""});
			$("#w_combox_city").attr({"ref" : "w_combox_area"});
		}
	}
</script>

<div class="pageContent">
	<form method="post" action="${ctx}/foundation/place/school/add.htm?navTabId=${navTabId}&action=zxdytj&dialogId=${dialogId}" 
		class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>学校名称：</label>
				<input name="school.name" class="required" type="text" size="30"  alt="请输入学校名称"/>
			</p>
			<p>
				<label>英文名称：</label>
				<input name="school.englishName"  type="text" size="30"  alt="请输入英文名称"/>
			</p>
				<label>所属区域：</label>
				<select class="combox" id="w_combox_province" ref="w_combox_city" onchange="checkProvince()" refUrl="${ctx}/foundation/place/district/getDistrictsByParentId.htm?district.parentId={value}">
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
