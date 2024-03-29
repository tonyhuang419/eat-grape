<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/useradmin/account/update.htm?action=zxzhxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input name="user.id" type="hidden" value="${user.id}" />
			<p>
				<label>用户名称：</label>
				<input name="user.userName" class="required" type="text" size="35" value="${user.userName}" alt="请输入用户名称" style="ime-mode: disabled;"/>
			</p>
			<p>
				<label>密码：</label>
				<input name="user.pwd" class="required" type="text" size="35" value="${user.pwd}" alt="请输入密码" style="ime-mode: disabled;"/>
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" class="email" name="user.email" size="35" value="${user.email}" alt="请输入邮箱">
			</p>
			<p>
				<label>用户类型：</label>
				<select name="user.type" class="required combox">
					<s:iterator value="#request.userType" var="ut">
						<option value="${ut.key}" <s:if test="#request.user.type == #ut.key">selected</s:if>>${ut.value}</option>
					</s:iterator>
				</select>
			</p>
			<p>
				<label>角色类型：</label>
				<select name="user.roleId" class="required combox">
					<s:iterator value="#request.allRole" var="r">
						<option value="${r.id}" <s:if test="#request.user.roleId == #r.id">selected</s:if>>
							${r.roleName}
						</option>
					</s:iterator>
				</select>
			</p>
			<p>
				<label>所属商家：</label>
				<select name="user.merchantId" class="required combox">
					<s:iterator value="#request.allMerchant" var="m">
						<option value="${m.id}" <s:if test="#request.user.merchantId == #m.id">selected</s:if>>
							${m.merchantName}
						</option>
					</s:iterator>
				</select>
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
