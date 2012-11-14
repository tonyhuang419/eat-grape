<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/frontdata/friendshipLink/update.htm?action=zxzhxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input name="friendshipLink.id" type="hidden" value="${friendshipLink.id}" />
			<p>
				<label>链接名称：</label>
				<input name="friendshipLink.linkName" class="required" value="${friendshipLink.linkName}" type="text" size="30" alt="请输入链接名称"/>
			</p>
			<p>
				<label>链接地址：</label>
				<input name="friendshipLink.linkUrl" class="required" value="${friendshipLink.linkUrl}" type="text" size="30"  alt="请输入链接地址"/>
			</p>
			<p>
				<label>排序编号：</label>
				<input name="friendshipLink.sortOrder" class="textInput" value="${friendshipLink.sortOrder}" type="text" alt="请输入排序编号">
			</p>
			<p>
				<label>首页展示：</label>
				<select class="combox" name="friendshipLink.isDisplay">
					<option value="0" <s:if test="friendshipLink.isDisplay == 0">selected</s:if>>是</option>
					<option value="1" <s:if test="friendshipLink.isDisplay == 1">selected</s:if>>否</option>
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
