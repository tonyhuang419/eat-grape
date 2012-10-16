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
				<input name="merchant.merchantPhone" type="text" size="30" class="required phone" />
			</p>
			<dl class="nowrap">
				<dt>商家地址：</dt>
				<dd><input type="text" name="merchant.merchantAddress" size="106" class="required" /></dd>
			</dl>
			<p>
				<label>商家邮箱：</label>
				<input type="text" name="merchant.merchantEmail" size="30" class="email" />
			</p>
			<p>
				<label>法定代表人：</label>
				<input type="text" name="merchant.legalName" size="30" class="textInput" />
			</p>
			<p>
				<label>身份证号：</label>
				<input type="text" name="merchant.legalIdCard" size="30" class="textInput" />
			</p>
			<p>
				<label>法定人电话：</label>
				<input type="text" name="merchant.legalPhone" size="30" class="phone" />
			</p>
			<dl class="nowrap">
				<dt>家庭地址：</dt>
				<dd><input type="text" name="merchant.legalHomeAddress" size="106" class="textInput" /></dd>
			</dl>
			<dl class="nowrap">
				<dt>现居地址：</dt>
				<dd><input type="text" name="merchant.legalAddress" size="106" class="textInput" /></dd>
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