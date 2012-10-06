<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/foundation/place/district/update.htm?action=zxdyxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input name="district.id" type="hidden" value="${district.id}" />
			<input name="district.parentId" type="hidden" value="${district.parentId}" />
			<p>
				<label>地域名称：</label>
				<input name="district.name" class="required" type="text" size="30"  value="${district.name}" alt="请输入地域名称"/>
			</p>
			<p>
				<label>地域拼音名称：</label>
				<input name="district.pinyinName"  type="text" size="30"   value="${district.pinyinName}" alt="请输入地域拼音名称" />
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
