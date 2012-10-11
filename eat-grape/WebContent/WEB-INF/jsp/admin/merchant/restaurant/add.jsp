<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/merchant/list/add.htm?action=zxzhxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56" align="right">
			<p>
				<label>商家名称：</label>
				<input name="merchant.merchantName" type="text" size="30" class="required" />
			</p>
			<p>
				<label>商家电话：</label>
				<input name="merchant.merchantPhone" type="text" size="30" class="required" />
			</p>
			<p>
				<label>商家地址：</label>
				<input type="text"  name="merchant.merchantAddress" size="30" class="required" >
			</p>
			<p>
				<label>商家邮箱：</label>
				<input type="text"  name="merchant.merchantEmail" size="30" class="textInput" >
			</p>
			<p>
				<label>商家Logo：</label>
				<input type="text"  name="merchant.merchantLogoUrl" size="30" class="textInput" >
			</p>
			<p>
				<label>法定代表人：</label>
				<input type="text"  name="merchant.legalName" size="30" class="textInput" >
			</p>
			<p>
				<label>身份证号码：</label>
				<input type="text"  name="merchant.legalIdCard" size="30" class="textInput" >
			</p>
			<p>
				<label>法定人电话：</label>
				<input type="text"  name="merchant.legalPhone" size="30" class="textInput" >
			</p>
			<p>
				<label>法定人家庭地址：</label>
				<input type="text"  name="merchant.legalHomeAddress" size="30" class="textInput" >
			</p>
			<p>
				<label>法定人现居地址：</label>
				<input type="text"  name="merchant.legalAddress" size="30" class="textInput" >
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
