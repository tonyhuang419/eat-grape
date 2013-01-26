<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/frontdata/systemNotice/update.htm?action=zxzhxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input name="systemNotice.id" type="hidden" value="${systemNotice.id}" />
			<p>
				<label>公告标题：</label>
				<input name="systemNotice.title" class="required" type="text" size="30" alt="请输入公告标题" value="${systemNotice.title}"/>
			</p>
			<p>
				<label>公告内容：</label>
				<input type="text" name="systemNotice.content" class="textInput" alt="请输入公告内容" value="${systemNotice.content}">
			</p>
			<p>
				<label>公告对象：</label>
				<select name="systemNotice.target" class="required combox">
					<s:iterator value="#request.userIdentity" var="ui">
						<option value="${ui.key}" <s:if test="#request.systemNotice.target == #ui.key">selected</s:if>>${ui.value}</option>
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
