<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/merchant/restaurant/add.htm?action=zxzhxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56" align="right">
			<input name="restaurant.merchantId" type="hidden" value="${param.merchantId}" />
			<p>
				<label>餐厅名称：</label>
				<input type="text"  name="restaurant.name" size="30" class="required" />
			</p>
			<p>
				<label>联&nbsp;&nbsp;系&nbsp;&nbsp;人：</label>
				<input  type="text" name="restaurant.contactName" size="30" class="required" />
			</p>
			<p>
				<label>联系电话：</label>
				<input type="text" name="restaurant.contactPhone" size="30" class="phone" >
			</p>
			<p>
				<label>联系邮箱：</label>
				<input type="text" name="restaurant.contactEmail" size="30" class="email" >
			</p>
			<p>
				<label>联系Q Q：</label>
				<input type="text" name="restaurant.contactQq" size="30" class="textInput" >
			</p>
			<p>
				<label>起送价格：</label>
				<input type="text" name="restaurant.sendUpPrice" size="30" class="digits" >
			</p>
			<dl class="nowrap">
				<dt>餐厅地址：</dt>
				<dd><input type="text" name="restaurant.address" size="106" class="textInput" ></dd>
			</dl>
			<dl class="nowrap">
				<dt>送餐说明：</dt>
				<dd><textarea cols="91" rows="5" name="restaurant.sendMealsDescription"></textarea></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
