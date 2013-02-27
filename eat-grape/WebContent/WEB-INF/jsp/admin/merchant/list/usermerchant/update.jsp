<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script type="text/javascript" src="${ctx}/js/backend/merchant/usermerchant/update.js"></script>
<div class="pageContent">
	<form id="addUserMerchantForm" method="post" action="${ctx}/admin/merchant/list/usermerchant/update.htm?action=zxzhxg&navTabId=${param.navTabId}" class="pageForm required-validate">
		<input type="hidden" name="userMerchant.id" value="${userMerchant.id}"/>
		<input type="hidden" name="userMerchant.merchantId" value="${userMerchant.merchantId}"/>
		<div class="pageFormContent" layoutH="56" align="right">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		    <tr>
		      <td>第一步：请选择账号</td>
		      <td>第二步：请选择该账号管辖的餐厅</td>
		    </tr>
		    <tr>
		      <td>
		      	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		      		<s:iterator value="#request.users" id="u">
			        	<tr>
			          		<td>
			          			<label>
			          				<input name="userMerchant.userId" type="radio" value="${u.id}" title="${u.userName}" <s:if test="#u.id == userMerchant.userId">checked="checked"</s:if>/>${u.userName}
			          			</label>
			          		</td>
			        	</tr>
		        	</s:iterator>
		      	</table>
		      </td>
		      <td>
		      	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		      		<s:iterator value="#request.restaurants" id="r">
			        	<tr>
			          		<td>
			          			<label>
			          				<input name="userMerchant.manageRestaurantList" type="checkbox" value="${r.id}" <s:if test="#r.isManaged">checked="checked"</s:if>/>${r.name}
			          			</label>
			          		</td>
			        	</tr>
			        </s:iterator>
		      	</table>
		      </td>
		    </tr>
		  </table>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>