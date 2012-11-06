<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form id="uploadForm" method="post" action="${ctx}/admin/foundation/dictionary/menuFeature/menuFeatureIconUpload.htm?id=${menuFeature.id}&action=zxzhxg" enctype="multipart/form-data" class="pageForm required-validate" >
		<div class="pageFormContent" layoutH="56" align="right">
			<p>
				<label>选择图片：</label>
				<input id="logoFile" name="logo" type="file" class="textInput required">
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="return ajaxFileUpload();">设置</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>