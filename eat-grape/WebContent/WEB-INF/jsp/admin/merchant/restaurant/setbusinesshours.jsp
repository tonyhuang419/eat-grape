<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script type="text/javascript" src="${ctx}/js/backend/merchant/setbusinesshours.js"></script>

<div class="pageContent">
	<form id="setBusinessHoursForm" method="post" action="${ctx}/admin/merchant/restaurant/setBusinessHours.htm?restaurant.id=${restaurant.id}&action=zxzhxg" class="pageForm required-validate" >
		<div id="businessHoursDiv" class="pageFormContent" layoutH="56" align="right">
			<span id="businessHours1" style="">
				<label>起始时间1：</label>
				<input type="text" id="startBusinessHours1" size="8" class="required date" format="HH:mm" readonly="true" value="${businessHours.arr0[0]}"/>
				<label>结束时间1：</label>
				<input type="text" id="endBusinessHours1" size="8" class="required date" format="HH:mm" readonly="true" value="${businessHours.arr0[1]}"/>
			</span>
			<p></p>
			<span id="businessHours2" style="<c:if test="${businessHours.arr1 == null}">display: none</c:if>">
				<label>起始时间2：</label>
				<input type="text" id="startBusinessHours2" size="8" class="required date" format="HH:mm" readonly="true" value="${businessHours.arr1[0]}"/>
				<label>结束时间2：</label>
				<input type="text" id="endBusinessHours2" size="8" class="required date" format="HH:mm" readonly="true" value="${businessHours.arr1[1]}"/>
			</span>
			<p></p>
			<span id="businessHours3" style="<c:if test="${businessHours.arr2 == null}">display: none</c:if>">
				<label>起始时间3：</label>
				<input type="text" id="startBusinessHours3" size="8" class="required date" format="HH:mm" readonly="true" value="${businessHours.arr2[0]}"/>
				<label>结束时间3：</label>
				<input type="text" id="endBusinessHours3" size="8" class="required date" format="HH:mm" readonly="true" value="${businessHours.arr2[1]}"/>
			</span>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button id="setBusinessHoursButton" type="button">保存设置</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消关闭</button></div></div></li>
			</ul>
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button id="addBusinessHoursButton" type="button">添加时间段</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button id="deleteBusinessHoursButton" type="button">删除时间段</button></div></div></li>
			</ul>
		</div>
	</form>
</div>