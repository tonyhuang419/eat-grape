<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/systemdata/menu/add.htm?action=zxgntj&navTabId=${navTabId}" 
		class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>Rel标识：</label>
				<input name="menu.rel" class="required" type="text" maxlength="20"  alt="请输入Rel标识"/>
			</p>
			<p>
				<label>菜单名称：</label>
				<input name="menu.menuName" class="required" type="text" maxlength="20"  alt="请输入菜单名称"/>
			</p>
			<p>
				<label>链接URL：</label>
				<input name="menu.url" type="text" maxlength="100" size="35"/>
			</p>
			<p>
				<label>动作标识：</label>
				<input name="menu.action" type="text" maxlength="100" class="text">
			</p>
			<p>
				<label>父级菜单：</label>
				<select name="menu.parentId" class="required combox">
					<option value="0">顶级菜单</option>
					<s:iterator value="#request.allMenu" var="m">
						<option value="<s:property value="#m.id"/>" <s:if test="#m.id == #request.menu.parentId">selected</s:if>>
							<s:property value="#m.menuName"/>
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
