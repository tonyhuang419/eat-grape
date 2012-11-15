<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/frontdata/serviceInformation/add.htm?action=zxzhtj&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>QQ：</label>
				<input type="text" name="serviceInformation.serveQq" class="required digits" alt="请输入QQ">
			</p>
			<p>
				<label>电话：</label>
				<input name="serviceInformation.serveTel" class="required phone" type="text" size="30"  alt="请输入电话号码"/>
			</p>
			<p>
				<label>手机：</label>
				<input name="serviceInformation.serveMobile" class="phone" type="text" size="30" alt="请输入手机号码"/>
			</p>
			<p>
				<label>E-mail：</label>
				<input type="text" name="serviceInformation.serveEmail" class="email" alt="请输入邮箱">
			</p>
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
