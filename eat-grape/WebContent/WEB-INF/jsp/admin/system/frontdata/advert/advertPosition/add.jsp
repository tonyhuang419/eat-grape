<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/frontdata/advert/add.htm?action=zxzhtj&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>用户名称：</label>
				<input name="advert.userName" class="required" type="text" size="30" alt="请输入用户名称"/>
			</p>
			<p>
				<label>密码：</label>
				<input name="advert.pwd" class="required" type="text" size="30"  alt="请输入密码"/>
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text"  value="" name="advert.email" class="textInput" alt="请输入邮箱">
			</p>
			<p>
				<label>用户类型：</label>
				<select name="advert.type" class="required combox">
					<option value="1">个人</option>
					<option value="2" selected>公司</option>
				</select>
			</p>
			<p>
				<label>角色类型：</label>
				<select name="advert.roleId" class="required combox">
					<s:iterator value="#request.allRole" var="r">
						<option value="${r.id}">${r.roleName}</option>
					</s:iterator>
				</select>
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
