<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/frontdata/systemNotice/add.htm?action=zxzhtj&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>公告标题：</label>
				<input name="systemNotice.title" class="required" type="text" size="30" alt="请输入公告标题"/>
			</p>
			<p>
				<label>公告内容：</label>
				<input type="text" name="systemNotice.content" size="30" class="required" alt="请输入公告内容">
			</p>
			<p>
				<label>公告对象：</label>
				<select name="systemNotice.target" class="required combox">
					<option value="" selected>公告对象</option>
					<s:iterator value="#request.userIdentity" var="ui">
						<option value="${ui.key}">${ui.value}</option>
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
