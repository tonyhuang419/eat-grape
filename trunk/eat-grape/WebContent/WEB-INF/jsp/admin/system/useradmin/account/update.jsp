<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/useradmin/account/update.htm?action=zxzhxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input name="user.id" type="hidden" value="${user.id}" />
			<p>
				<label>用户名称：</label>
				<input name="user.userName" class="required" type="text" size="35" value="${user.userName}" alt="请输入用户名称"/>
			</p>
			<p>
				<label>密码：</label>
				<input name="user.pwd" class="required" type="text" size="35" value="${user.pwd}" alt="请输入密码"/>
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" name="user.email" size="35" value="${user.email}" alt="请输入邮箱">
			</p>
			<p>
				<label>用户类型：</label>
				<select name="user.type" class="required combox">
					<option value="0" <s:if test="user.type == 0">selected</s:if> >管理员</option>
					<option value="1" <s:if test="user.type == 1">selected</s:if> >个人</option>
					<option value="2" <s:if test="user.type == 2">selected</s:if> >公司</option>
				</select>
			</p>
			<p>
				<label>角色类型：</label>
				<select name="user.roleId" class="required combox">
					<s:iterator value="#request.allRole" var="r">
						<option value="${r.id}" <s:if test="#r.id == #request.user.roleId">selected</s:if>>
							${r.roleName}
						</option>
					</s:iterator>
				</select>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
