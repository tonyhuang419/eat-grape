<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/merchant/list/merchantLogoUpload.htm?action=zxzhxg&navTabId=${param.navTabId}" enctype="multipart/form-data" class="pageForm required-validate" >
		<div class="pageFormContent" layoutH="56" align="right">
			<input name="id" type="hidden" value="${merchant.id}" />
			<p>
				<label>选择图片：</label>
				<input name="logo" type="file" class="textInput">
			</p>
			<p>
				<label><s:fielderror/></label>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">上传</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>