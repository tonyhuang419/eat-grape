<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/system/frontdata/advert/advertPosition/add.htm?action=zxzhtj&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</label>
				<input type="text" name="advertPosition.positionName" class="required" size="30" alt="请输入广告位名称"/>
			</p>
			<p>
				<label>宽&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</label>
				<input type="text" name="advertPosition.positionWidth" class="required digits" size="30" alt="请输入宽度" maxlength="4"/>
			</p>
			<p>
				<label>高&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</label>
				<input type="text" name="advertPosition.positionHeight" class="required digits" size="30" alt="请输入高度" maxlength="4">
			</p>
			<dl class="nowrap">
				<dt>描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</dt>
				<dd><input type="text" name="advertPosition.positionDescription" class="textInput" size="67"></dd>
			</dl>
			<dl class="nowrap">
				<dt>模版代码：</dt>
				<dd><textarea cols="50" rows="5" name="advertPosition.positionStyle"></textarea></dd>
			</dl>
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
