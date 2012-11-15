<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/useradmin/priv/add.htm?navTabId=${navTabId}&action=zxqxtj&dialogId=${dialogId}" class="pageForm required-validate"
			 onsubmit="return validateCallback(this, <s:if test="#attr.dialogId != \"\"">refreshDialogAjaxDone</s:if><s:else>dialogAjaxDone</s:else>);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="priv.pid" value="${param.pid}">
			<p>
				<label>权限名称：</label>
				<input name="priv.privName" class="required" type="text" size="35" alt="请输入权限名称"/>
			</p>
			<p>
				<label>菜单名称：</label>
				<input name="priv.meueName" type="text" size="35" alt="请输入菜单名称"/>
			</p>
			<p>
				<label>动作标识：</label>
				<input name="priv.action" type="text" size="35" alt="请输入动作标识"/>
			</p>
			<p>
				<label>描述：</label>
				<input type="text" value="" name="priv.description" size="35">
			</p>
			<p>
				<label>是否显示：</label>
				<input type="checkbox" name="priv.isShow" value="1"/>
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
