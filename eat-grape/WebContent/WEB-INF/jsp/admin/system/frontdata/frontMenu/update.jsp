<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/frontdata/frontMenu/update.htm?action=zxgnxg&navTabId=${navTabId}" 
		class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input name="frontMenu.id" type="hidden" value="${frontMenu.id}">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>菜单名称：</label>
				<input name="frontMenu.name" class="required" type="text" maxlength="20" size="35" value="${frontMenu.name}" alt="请输入菜单名称"/>
			</p>
			<p>
				<label>链接URL：</label>
				<input name="frontMenu.url" type="text" maxlength="100" size="35" value="${frontMenu.url}"/>
			</p>
			<p>
				<label>父级菜单：</label>
				<select name="frontMenu.parentId" class="required combox">
					<option value="0">顶级菜单</option>
					<s:iterator value="#request.allFrontMenu" var="m">
						<option value="<s:property value="#m.id"/>" <s:if test="#m.id == #request.frontMenu.parentId">selected</s:if>>
							<s:property value="#m.name"/>
						</option>
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
